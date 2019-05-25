package com.hhj.merchant.ui.shop.adapter;

import android.view.View;
import android.widget.ImageView;

import com.baseapp.common.http.Api;
import com.baseapp.common.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.ProductGoodListBean;

public class ProductGoodListAdapter extends BaseQuickAdapter<ProductGoodListBean, BaseViewHolder> {
    public ProductGoodListAdapter() {
        super(R.layout.item_goods);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProductGoodListBean item) {
        ImageView iv_jiantou = helper.getView(R.id.iv_jiantou);
        ImageView iv_add = helper.getView(R.id.iv_add);
        iv_jiantou.setVisibility(View.VISIBLE);
        iv_add.setVisibility(View.GONE);
        String images = Api.getmApiConfig().getmHostImgBase() + item.getImages();
        GlideUtils.loadImage(mContext, R.mipmap.hhj, R.mipmap.hhj, images, (ImageView) helper.getView(R.id.iv_goods));
        String normNames = "";
        for (ProductGoodListBean.NormsBean norm : item.getNorms()) {
            if (normNames.equals("")) {
                normNames = norm.getNormName() + " ";
            } else {
                normNames += norm.getNormName() + " ";
            }
        }
        helper.setText(R.id.tv_productName, item.getProductName() + normNames);
        if ("3".equals(item.getState())) {
            helper.setText(R.id.tv_productStock_str, "已上架  库存:" + item.getProductStock());
        } else {
            helper.setText(R.id.tv_productStock_str, "未上架  库存:" + item.getProductStock());
        }

    }
}
