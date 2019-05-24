package com.hhj.merchant.ui.shop.adapter;

import android.view.View;
import android.widget.LinearLayout;

import com.baseapp.common.utils.UIUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.ProductTypeBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.adapter
 * @ClassName: GoodsTypeAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/22 11:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/22 11:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GoodsTypeAdapter extends BaseQuickAdapter<ProductTypeBean, BaseViewHolder> {
    public int position = 0;

    public GoodsTypeAdapter() {
        super(R.layout.item_goods_type);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductTypeBean item) {
        LinearLayout ll_root = helper.getView(R.id.ll_root);
        View line = helper.getView(R.id.line);
        helper.setText(R.id.tv_name, item.getName());
        if (position == helper.getAdapterPosition()) {
            line.setVisibility(View.VISIBLE);
            if ("-1".equals(item.getId())) {
                helper.setTextColor(R.id.tv_name, UIUtils.getColor(R.color.color_FE0000));
            } else {
                helper.setTextColor(R.id.tv_name, UIUtils.getColor(R.color.color_00b2a9));
            }
            ll_root.setBackgroundColor(UIUtils.getColor(R.color.white));
        } else {
            line.setVisibility(View.GONE);
            if ("-1".equals(item.getId())) {
                helper.setTextColor(R.id.tv_name, UIUtils.getColor(R.color.color_FE0000));
            } else {
                helper.setTextColor(R.id.tv_name, UIUtils.getColor(R.color.color_666666));
            }
            ll_root.setBackgroundColor(UIUtils.getColor(R.color.background));
        }
    }
}
