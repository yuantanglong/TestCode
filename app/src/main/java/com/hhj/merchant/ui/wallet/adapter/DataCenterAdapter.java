package com.hhj.merchant.ui.wallet.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hhj.merchant.R;
import com.hhj.merchant.bean.WalletFlowBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.wallet.adapter
 * @ClassName: WalletAdapter
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 12:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 12:58
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class DataCenterAdapter extends BaseQuickAdapter<WalletFlowBean.ListBean, BaseViewHolder> {
    public DataCenterAdapter() {
        super(R.layout.item_data_center);
    }

    @Override
    protected void convert(BaseViewHolder helper, WalletFlowBean.ListBean item) {
        helper.setText(R.id.tv_content, item.getContent())
                .setText(R.id.tv_coinDesc, item.getCoinDesc())
                .setText(R.id.tv_ordersSn, item.getOrdersSn())
                .setText(R.id.tv_createTime, item.getCreateTime());
    }
}
