package com.hhj.merchant.ui.zxing.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.FlashLightManager;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GoodsInfoBean;
import com.hhj.merchant.ui.shop.activity.UpdatePassWordActivity;
import com.hhj.merchant.ui.shop.activity.UpdatePhoneActivity;
import com.hhj.merchant.ui.zxing.adapter.GoodsInfoAdapter;
import com.hhj.merchant.ui.zxing.camera.CameraManager;
import com.hhj.merchant.ui.zxing.contract.CaptureContract;
import com.hhj.merchant.ui.zxing.decoding.CaptureActivityHandler;
import com.hhj.merchant.ui.zxing.decoding.InactivityTimer;
import com.hhj.merchant.ui.zxing.presenter.CapturePresenter;
import com.hhj.merchant.ui.zxing.view.ViewfinderView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import butterknife.BindView;
import butterknife.OnClick;

public class CaptureActivity extends BaseActivity<CapturePresenter> implements CaptureContract, SurfaceHolder.Callback {
    @BindView(R.id.viewfinder_content)
    ViewfinderView viewfinderView;
    @BindView(R.id.scanner_view)
    SurfaceView surfaceView;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv_count)
    TextView tv_count;
    @BindView(R.id.tv_money)
    TextView tv_money;
    @BindView(R.id.ll_goods_list)
    LinearLayout ll_goods_list;
    private FlashLightManager flashLightManager;
    private boolean hasSurface;
    private InactivityTimer inactivityTimer;
    private CaptureActivityHandler handler;
    private Vector<BarcodeFormat> decodeFormats = null;
    private String characterSet = null;
    private SurfaceHolder surfaceHolder;
    private boolean playBeep;
    private MediaPlayer mediaPlayer;
    private boolean vibrate;
    private static final float BEEP_VOLUME = 0.10f;
    private String flag;
    private Map<String, String> map;
    private GoodsInfoAdapter mAdapter;
    private List<GoodsInfoBean> list;
    private int count = 0;
    private Double money = 0.0;
    public boolean isUpdate = false;
    private List<Map<String, String>> mapList;
    private Dialog dialog;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_capture;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this);
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        flag = getIntent().getStringExtra(Global.FLAG);
        CameraManager.init(getApplication());
        flashLightManager = new FlashLightManager(this);
        hasSurface = false;
        inactivityTimer = new InactivityTimer(this);
        tv_count.setText(count + "");
        tv_money.setText(count + "");
    }

    @Override
    protected void onResume() {
        super.onResume();
        surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(this);
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
        playBeep = true;
        AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            playBeep = false;
        }
        initBeepSound();
        vibrate = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        CameraManager.get().closeDriver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        inactivityTimer.shutdown();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initBeepSound() {
        if (playBeep && mediaPlayer == null) {
            // The volume on STREAM_SYSTEM is not adjustable, and users found it
            // too loud,
            // so we now play on the music stream.
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(beepListener);

            AssetFileDescriptor file = getResources().openRawResourceFd(
                    R.raw.beep);
            try {
                mediaPlayer.setDataSource(file.getFileDescriptor(),
                        file.getStartOffset(), file.getLength());
                file.close();
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepare();
            } catch (IOException e) {
                mediaPlayer = null;
            }
        }
    }

    /**
     * When the beep has finished playing, rewind to queue up another one.
     * 当哔哔声结束播放，倒带排队另一个
     */
    private final MediaPlayer.OnCompletionListener beepListener = new MediaPlayer.OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    public ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    public Handler getHandler() {
        return handler;
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();

    }

    public void handleDecode(Result result, Bitmap barcode) {
        inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        String resultString = result.getText();
        if (StringUtils.isEmpty(flag)) {
            ToastUtils.showShort("扫描码错误");
        } else {
            //扫码卖货
            if (resultString.length() < 15) {
                map = new HashMap<>();
                map.put("barCode", resultString);
                mPresenter.getGoodsInfo(map);
            } else {
                map = new HashMap<>();
                map.put("orderSn", resultString);
                mPresenter.verifyOrder(map);
            }
        }
    }

    private static final long VIBRATE_DURATION = 200L;

    private void playBeepSoundAndVibrate() {
        if (playBeep && mediaPlayer != null) {
            mediaPlayer.start();
        }
        if (vibrate) {
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(VIBRATE_DURATION);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
        } catch (IOException ioe) {
            return;
        } catch (RuntimeException e) {
            return;
        }
        if (handler == null) {
            handler = new CaptureActivityHandler(this, decodeFormats,
                    characterSet);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;
        if (CameraManager.get() != null) {
            CameraManager.get().stopPreview();
        }
    }

    @Override
    public void getGoodsInfo(GoodsInfoBean bean) {
        if (null == mAdapter) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            mAdapter = new GoodsInfoAdapter(new GoodsInfoAdapter.ViewClick() {
                @Override
                public void onClick(int id, int number, String price) {
                    if (id == R.id.iv_jian) {
                        if (count > 1) {
                            count--;
                            tv_money.setText("总价: " + (money -= Double.parseDouble(price)));
                        }
                    } else if (id == R.id.iv_jia) {
                        count++;
                        tv_money.setText("总价: " + (money += Double.parseDouble(price)));
                    }
                    tv_count.setText("数量: " + count);
                }
            });
            mRecyclerView.setAdapter(mAdapter);
            list = new ArrayList<>();
        }
        if (null != list && list.size() > 0) {
            for (GoodsInfoBean goodsInfoBean : list) {
                if (bean.getProductGoodsId().equals(goodsInfoBean.getProductGoodsId())) {
                    isUpdate = true;
                    goodsInfoBean.setCount(goodsInfoBean.getCount() + 1);
                    goodsInfoBean.setMoney(goodsInfoBean.getMoney() + Double.parseDouble(goodsInfoBean.getPrice()));
                }
            }
        }
        if (!isUpdate) {
            bean.setCount(1);
            bean.setMoney(Double.parseDouble(bean.getPrice()));
            list.add(bean);
        }
        count++;
        tv_count.setText("数量: " + count);
        tv_money.setText("总价: " + (money += Double.parseDouble(bean.getPrice())));
        mAdapter.setNewData(list);
        ll_goods_list.setVisibility(View.VISIBLE);
        isUpdate = false;
    }

    @Override
    public void saleRecord(BaseBean bean) {
        showDialog("商品总价" + money + "元,请线下支付");
    }

    @Override
    public void verifyOrder(BaseBean bean) {
        showDialog("核销成功");
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @OnClick({R.id.tv_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_buy:
                if (count != 0) {
                    mapList = new ArrayList<>();
                    for (GoodsInfoBean goodsInfoBean : list) {
                        Map<String, String> map = new HashMap<>();
                        map.put("number", goodsInfoBean.getCount() + "");
                        map.put("productGoodsId", goodsInfoBean.getProductGoodsId());
                        mapList.add(map);
                    }
                    mPresenter.saleRecord(mapList);
                }
                break;
        }
    }

    private void showDialog(String message) {
        dialog = DialogWrapper.
                tipDialog().
                context(mContext).
                title("提示").
                message(message).
                buttonType(DialogWrapper.BUTTON_SINGLE).
                singleButtonText("确定").
                closeImageVisible(false).
                cancelable(true, true).
                buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                    @Override
                    public void onLeftButtonClicked(TextView view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onSingleButtonClicked(TextView view) {
                        dialog.dismiss();
                        finish();
                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        dialog.dismiss();
                    }
                }).build();
        dialog.show();
    }
}
