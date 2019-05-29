package com.hhj.merchant.ui.zxing.adapter;

import android.view.View;

import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GoodsInfoBean;

public class GoodsInfoAdapter extends BaseQuickAdapter<GoodsInfoBean, BaseViewHolder> {

    private int count;

    public interface ViewClick {
        void onClick(int id, int number, String price);
    }

    private static ViewClick viewClick;

    public GoodsInfoAdapter(ViewClick viewClick) {
        super(R.layout.item_goods_info);
        this.viewClick = viewClick;
    }

    @Override
    protected void convert(BaseViewHolder helper, final GoodsInfoBean item) {
        String normValue = "";
        for (GoodsInfoBean.NormsBean norm : item.getNorms()) {
            if (StringUtils.isEmpty(normValue)) {
                normValue = norm.getNormValue();
            } else {
                normValue = "," + norm.getNormValue();
            }
        }
        helper.setText(R.id.tv_productName, item.getProductName() + "(" + normValue + ")");
        count = item.getCount();
        helper.setText(R.id.tv_count, "x" + count + "");
        helper.setText(R.id.tv_money, item.getMoney() + "");
        setViewOnClickListener(helper.getView(R.id.iv_jian), helper, item);
        setViewOnClickListener(helper.getView(R.id.iv_jia), helper, item);
    }

    private void setViewOnClickListener(final View view, final BaseViewHolder helper, final GoodsInfoBean item) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view.getId()==R.id.iv_jian){
                    if (count > 1) {
                        count--;
                        item.setMoney(item.getMoney() - Double.parseDouble(item.getPrice()));
                    }
                }else if (view.getId()==R.id.iv_jia){
                    count++;
                    item.setMoney(item.getMoney() + Double.parseDouble(item.getPrice()));
                }
                item.setCount(count);
                helper.setText(R.id.tv_count, "x" + count);
                helper.setText(R.id.tv_money, item.getMoney() + "");
                viewClick.onClick(view.getId(), item.getCount(), item.getPrice());
            }
        });
    }
}
