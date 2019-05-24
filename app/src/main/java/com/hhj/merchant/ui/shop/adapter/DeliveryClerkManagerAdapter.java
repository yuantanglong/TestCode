package com.hhj.merchant.ui.shop.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
    public String rightTitle = "编辑";

    public interface ViewClick {
        void onClick(GetListBean.NativePeopleBean bean, String message, int position);
    }

    private ViewClick viewClick;

    public DeliveryClerkManagerAdapter(ViewClick viewClick) {
        super(R.layout.item_deliveryclerkmanager);
        this.viewClick = viewClick;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final GetListBean.NativePeopleBean item) {
        final TextView tv_del = helper.getView(R.id.tv_del);
        if ("编辑".equals(rightTitle)) {
            tv_del.setVisibility(View.GONE);
        } else if ("完成".equals(rightTitle)) {
            tv_del.setVisibility(View.VISIBLE);
        }
        tv_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick.onClick(item, tv_del.getText().toString().trim(), helper.getAdapterPosition());
            }
        });
        GlideUtils.loadImage(mContext, Api.getmApiConfig().getmHostImgBase() + item.getAvatar(), R.mipmap.head, R.mipmap.head, (ImageView) helper.getView(R.id.iv_avatar));
        helper.setText(R.id.tv_name, item.getName())
                .setText(R.id.tv_workOrderCount, "本月已送" + item.getWorkOrderCount() + "单");
    }
}
