package com.hhj.merchant.ui.wallet.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.MultiItemPlaceHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.WalletFlowBean;
import com.hhj.merchant.bean.WalletInfoBean;
import com.hhj.merchant.ui.wallet.adapter.DataCenterAdapter;
import com.hhj.merchant.ui.wallet.contract.WalletContract;
import com.hhj.merchant.ui.wallet.presenter.WalletPresenter;
import com.hhj.merchant.view.CustomDatePicker;
import com.hhj.merchant.view.DateFormatUtils;
import com.hhj.merchant.view.MySegmentTabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;

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
public class WalletFragment extends BaseFragment<WalletPresenter, MultiItemPlaceHolder> implements WalletContract, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.tv_totalGolds)
    TextView tv_totalGolds;
    @BindView(R.id.tv_todayGolds)
    TextView tv_todayGolds;
    @BindView(R.id.tv_yesterdayGolds)
    TextView tv_yesterdayGolds;
    @BindView(R.id.ll_order)
    LinearLayout ll_order;
    @BindView(R.id.tv_count)
    TextView tv_count;
    @BindView(R.id.ll_date)
    LinearLayout ll_date;
    @BindView(R.id.tv_begin)
    TextView tv_begin;
    @BindView(R.id.tv_end)
    TextView tv_end;
    @BindView(R.id.mMySegmentTabLayout)
    MySegmentTabLayout mMySegmentTabLayout;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    DataCenterAdapter mAdapter;
    private String[] mTitles = {"今日", "昨日", "近七日", "日期筛选"};
    private HashMap<String, String> map;
    private String dateType = "0";
    private String endDate = "";
    private String startDate = "";
    private String tradeType = "";
    private CustomDatePicker mDatePicker;
    private boolean isRefresh;
    private CustomDatePicker mDatePicker2;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wallet;
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
        initAdapter();
        initDatePicker();
        mMySegmentTabLayout.setTabData(mTitles);
        mMySegmentTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position==3){
                    ll_date.setVisibility(View.VISIBLE);
                    ll_order.setVisibility(View.GONE);
                }else {
                    ll_date.setVisibility(View.GONE);
                    ll_order.setVisibility(View.VISIBLE);
                }
                dateType = position + "";
                pageIndex = 1;
                initNetWork(pageIndex);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void initAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new DataCenterAdapter();
        mAdapter.setOnLoadMoreListener(this, mRecyclerView);
        View emptyView = mActivity.getLayoutInflater().inflate(R.layout.order_empty, (ViewGroup) mRecyclerView.getParent(), false);
        mAdapter.setEmptyView(emptyView);
        mRecyclerView.setAdapter(mAdapter);
    }
    private void initDatePicker() {
        long beginTimestamp = DateFormatUtils.str2Long("2017-01-01", false);
        long endTimestamp = System.currentTimeMillis();

        tv_begin.setText(DateFormatUtils.long2Str(endTimestamp, false));
        tv_end.setText(DateFormatUtils.long2Str(endTimestamp, false));

        // 通过时间戳初始化日期，毫秒级别
        mDatePicker = new CustomDatePicker(mContext, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                isRefresh = true;
                tv_begin.setText(DateFormatUtils.long2Str(timestamp, false));
                startDate = DateFormatUtils.long2Str(timestamp, false);
                pageIndex=1;
                initNetWork(pageIndex);
            }
        }, beginTimestamp, endTimestamp);
        // 不允许点击屏幕或物理返回键关闭
        mDatePicker.setCancelable(false);
        // 不显示时和分
        mDatePicker.setCanShowPreciseTime(false);
        // 不允许循环滚动
        mDatePicker.setScrollLoop(false);
        // 不允许滚动动画
        mDatePicker.setCanShowAnim(false);


        // 通过时间戳初始化日期，毫秒级别
        mDatePicker2 = new CustomDatePicker(mContext, new CustomDatePicker.Callback() {
            @Override
            public void onTimeSelected(long timestamp) {
                isRefresh = true;
                tv_end.setText(DateFormatUtils.long2Str(timestamp, false));
                endDate = DateFormatUtils.long2Str(timestamp, false);
                pageIndex=1;
                initNetWork(pageIndex);
            }
        }, beginTimestamp, endTimestamp);
        // 不允许点击屏幕或物理返回键关闭
        mDatePicker2.setCancelable(false);
        // 不显示时和分
        mDatePicker2.setCanShowPreciseTime(false);
        // 不允许循环滚动
        mDatePicker2.setScrollLoop(false);
        // 不允许滚动动画
        mDatePicker2.setCanShowAnim(false);
    }
    @Override
    protected void lazyLoad() {
        initNetWork(pageIndex);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        mPresenter.getWalletInfo();
        map = new HashMap<>();
        map.put("pageIndex", pageIndex + "");
        map.put("pageSize", pageSize);
        map.put("dateType", dateType);
        map.put("endDate", endDate);
        map.put("startDate", startDate);
        map.put("tradeType", tradeType);
        mPresenter.getWalletFlow(map);
    }
    @Override
    public void getWalletInfo(WalletInfoBean bean) {
        tv_totalGolds.setText(bean.getTotalGolds());
        tv_todayGolds.setText(bean.getTodayGolds());
        tv_yesterdayGolds.setText(bean.getYesterdayGolds());
    }
    @Override
    public void getWalletFlow(WalletFlowBean bean) {
        tv_count.setText(bean.getCount());
        List<WalletFlowBean.ListBean> list = bean.getList();
        if (pageIndex == 1) {
            mAdapter.setNewData(list);
            mAdapter.disableLoadMoreIfNotFullPage(mRecyclerView);
        } else {
            if (list == null || list.size() == 0) {
                mAdapter.loadMoreEnd();
            } else {
                mAdapter.addData(list);
                mAdapter.loadMoreComplete();
            }
        }
    }



    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onLoadMoreRequested() {
        pageIndex++;
        initNetWork(pageIndex);
    }
    @OnClick({R.id.rl_begin, R.id.rl_end})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_begin:
                // 日期格式为yyyy-MM-dd
                mDatePicker.show(tv_begin.getText().toString());
                break;
            case R.id.rl_end:
                // 日期格式为yyyy-MM-dd
                mDatePicker2.show(tv_end.getText().toString());
                break;
        }
    }
}
