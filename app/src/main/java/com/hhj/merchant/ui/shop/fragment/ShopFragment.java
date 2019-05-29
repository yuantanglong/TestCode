package com.hhj.merchant.ui.shop.fragment;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.Api;
import com.baseapp.common.utils.GlideUtils;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.app.BTPrinter;
import com.hhj.merchant.ui.main.activity.MainActivity;
import com.hhj.merchant.ui.order.activity.OrderFinishActivity;
import com.hhj.merchant.ui.order.activity.OrderGoodsManagerActivity;
import com.hhj.merchant.ui.order.activity.OrderRefundActivity;
import com.hhj.merchant.ui.shop.activity.DeliveryClerkManagerActivity;
import com.hhj.merchant.ui.shop.activity.EquipmentManagerActivity;
import com.hhj.merchant.ui.shop.activity.SellerMessageActivity;
import com.hhj.merchant.ui.shop.activity.SetActivity;
import com.hhj.merchant.ui.shop.activity.VoiceAndNoticeActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.fragment
 * @ClassName: OrderFragment
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 10:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 10:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ShopFragment extends BaseFragment {
    @BindView(R.id.iv_head)
    ImageView iv_head;
    @BindView(R.id.tv_sellerName)
    TextView tv_sellerName;
    @BindView(R.id.tv_telephone)
    TextView tv_telephone;
    @BindView(R.id.iv_port)
    ImageView iv_port;
    @BindView(R.id.tv_port_connect)
    TextView tv_port_connect;
    @BindView(R.id.iv_saomaqiang)
    ImageView iv_saomaqiang;

    @BindView(R.id.tv_saomaqiang)
    TextView tv_saomaqiang;
    private Intent intent;
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected SmartRefreshLayout getSmartRefreshLayout() {
        return null;
    }

    @Override
    protected RecyclerView getRecyclerView() {
        return null;
    }

    @Override
    protected BaseRecyclerViewAdapter getRecyclerViewAdapter() {
        return null;
    }

    @Override
    protected boolean enableAdapterLoadMore() {
        return false;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        String head = Api.getmApiConfig().getmHostImgBase() + SPUtils.getInstance().getString(Global.SELLERLOGO);
        GlideUtils.loadImage(mContext, R.mipmap.head, R.mipmap.head, head, iv_head);
        tv_sellerName.setText(SPUtils.getInstance().getString(Global.SELLERNAME));
        tv_telephone.setText(SPUtils.getInstance().getString(Global.TELEPHONE));
        driveisConnect();
    }

    private void driveisConnect() {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        int flag = -1;
        if (mBluetoothAdapter.getProfileConnectionState(BluetoothProfile.A2DP) == BluetoothProfile.STATE_CONNECTED) {
            flag = BluetoothProfile.STATE_CONNECTED;
        } else if (mBluetoothAdapter.getProfileConnectionState(BluetoothProfile.HEADSET) == BluetoothProfile.STATE_CONNECTED) {
            flag = BluetoothProfile.STATE_CONNECTED;
        } else if (mBluetoothAdapter.getProfileConnectionState(BluetoothProfile.HEALTH) == BluetoothProfile.STATE_CONNECTED) {
            flag = BluetoothProfile.STATE_CONNECTED;
        }
        if (flag != -1) {
            mBluetoothAdapter.getProfileProxy(mContext, new BluetoothProfile.ServiceListener() {
                @Override
                public void onServiceDisconnected(int profile) {
                }

                @Override
                public void onServiceConnected(int profile, BluetoothProfile proxy) {
                    // TODO Auto-generated method stub
                    List<BluetoothDevice> mDevices = proxy.getConnectedDevices();
                    if (mDevices != null && mDevices.size() > 0) {
                        for (final BluetoothDevice device : mDevices) {
                            Log.i("W", "device name: " + device.getName());
                            MainActivity.btPrinter.connectOrDisConnectToDevice(0, device.getAddress(), device.getName(), false, new BTPrinter.ConnectState() {
                                @Override
                                public void getIsConnectSuccess(boolean isSuccess) {
                                    if (isSuccess) {
                                        initConnect();
                                    }
                                }
                            });
                        }
                    } else {
                        initConnect();
                    }
                }
            }, flag);
        }
    }
    private void initConnect() {
        if (StringUtils.isEmpty(SPUtils.getInstance().getString(Global.ADDRESS_PRINT))) {
            tv_port_connect.setText("打印机未连接");
            iv_port.setImageResource(R.mipmap.shop_gp_dyj1);
        } else {
            tv_port_connect.setText("打印机已连接");
            iv_port.setImageResource(R.mipmap.shop_gp_dyj);
        }
        if (StringUtils.isEmpty(SPUtils.getInstance().getString(Global.ADDRESS_SAOMA))) {
            tv_port_connect.setText("扫码枪未连接");
            iv_port.setImageResource(R.mipmap.saoma1);
        } else {
            tv_port_connect.setText("扫码枪已连接");
            iv_port.setImageResource(R.mipmap.saoma);
        }
    }

    @Override
    protected void lazyLoad() {
        initView();
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @OnClick({
            R.id.ll_OrderGoodsManager, R.id.ll_GoodsManager, R.id.ll_self_goods,
            R.id.ll_SellerMessage, R.id.ll_VoiceAndNotice, R.id.ll_EquipmentManager,
            R.id.ll_OrderFinish, R.id.ll_refund, R.id.ll_set, R.id.ll_DeliveryClerkManager,
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_OrderGoodsManager:
                intent = new Intent(mActivity, OrderGoodsManagerActivity.class);
                intent.putExtra("tag", "OrderGoodsManager");
                startActivity(intent);
                break;
            case R.id.ll_GoodsManager:
                intent = new Intent(mActivity, OrderGoodsManagerActivity.class);
                intent.putExtra("tag", "GoodsManager");
                startActivity(intent);
                break;
            case R.id.ll_self_goods:
                ToastUtils.showShort("功能内测中,暂不开放");
                break;
            case R.id.ll_SellerMessage:
                startActivity(SellerMessageActivity.class);
                break;
            case R.id.ll_EquipmentManager:
                intent = new Intent(mContext, EquipmentManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_OrderFinish:
                startActivity(OrderFinishActivity.class);
                break;
            case R.id.ll_refund:
                startActivity(OrderRefundActivity.class);
                break;
            case R.id.ll_VoiceAndNotice:
                startActivity(VoiceAndNoticeActivity.class);
                break;
            case R.id.ll_set:
                startActivity(SetActivity.class);
                break;
            case R.id.ll_DeliveryClerkManager:
                startActivity(DeliveryClerkManagerActivity.class);
                break;
        }
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            initView();
        }
    }
}
