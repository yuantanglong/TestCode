package com.hhj.merchant.ui.shop.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.baseapp.common.http.Api;
import com.baseapp.common.utils.GlideUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GetListBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.adapter
 * @ClassName: DeliveryClerkManagerAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/20 9:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/20 9:55
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DeliveryClerkManagerAdapter extends BaseQuickAdapter<GetListBean.NativePeopleBean, BaseViewHolder> {
    public DeliveryClerkManagerAdapter() {
        super(R.layout.item_deliveryclerkmanager);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GetListBean.NativePeopleBean item) {
        FrameLayout tv_del = helper.getView(R.id.fl_del);
        tv_del.setVisibility(View.GONE);
        GlideUtils.loadImage(mContext, Api.getmApiConfig().getmHostImgBase() + item.getAvatar(), R.mipmap.head, R.mipmap.head, (ImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_workOrderCount, "本月已送" + item.getWorkOrderCount() + "单");
    }
}
