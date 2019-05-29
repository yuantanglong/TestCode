package com.hhj.merchant.ui.shop.activity;

import android.app.Dialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.view.DialogWrapper;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.StringUtils;
import com.hhj.merchant.R;

import butterknife.BindView;
import butterknife.OnClick;

public class EquipmentManagerActivity extends BaseActivity {
    @BindView(R.id.tv_print)
    TextView tv_print;
    @BindView(R.id.tv_saoma)
    TextView tv_saoma;
    @BindView(R.id.tv_print_songhuo_num)
    TextView tv_print_songhuo_num;
    @BindView(R.id.tv_print_daodian_num)
    TextView tv_print_daodian_num;
    private Dialog dialog;
    private Intent intent;

    @Override
    protected IToolbar getIToolbar() {
        return new ToolbarBackTitle(this, "打印设置");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_equipment_manager;
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
        initPrintNum();
    }

    private void initPrintNum() {
        String print_songhuo_num = SPUtils.getInstance().getString(Global.PRINT_SONGHUO_NUM, "1");
        tv_print_songhuo_num.setText(print_songhuo_num);
        String print_daodian_num = SPUtils.getInstance().getString(Global.PRINT_DAODIAN_NUM, "1");
        tv_print_daodian_num.setText(print_daodian_num);
    }

    @Override
    protected void initNetWork(int pageIndex) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        BluetoothAdapter blueadapter = BluetoothAdapter.getDefaultAdapter();
        String print = SPUtils.getInstance().getString(Global.ADDRESS_PRINT);
        String saoma = SPUtils.getInstance().getString(Global.ADDRESS_SAOMA);
        if (blueadapter.isEnabled() && !StringUtils.isEmpty(print)) {
            tv_print.setText("已连接");
        } else {
            tv_print.setText("未连接");
        }
        if (blueadapter.isEnabled() && !StringUtils.isEmpty(saoma)) {
            tv_saoma.setText("已连接");
        } else {
            tv_saoma.setText("未连接");
        }
    }

    @OnClick({R.id.ll_print, R.id.ll_saoma, R.id.ll_print_songhuo, R.id.ll_print_daodian})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_print:
                intent = new Intent(mContext, ConnectBluetoothActivity.class);
                intent.putExtra("tag","print");
                startActivity(intent);
                break;
            case R.id.ll_saoma:
                 intent=new Intent(mContext,ConnectBluetoothActivity.class);
                intent.putExtra("tag","saoma");
                startActivity(intent);
                break;
            case R.id.ll_print_songhuo:
                showDialog(Global.PRINT_SONGHUO_NUM);
                break;
            case R.id.ll_print_daodian:
                showDialog(Global.PRINT_DAODIAN_NUM);
                break;
        }
    }

    private void showDialog(final String key) {
        View view = View.inflate(mActivity, R.layout.dialog_print_num, null);
        ImageView iv_jian = view.findViewById(R.id.iv_jian);
        final EditText et_num = view.findViewById(R.id.et_num);
        et_num.setSelection(et_num.getText().toString().trim().length());
        et_num.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().startsWith("0") || s.toString().equals("")) {
                    et_num.setText("1");
                    et_num.setSelection(1);
                }
            }
        });
        ImageView iv_jia = view.findViewById(R.id.iv_jia);
        setOnClickListenter(iv_jian, et_num);
        setOnClickListenter(iv_jia, et_num);
        dialog = DialogWrapper.
                tipDialog().
                context(mContext).
                title("").
                tittleVisible(false).
                contentView(view).
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

                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        dialog.dismiss();
                        SPUtils.getInstance().put(key, et_num.getText().toString().trim());
                        initPrintNum();
                    }
                }).build();
        dialog.show();
    }

    private void setOnClickListenter(final ImageView imageView, final EditText et_num) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = 1;
                if (StringUtils.isEmpty(et_num.getText().toString().trim())) {
                    et_num.setText(num + "");
                }
                num = Integer.parseInt(et_num.getText().toString().trim());
                switch (imageView.getId()) {
                    case R.id.iv_jian:
                        if (num != 1) {
                            num--;
                        }
                        break;
                    case R.id.iv_jia:
                        num++;
                        break;
                }
                et_num.setText(num + "");
            }
        });
    }
}
