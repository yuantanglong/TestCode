package com.hhj.merchant.ui.order.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.DistributionListBean;

import java.util.List;

public interface DistributionListContract extends BaseView {
    void doujiangList(List<DistributionListBean> list);
    void delivery(BaseBean bean);
}
