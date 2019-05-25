package com.hhj.merchant.ui.order.adapter;

import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;

public class ConfirmGoodsAdapter extends BaseQuickAdapter<UnfinishedSellerOrdersBean.SellerOrderProductsBean, BaseViewHolder> {
    public ConfirmGoodsAdapter() {
        super(R.layout.item_confirm_goods);
    }

    @Override
    protected void convert(BaseViewHolder helper, UnfinishedSellerOrdersBean.SellerOrderProductsBean item) {
        helper.setText(R.id.tv_productName, item.getProductName() + "(" + item.getNormNames() + ")");
        EditText et_num = helper.getView(R.id.et_num);
        et_num.setText(item.getCount());
        setOnClickListenter(helper.getView(R.id.iv_jian), et_num,item);
        setOnClickListenter(helper.getView(R.id.iv_jia), et_num,item);
    }

    private void setOnClickListenter(final View imageView, final EditText et_num, final UnfinishedSellerOrdersBean.SellerOrderProductsBean item) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StringUtils.isEmpty(et_num.getText().toString().trim())) {
                    ToastUtils.showShort("请输入数量");
                } else {
                    int num = Integer.parseInt(et_num.getText().toString().trim());
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
                    item.setCount(num+"");
                }

            }
        });
    }
}
