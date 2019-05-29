package com.hhj.merchant.ui.shop.adapter;

import android.bluetooth.BluetoothDevice;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;

public class ConnectBluetoothAdapter extends BaseQuickAdapter<BluetoothDevice, BaseViewHolder> {
    public ConnectBluetoothAdapter() {
        super(R.layout.item_connect_bluetooth);
    }

    @Override
    protected void convert(BaseViewHolder helper, BluetoothDevice item) {
        helper.setText(R.id.tv_name, item.getName());
        helper.setText(R.id.tv_address, item.getAddress());

    }
}
