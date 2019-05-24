package com.hhj.merchant.ui.shop.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.MultiItemPlaceHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.ProductTypeBean;
import com.hhj.merchant.bean.SellerGoodsBean;
import com.hhj.merchant.ui.shop.adapter.GoodsAdapter;
import com.hhj.merchant.ui.shop.adapter.GoodsTypeAdapter;
import com.hhj.merchant.ui.shop.contract.SelectGoodsContract;
import com.hhj.merchant.ui.shop.presenter.SelectGoodsPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.fragment
 * @ClassName: SelectGoodsFragment
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/21 20:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/21 20:30
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SelectGoodsFragment extends BaseFragment<SelectGoodsPresenter, MultiItemPlaceHolder> implements SelectGoodsContract, BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.mGoodsTypeRecyclerView)
    RecyclerView mGoodsTypeRecyclerView;
    @BindView(R.id.mGoodsRecyclerView)
    RecyclerView mGoodsRecyclerView;
    GoodsTypeAdapter mGoodsTypeAdapter;
    GoodsAdapter mGoodsAdapter;
    private Map<String, String> map;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_select_goods;
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
        initAdapter();
    }

    private void initAdapter() {
        mGoodsTypeRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mGoodsTypeAdapter = new GoodsTypeAdapter();
        mGoodsTypeRecyclerView.setAdapter(mGoodsTypeAdapter);
        mGoodsTypeAdapter.setOnItemClickListener(this);
        mGoodsRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mGoodsAdapter = new GoodsAdapter();
        mGoodsRecyclerView.setAdapter(mGoodsTypeAdapter);
    }

    @Override
    protected void lazyLoad() {
        mPresenter.getProductType();
    }

    @Override
    protected void initNetWork(int pageIndex) {

    }

    @Override
    public void getProductType(List<ProductTypeBean> list) {
        mGoodsTypeAdapter.setNewData(list);
        initSellerGoods(list.get(0).getId());
    }

    private void initSellerGoods(String productTypeId) {
        map = new HashMap<>();
        map.put("productTypeId", productTypeId);
        mPresenter.getSellerGoods(map);
    }

    @Override
    public void getSellerGoods(List<SellerGoodsBean> list) {
        mGoodsAdapter.setNewData(list);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        super.onItemClick(adapter, view, position);
        ProductTypeBean productTypeBean = mGoodsTypeAdapter.getItem(position);
        initSellerGoods(productTypeBean.getId());
    }
}
