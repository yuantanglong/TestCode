package com.hhj.merchant.ui.shop.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseapp.common.http.Api;
import com.baseapp.common.utils.GlideUtils;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellerGoodsBean;

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
public class GoodsAdapter extends BaseQuickAdapter<SellerGoodsBean, BaseViewHolder> {
    public GoodsAdapter() {
        super(R.layout.item_goods);
    }

    @Override
    protected void convert(BaseViewHolder helper, SellerGoodsBean item) {
        String images = Api.getmApiConfig().getmHostImgBase() + item.getImages();
        GlideUtils.loadImage(mContext, R.mipmap.hhj, R.mipmap.hhj, images, (ImageView) helper.getView(R.id.iv_goods));
        helper.setText(R.id.tv_productName, item.getProductName() + "(" + item.getNormNames() + ")");
        String productStock = item.getProductStock();
        helper.setText(R.id.tv_productStock, productStock);
        TextView tv_sell_out = helper.getView(R.id.tv_sell_out);
        if (StringUtils.isEmpty(productStock) || Integer.parseInt(productStock) <= 0) {
            tv_sell_out.setVisibility(View.VISIBLE);
        } else {
            tv_sell_out.setVisibility(View.GONE);
        }
    }
}
