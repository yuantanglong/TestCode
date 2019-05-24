package com.hhj.merchant.ui.order.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;

import com.baseapp.common.base.BaseFragmentAdapter;
import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.MultiItemPlaceHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.QueryCountBean;
import com.hhj.merchant.ui.order.contract.OrderContract;
import com.hhj.merchant.ui.order.presenter.OrderPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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
public class OrderFragment extends BaseFragment<OrderPresenter, MultiItemPlaceHolder> implements OrderContract {
    public static TabLayout tabLayout;
    public static OrderFragment orderFragment;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    private List<Fragment> fragments;
    private List<String> mTitles = null;
    private OrderListFragment fragment;
   public static List<QueryCountBean> list;
    public BaseFragmentAdapter adapter;
    private int position = 0;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
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
        mPresenter.setVM(this);
    }

    @Override
    protected void initView() {
        orderFragment=this;
        tabLayout = (TabLayout)mActivity.findViewById(R.id.mTabLayout);
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getQueryCount();
    }

    @Override
    protected void initNetWork(int pageIndex) {
        mPresenter.getQueryCount();
    }

    private void initTabLayout(List<QueryCountBean> list) {
        fragments = new ArrayList<>();
        mTitles = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            mTitles.add(list.get(i).getDateStr()+"("+list.get(i).getTotalCount()+")");
            fragments.add(createListFragment());
        }

        if (adapter == null) {
            adapter = new BaseFragmentAdapter(mActivity.getSupportFragmentManager(), fragments, mTitles);
        } else {
            adapter.setFragments(mActivity.getSupportFragmentManager(), fragments, mTitles);
        }
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(position);
        mViewPager.setOffscreenPageLimit(5);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }
    private Fragment createListFragment() {
        fragment = new OrderListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("tag", "OrderFragment");
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void getQueryCount(final List<QueryCountBean> list) {
        this.list = list;
        initTabLayout(list);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden){
            position=tabLayout.getSelectedTabPosition();
            mPresenter.getQueryCount();
        }
    }
}
