package com.hhj.merchant.ui.shop.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.Api;
import com.baseapp.common.utils.GlideUtils;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.ui.order.activity.OrderFinishActivity;
import com.hhj.merchant.ui.order.activity.OrderGoodsManagerActivity;
import com.hhj.merchant.ui.shop.activity.DeliveryClerkManagerActivity;
import com.hhj.merchant.ui.shop.activity.EquipmentManagerActivity;
import com.hhj.merchant.ui.order.activity.OrderRefundActivity;
import com.hhj.merchant.ui.shop.activity.SellerMessageActivity;
import com.hhj.merchant.ui.shop.activity.SetActivity;
import com.hhj.merchant.ui.shop.activity.VoiceAndNoticeActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.fragment
 * @ClassName: OrderFragment
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 10:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 10:34
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ShopFragment extends BaseFragment {
    @BindView(R.id.iv_head)
    ImageView iv_head;
    @BindView(R.id.tv_sellerName)
    TextView tv_sellerName;
    @BindView(R.id.tv_telephone)
    TextView tv_telephone;
    private Intent intent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop;
    }

    @Override
    protected SmartRefreshLayout getSmartRefreshLayout() {
        return null;
    }

    @Override
    protected RecyclerView getRecyclerView() {
        return null;
    }

    @Override
    protected BaseRecyclerViewAdapter getRecyclerViewAdapter() {
        return null;
    }

    @Override
    protected boolean enableAdapterLoadMore() {
        return false;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        String head = Api.getmApiConfig().getmHostImgBase() + SPUtils.getInstance().getString(Global.SELLERLOGO);
        GlideUtils.loadImage(mContext, R.mipmap.head,R.mipmap.head,head, iv_head);
        String string = SPUtils.getInstance().getString(Global.SELLERNAME);
        tv_sellerName.setText(SPUtils.getInstance().getString(Global.SELLERNAME));
        tv_telephone.setText(SPUtils.getInstance().getString(Global.TELEPHONE));
    }

    @Override
    protected void lazyLoad() {
        initView();
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @OnClick({
            R.id.ll_OrderGoodsManager,R.id.ll_GoodsManager,R.id.ll_self_goods,
            R.id.ll_SellerMessage, R.id.ll_VoiceAndNotice, R.id.ll_EquipmentManager,
            R.id.ll_OrderFinish, R.id.ll_refund, R.id.ll_set, R.id.ll_DeliveryClerkManager,
            })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_OrderGoodsManager:
                intent = new Intent(mActivity,OrderGoodsManagerActivity.class);
                intent.putExtra("tag","OrderGoodsManager");
                startActivity(intent);
                break;
            case R.id.   ll_GoodsManager:
                intent = new Intent(mActivity,OrderGoodsManagerActivity.class);
                intent.putExtra("tag","GoodsManager");
                startActivity(intent);
                break;
            case R.id.ll_self_goods:
                ToastUtils.showShort("功能内测中,暂不开放");
                break;
            case R.id.ll_SellerMessage:
                startActivity(SellerMessageActivity.class);
                break;
            case R.id.ll_EquipmentManager:
                 intent = new Intent(mContext, EquipmentManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_OrderFinish:
                startActivity(OrderFinishActivity.class);
                break;
            case R.id.ll_refund:
                startActivity(OrderRefundActivity.class);
                break;
            case R.id.ll_VoiceAndNotice:
                startActivity(VoiceAndNoticeActivity.class);
                break;
            case R.id.ll_set:
                startActivity(SetActivity.class);
                break;
            case R.id.ll_DeliveryClerkManager:
                startActivity(DeliveryClerkManagerActivity.class);
                break;
        }
    }
}
