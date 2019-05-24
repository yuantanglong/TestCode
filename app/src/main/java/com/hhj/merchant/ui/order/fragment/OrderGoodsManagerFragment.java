package com.hhj.merchant.ui.order.fragment;

import android.support.v7.widget.RecyclerView;

import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.hhj.merchant.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.order.fragment
 * @ClassName: OrderGoodsManagerFragment
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 20:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 20:33
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrderGoodsManagerFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_goods_manager;
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

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    protected void initNetWork(int pageIndex) {

    }
}
