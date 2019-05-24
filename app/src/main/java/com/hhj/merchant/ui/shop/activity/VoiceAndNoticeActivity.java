package com.hhj.merchant.ui.shop.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationManagerCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.hhj.merchant.R;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Notification.EXTRA_CHANNEL_ID;
import static android.provider.Settings.EXTRA_APP_PACKAGE;

public class VoiceAndNoticeActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener {
    @BindView(R.id.ll_NotificationTip)
    LinearLayout ll_NotificationTip;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tb_is_shock)
    ToggleButton tb_is_shock;
    @BindView(R.id.tb_sound_max)
    ToggleButton tb_sound_max;
    private AudioManager am;
    private int maxVolume;
    private VolumeReceiver receiver;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_voice_and_notice;
    }

    @Override
    protected boolean enableSwipeBack() {
        return false;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        tb_is_shock.setChecked(SPUtils.getInstance().getBoolean(Global.OPEN_VIBRATE));
        //获取系统最大音量
        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        seekBar.setMax(maxVolume);
        //获取当前音量
        int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar.setProgress(currentVolume);
        tb_sound_max.setChecked(maxVolume == currentVolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    //设置系统音量
                    am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
                    int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                    seekBar.setProgress(currentVolume);
                    tb_sound_max.setChecked(maxVolume == currentVolume);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        tb_is_shock.setOnCheckedChangeListener(this);
        tb_sound_max.setOnCheckedChangeListener(this);
        receiver = new VolumeReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.media.VOLUME_CHANGED_ACTION");
        registerReceiver(receiver, filter);
        initNotificationTip();
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "声音与通知");
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.tb_sound_max:
                SPUtils.getInstance().put(Global.OPEN_MAX_VOLUME, compoundButton.isChecked());
                if (compoundButton.isChecked()) {
                    am.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, 0);
                } else {
                    am.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume * 4 / 5, 0);
                }
                break;
            case R.id.tb_is_shock:
                SPUtils.getInstance().put(Global.OPEN_VIBRATE, compoundButton.isChecked());
                break;

        }
    }

    @OnClick({R.id.ll_NotificationTip, R.id.ll_set_notification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_NotificationTip:
                ll_NotificationTip.setVisibility(View.GONE);
                break;
            case R.id.ll_set_notification:
                try {
                    // 根据isOpened结果，判断是否需要提醒用户跳转AppInfo页面，去打开App通知权限
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                    //这种方案适用于 API 26, 即8.0（含8.0）以上可以用
                    intent.putExtra(EXTRA_APP_PACKAGE, getPackageName());
                    intent.putExtra(EXTRA_CHANNEL_ID, getApplicationInfo().uid);
                    //这种方案适用于 API21——25，即 5.0——7.1 之间的版本可以使用
                    intent.putExtra("app_package", getPackageName());
                    intent.putExtra("app_uid", getApplicationInfo().uid);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    // 出现异常则跳转到应用设置界面：锤子坚果3——OC105 API25
                    Intent intent = new Intent();
                    //下面这种方案是直接跳转到当前应用的设置界面。
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                }
                break;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        initNotificationTip();
    }

    private void initNotificationTip() {
        if (!NotificationManagerCompat.from(mContext).areNotificationsEnabled()) {
            ll_NotificationTip.setVisibility(View.VISIBLE);
        }else{
            ll_NotificationTip.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return super.dispatchKeyEvent(event);
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, 0);
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
            am.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, 0);
        }
        return true;
    }
    private class VolumeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION")) {
                int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                seekBar.setProgress(currentVolume);
            }
        }
    }
}
