package com.hhj.merchant.ui.shop.fragment;

import android.app.Dialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseapp.common.base.adapter.BaseRecyclerViewAdapter;
import com.baseapp.common.base.ui.BaseFragment;
import com.baseapp.common.http.error.ErrorType;
import com.baseapp.common.utility.MultiItemPlaceHolder;
import com.baseapp.common.utils.FormatUtil;
import com.baseapp.common.view.DialogWrapper;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.GoldAmountBean;
import com.hhj.merchant.bean.ProductGoodListBean;
import com.hhj.merchant.bean.ProductTypeBean;
import com.hhj.merchant.bean.SellerGoodsBean;
import com.hhj.merchant.bean.SellerOrderConditionList;
import com.hhj.merchant.bean.SubmitOrderBean;
import com.hhj.merchant.ui.shop.adapter.GoodsAdapter;
import com.hhj.merchant.ui.shop.adapter.GoodsTypeAdapter;
import com.hhj.merchant.ui.shop.adapter.ProductGoodListAdapter;
import com.hhj.merchant.ui.shop.contract.SelectGoodsContract;
import com.hhj.merchant.ui.shop.presenter.SelectGoodsPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static com.baseapp.common.view.DialogWrapper.BUTTON_DOUBLE;

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
    @BindView(R.id.tv_money)
    TextView tv_money;
    @BindView(R.id.tv_number)
    TextView tv_number;
    @BindView(R.id.rl_boot_view)
    RelativeLayout rl_boot_view;
    GoodsTypeAdapter mGoodsTypeAdapter;
    GoodsAdapter mGoodsAdapter;
    private Map<String, String> map;
    private Dialog dialog;
    private View dialog_view;
    private double db_money = 0.00;
    private int number = 0;
    private int position = 0;
    List<SellerOrderConditionList> sellerOrderConditionLists = null;
    private EditText et_count;
    private TextView tv_count;
    private ProductGoodListAdapter productGoodListAdapter;
    private String tag = "";

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
        mPresenter.setVM(this);
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
        tag = getArguments().getString("tag");
        View emptyView = mActivity.getLayoutInflater().inflate(R.layout.goods_empty, (ViewGroup) mGoodsRecyclerView.getParent(), false);
        if ("OrderGoodsManager".equals(tag)) {
            rl_boot_view.setVisibility(View.VISIBLE);
            mGoodsAdapter = new GoodsAdapter();
            mGoodsAdapter.setEmptyView(emptyView);
            mGoodsAdapter.setOnItemClickListener(this);
            mGoodsRecyclerView.setAdapter(mGoodsAdapter);
        } else if ("GoodsManager".equals(tag)) {
            rl_boot_view.setVisibility(View.GONE);
            productGoodListAdapter = new ProductGoodListAdapter();
            productGoodListAdapter.setEmptyView(emptyView);
            productGoodListAdapter.setOnItemClickListener(this);
            mGoodsRecyclerView.setAdapter(productGoodListAdapter);
        }
    }

    @Override
    protected void lazyLoad() {
        initNetWork(pageIndex);
    }

    @Override
    protected void initNetWork(int pageIndex) {
        tag = getArguments().getString("tag");
        if ("OrderGoodsManager".equals(tag)) {
            mPresenter.getApporderGoodsProductType();
        } else if ("GoodsManager".equals(tag)) {
            mPresenter.getProductType();
        }

    }

    @Override
    public void getApporderGoodsProductType(List<ProductTypeBean> list) {
        mGoodsTypeAdapter.setNewData(list);
        initSellerGoods(list.get(0).getId());
    }

    @Override
    public void getProductType(List<ProductTypeBean> list) {
        mGoodsTypeAdapter.setNewData(list);
        initSellerGoods(list.get(0).getId());
    }

    @Override
    public void productGoodList(List<ProductGoodListBean> list) {
        productGoodListAdapter.setNewData(list);
    }

    private void initSellerGoods(String productTypeId) {
        map = new HashMap<>();
        tag = getArguments().getString("tag");
        int state = getArguments().getInt("state");
        if ("OrderGoodsManager".equals(tag)) {
            map.put("productTypeId", productTypeId);
            mPresenter.getSellerGoods(map);
        } else if ("GoodsManager".equals(tag)) {
            map.put("state", state + "");
            map.put("productTypeId", productTypeId);
            mPresenter.productGoodList(map);
        }
    }

    @Override
    public void getSellerGoods(List<SellerGoodsBean> list) {
        mGoodsAdapter.setNewData(list);
    }

    @Override
    public void getGoldAmount(GoldAmountBean bean) {
        dialog_view = View.inflate(mActivity, R.layout.dialog_view_confirm_order_goods, null);
        TextView tv_productGoodsCount = dialog_view.findViewById(R.id.tv_productGoodsCount);
        tv_productGoodsCount.setText(bean.getProductGoodsCount());
        TextView tv_productAmount = dialog_view.findViewById(R.id.tv_productAmount);
        tv_productAmount.setText(bean.getProductAmount());
        TextView tv_deductionCoins = dialog_view.findViewById(R.id.tv_deductionCoins);
        tv_deductionCoins.setText(bean.getDeductionCoins());
        TextView tv_payment = dialog_view.findViewById(R.id.tv_payment);
        tv_payment.setText(bean.getPayment());
        showDialog(2, dialog_view, "确认订货");
    }

    @Override
    public void submitOrder(SubmitOrderBean bean) {
        ToastUtils.showShort("订单提交成功");
        tv_money.setText("0.00");
        tv_number.setText("0");
        initNetWork(pageIndex);
    }

    @Override
    public void showErrorTip(ErrorType errorType, int errorCode, String message) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        super.onItemClick(adapter, view, position);
        if (adapter instanceof GoodsTypeAdapter) {
            mGoodsTypeAdapter.position = position;
            mGoodsTypeAdapter.notifyDataSetChanged();
            ProductTypeBean productTypeBean = mGoodsTypeAdapter.getItem(position);
            initSellerGoods(productTypeBean.getId());
        } else if (adapter instanceof GoodsAdapter) {
            this.position = position;
            tv_count = view.findViewById(R.id.tv_count);
            TextView tv_sell_out = view.findViewById(R.id.tv_sell_out);
            if (tv_sell_out.getVisibility() == View.GONE) {
                dialog_view = View.inflate(mActivity, R.layout.dialog_view_edittext, null);
                et_count = dialog_view.findViewById(R.id.et_count);
                showDialog(1, dialog_view, "添加数量");
            }
        }
    }

    private void showDialog(final int type, View view, String title) {
        dialog = DialogWrapper.
                tipDialog().
                context(getContext()).
                title(title).
                contentView(view).
                buttonType(BUTTON_DOUBLE).
                leftButtonText("取消").
                rightButtonText("确定").
                singleButtonText("").
                closeImageVisible(false).
                cancelable(true, true).
                buttonClickListener(new DialogWrapper.TipTypeButtonClickListener() {
                    @Override
                    public void onLeftButtonClicked(TextView view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onSingleButtonClicked(TextView view) {
                        dialog.dismiss();


                    }

                    @Override
                    public void onRightButtonClicked(TextView view) {
                        if (type == 1) {
                            String count = et_count.getText().toString().trim();
                            if (StringUtils.isEmpty(count)) {
                                ToastUtils.showShort("请输入数量");
                            } else {
                                dialog.dismiss();
                                SellerGoodsBean item = mGoodsAdapter.getItem(position);
                                sellerOrderConditionLists = new ArrayList<>();
                                SellerOrderConditionList bean = new SellerOrderConditionList();
                                bean.setCount(count);
                                bean.setSellerProductGoodsId(item.getProductGoodId());
                                sellerOrderConditionLists.add(bean);
                                db_money += Double.parseDouble(FormatUtil.doubleSave2(Double.parseDouble(item.getSellerPrice()) * Double.parseDouble(count)));
                                tv_money.setText(db_money + "");
                                tv_count.setText(count);
                                tv_number.setText((number += Integer.parseInt(count)) + "");
                            }
                        } else if (type == 2) {
                            dialog.dismiss();
                            Map map = new HashMap();
                            map.put("isUseGolds", true);
                            map.put("sellerOrderConditionList", sellerOrderConditionLists);
                            mPresenter.submitOrder(map);
                        }
                    }
                }).build();
        dialog.show();
    }

    @OnClick({R.id.tv_submitOrder})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_submitOrder:
                Map map = new HashMap<>();
                map.put("sellerOrderConditionList", sellerOrderConditionLists);
                mPresenter.getGoldAmount(map);
                break;
        }
    }
}
