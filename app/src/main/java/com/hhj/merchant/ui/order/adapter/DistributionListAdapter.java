package com.hhj.merchant.ui.order.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.DistributionListBean;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: hhj_android_merchant
 * @Package: com.new_hhj.orders.adapter
 * @ClassName: DistributionListAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/7 17:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/7 17:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DistributionListAdapter extends BaseQuickAdapter<DistributionListBean, BaseViewHolder> {
    public String orderState = "";

    public DistributionListAdapter() {
        super(R.layout.item_distributionlist);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DistributionListBean item) {
        helper.setText(R.id.tv_deliveryNumber, item.getDeliveryNumber())
                .setText(R.id.tv_deliveryTime, item.getDeliveryTime());
        TextView tv_deliveryStatus = helper.getView(R.id.tv_deliveryStatus);
        final CheckBox checkBox = helper.getView(R.id.checkBox);
        helper.getView(R.id.root).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isClickable()) {
                    checkBox.setChecked(!checkBox.isChecked());
                }
            }
        });
        //给CheckBox设置事件监听
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                item.setChecked(checkBox.isChecked());
            }
        });
        checkBox.setChecked(item.isChecked());
        switch (item.getDeliveryStatus()) {
            case "1":
                checkBox.setVisibility(View.GONE);
                tv_deliveryStatus.setText("未配送");
                break;
            case "2":
                checkBox.setVisibility(View.VISIBLE);
                tv_deliveryStatus.setText("配送中");
                String deliveryTime = item.getDeliveryTime();
                // 比较最大日期与当前日期
                Date date = new Date();
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String nowDate = format.format(date);
                if (deliveryTime.compareTo(nowDate) > 0) {
                    checkBox.setClickable(false);
                    checkBox.setButtonDrawable(R.drawable.radio_button_bg1);
                } else {
                    checkBox.setClickable(true);
                    checkBox.setButtonDrawable(R.drawable.radio_button_bg);
                }
                break;
            case "3":
                checkBox.setVisibility(View.VISIBLE);
                tv_deliveryStatus.setText("已完成");
                checkBox.setButtonDrawable(R.drawable.radio_button_bg1);
                break;
        }
        if ("3".equals(orderState)) {
            checkBox.setVisibility(View.GONE);
        } else if ("5".equals(orderState)) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setButtonDrawable(R.drawable.radio_button_bg1);
        }
    }
}
