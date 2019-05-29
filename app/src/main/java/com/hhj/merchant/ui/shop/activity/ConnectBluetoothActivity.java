package com.hhj.merchant.ui.shop.activity;

import android.Manifest;
import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.baseapp.common.view.PermissionRationalDialog;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gprinter.command.GpCom;
import com.gprinter.io.PortParameters;
import com.gprinter.save.PortParamDataBase;
import com.gprinter.service.GpPrintService;
import com.hhj.merchant.R;
import com.hhj.merchant.app.BTPrinter;
import com.hhj.merchant.ui.main.activity.MainActivity;
import com.hhj.merchant.ui.shop.adapter.ConnectBluetoothAdapter;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.SettingService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.OnClick;

public class ConnectBluetoothActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.tb_blue)
    ToggleButton tb_blue;
    @BindView(R.id.ll_no_connect)
    LinearLayout ll_no_connect;
    @BindView(R.id.mUnBingRecyclerView)
    RecyclerView mUnBingRecyclerView;
    @BindView(R.id.mBindRecyclerView)
    RecyclerView mBindRecyclerView;
    @BindView(R.id.tv_isConnect)
    TextView tv_isConnect;
    @BindView(R.id.tv_name)
    TextView tv_name;
    @BindView(R.id.ll_printTestPage)
    LinearLayout ll_printTestPage;
    ConnectBluetoothAdapter mUnBingAdapter;
    ConnectBluetoothAdapter mBindAdapter;
    private ToolbarBackTitle toolbarBackTitle;
    private BluetoothAdapter mBluetoothAdapter;
    private List<BluetoothDevice> mUnBingList;
    private List<BluetoothDevice> mBingListList;
    private Dialog mPermissionSettingDialog;
    private PortParameters mPortParam[] = new PortParameters[GpPrintService.MAX_PRINTER_CNT];
    private BluetoothReceiver bluetoothReceiver;
    private Dialog dialog;
    private IntentFilter intentFilter;
    private Set<BluetoothDevice> bondedDevices;
    public static final int REQUEST_ENABLE_BT = 2;
    private String tag;
    private BluetoothDevice bluetoothDevice;
    @Override
    protected IToolbar getIToolbar() {
        toolbarBackTitle = new ToolbarBackTitle(this, "");
        return toolbarBackTitle;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_connect_bluetooth;
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
        tag = getIntent().getStringExtra("tag");
        if ("print".equals(tag)) {
            toolbarBackTitle.setTitleText("连接打印机");
        } else if ("saoma".equals(tag)) {
            toolbarBackTitle.setTitleText("连接扫码枪");
        }
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
            mBluetoothAdapter.getProfileProxy(ConnectBluetoothActivity.this, new BluetoothProfile.ServiceListener() {
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
                                   connectIsSuccess(isSuccess,device.getAddress(),device.getName(),false);
                               }
                           });
                        }
                    } else {
                        Log.i("W", "mDevices is null");
                    }
                }
            }, flag);
        }
        registerReceiver(bluetoothState, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));
        if (mBluetoothAdapter.isEnabled()) {
            ll_no_connect.setVisibility(View.VISIBLE);
            ll_printTestPage.setVisibility(View.VISIBLE);
            tb_blue.setChecked(true);
            initAdapter();
            initBluetoothAdapter();
            requestPermission();
        }
        tb_blue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mBluetoothAdapter.enable();
                    Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
                } else {
                    showDialog("确认关闭蓝牙吗？");
                }
            }
        });
    }

    private void initBluetoothAdapter() {
        //注册广播
        intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND);
        bluetoothReceiver = new BluetoothReceiver();
        registerReceiver(bluetoothReceiver, intentFilter);
        bondedDevices = mBluetoothAdapter.getBondedDevices();
        if (null != bondedDevices && bondedDevices.size() > 0) {
            mBingListList.clear();
            mBingListList.addAll(bondedDevices);
            mBindAdapter.setNewData(mBingListList);
        }
    }

    private void showDialog(String message) {
        dialog = DialogWrapper.
                tipDialog().
                context(mContext).
                title("提示").
                message(message).
                buttonType(DialogWrapper.BUTTON_DOUBLE).
                leftButtonText("取消").
                rightButtonText("确定").
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
                        mBluetoothAdapter.disable();
                    }
                }).build();
        dialog.show();
    }

    private void initAdapter() {
        mUnBingList = new ArrayList<>();
        mBingListList = new ArrayList<>();
        mUnBingRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mUnBingAdapter = new ConnectBluetoothAdapter();
        mUnBingAdapter.setOnItemClickListener(this);
        mUnBingRecyclerView.setAdapter(mUnBingAdapter);
        mBindRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mBindAdapter = new ConnectBluetoothAdapter();
        mBindAdapter.setOnItemClickListener(this);
        mBindRecyclerView.setAdapter(mBindAdapter);
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    private void requestPermission() {
        AndPermission.
                with(this).
                permission(Manifest.permission.ACCESS_FINE_LOCATION).
                rationale(new PermissionRationalDialog()).
                onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        if (AndPermission.hasAlwaysDeniedPermission(ConnectBluetoothActivity.this, permissions)) {
                            List<String> permissionNames = Permission.transformText(ConnectBluetoothActivity.this, permissions);

                            final SettingService mSettingService = AndPermission.permissionSetting(ConnectBluetoothActivity.this);
                            mPermissionSettingDialog = DialogWrapper.
                                    tipDialog().
                                    context(ConnectBluetoothActivity.this).
                                    buttonType(DialogWrapper.BUTTON_DOUBLE).
                                    title("权限提示").
                                    message("哈哈镜商户需要以下权限才能正常运行" + TextUtils.join("\n", permissionNames)).
                                    leftButtonText("放弃").
                                    rightButtonText("立即设置").
                                    buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                                        @Override
                                        public void onLeftButtonClicked(TextView view) {
                                            if (mPermissionSettingDialog != null) {
                                                mPermissionSettingDialog.dismiss();
                                            }
                                            mSettingService.cancel();
                                        }

                                        @Override
                                        public void onSingleButtonClicked(TextView view) {

                                        }

                                        @Override
                                        public void onRightButtonClicked(TextView view) {
                                            if (mPermissionSettingDialog != null) {
                                                mPermissionSettingDialog.dismiss();
                                            }
                                            mSettingService.execute();
                                        }
                                    }).
                                    build();

                            mPermissionSettingDialog.show();
                        }
                    }
                }).
                onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        if (mBluetoothAdapter.isDiscovering()) {
                            mBluetoothAdapter.cancelDiscovery();
                        }
                        mBluetoothAdapter.startDiscovery();
                    }
                }).
                start();

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        try {
            bluetoothDevice = (BluetoothDevice) adapter.getData().get(position);
            if (bluetoothDevice.getBondState() == BluetoothDevice.BOND_NONE) {
                ToastUtils.showShort("正在连接，请稍后...");
                Method method = BluetoothDevice.class.getMethod("createBond");
                Log.e(getPackageName(), "开始配对");
                method.invoke(bluetoothDevice);
            } else if (bluetoothDevice.getBondState() == BluetoothDevice.BOND_BONDED) {
                MainActivity.btPrinter.connectOrDisConnectToDevice(0, bluetoothDevice.getAddress(), bluetoothDevice.getName(), true, new BTPrinter.ConnectState() {
                    @Override
                    public void getIsConnectSuccess(boolean isSuccess) {
                        connectIsSuccess(isSuccess,bluetoothDevice.getAddress(),bluetoothDevice.getName(),true);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void connectIsSuccess(boolean isSuccess, String address, String name, boolean isToast) {
        if (isSuccess) {
            if ("print".equals(tag)) {
                SPUtils.getInstance().put(Global.ADDRESS_PRINT, address);
            } else if ("saoma".equals(tag)) {
                SPUtils.getInstance().put(Global.ADDRESS_SAOMA, address);
            }
            tv_isConnect.setText("当前已连接");
            tv_name.setText(name);
            SPUtils.getInstance().put(Global.NAME_PRINT, name);
            ll_printTestPage.setVisibility(View.VISIBLE);
            if (isToast) {
                ToastUtils.showShort("连接成功");
            }
        } else {
            if ("print".equals(tag)) {
                SPUtils.getInstance().put(Global.ADDRESS_PRINT, "");
            } else if ("saoma".equals(tag)) {
                SPUtils.getInstance().put(Global.ADDRESS_SAOMA, "");
            }
            tv_isConnect.setText("当前未连接");
            tv_name.setText("暂无");
            ll_printTestPage.setVisibility(View.GONE);
            if (isToast) {
                ToastUtils.showShort("连接失败");
            }
        }

    }

    class BluetoothReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(BluetoothDevice.ACTION_FOUND)) {
                Log.e(getPackageName(), "找到新设备了");
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                boolean addFlag = true;
                for (BluetoothDevice bluetoothDevice : mUnBingList) {
                    if (device.getAddress().equals(bluetoothDevice.getAddress())) {
                        addFlag = false;
                    }
                }
                if (addFlag) {
                    mUnBingList.add(device);
                    mUnBingAdapter.setNewData(mUnBingList);
                }
            } else if (intent.getAction().equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                switch (device.getBondState()) {
                    case BluetoothDevice.BOND_NONE:
                        Log.e(getPackageName(), "取消配对");
                        break;
                    case BluetoothDevice.BOND_BONDING:
                        Log.e(getPackageName(), "配对中");
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        Log.e(getPackageName(), "配对成功");
                        ToastUtils.showShort("配对成功");
                        MainActivity.btPrinter.connectOrDisConnectToDevice(0, bluetoothDevice.getAddress(), bluetoothDevice.getName(), true, new BTPrinter.ConnectState() {
                            @Override
                            public void getIsConnectSuccess(boolean isSuccess) {
                                connectIsSuccess(isSuccess,bluetoothDevice.getAddress(),bluetoothDevice.getName(),true);
                            }
                        });
                        break;
                }
            }
        }
    }

    BroadcastReceiver bluetoothState = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String stateExtra = BluetoothAdapter.EXTRA_STATE;
            int state = intent.getIntExtra(stateExtra, -1);
            LogUtils.e("state=" + state);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    ll_no_connect.setVisibility(View.GONE);
                    ll_printTestPage.setVisibility(View.GONE);
                    tb_blue.setChecked(false);
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    break;
                case BluetoothAdapter.STATE_ON:
                    ll_no_connect.setVisibility(View.VISIBLE);
                    tb_blue.setChecked(true);
                    initAdapter();
                    initBluetoothAdapter();
                    requestPermission();
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    ll_no_connect.setVisibility(View.GONE);
                    ll_printTestPage.setVisibility(View.GONE);
                    tb_blue.setChecked(false);
                    unregisterReceiver(bluetoothReceiver);
                    break;

            }
        }
    };

    @OnClick({R.id.tv_printTestPage, R.id.ll_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_printTestPage:
                MainActivity.btPrinter.printTestPageClicked(0);
                break;
            case R.id.ll_search:
                requestPermission();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bluetoothState);
        if (null != bluetoothReceiver) {
            unregisterReceiver(bluetoothReceiver);
        }
    }
}
