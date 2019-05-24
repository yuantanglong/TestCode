package com.hhj.merchant.ui.shop.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.SellerMessageBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.adapter
 * @ClassName: SellerMessageAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 17:19
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 17:19
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SellerMessageAdapter extends BaseQuickAdapter<SellerMessageBean, BaseViewHolder> {
    public SellerMessageAdapter() {
        super(R.layout.item_seller_message);
    }

    @Override
    protected void convert(BaseViewHolder helper, SellerMessageBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_createTime, item.getCreateTime())
                .setText(R.id.tv_content, item.getContent());
        ImageView img_message_tag = helper.getView(R.id.img_message_tag);
        String status = item.getStatus();
        if ("0".equals(status)) {
            img_message_tag.setVisibility(View.VISIBLE);
        } else {
            img_message_tag.setVisibility(View.GONE);
        }

    }
}
