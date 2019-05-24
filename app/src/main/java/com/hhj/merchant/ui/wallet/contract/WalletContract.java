package com.hhj.merchant.ui.wallet.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.WalletFlowBean;
import com.hhj.merchant.bean.WalletInfoBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.wallet.contract
 * @ClassName: WalletContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 13:26
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 13:26
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface WalletContract extends BaseView {
    void getWalletFlow(WalletFlowBean bean);
    void getWalletInfo(WalletInfoBean bean);
}
