package com.hhj.merchant.ui.zxing.contract;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.GoodsInfoBean;

public interface CaptureContract extends BaseView {
    void getGoodsInfo(GoodsInfoBean bean);
    void saleRecord(BaseBean bean);
    void verifyOrder(BaseBean bean);
}
