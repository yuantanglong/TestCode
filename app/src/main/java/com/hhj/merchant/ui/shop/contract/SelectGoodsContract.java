package com.hhj.merchant.ui.shop.contract;

import com.baseapp.common.base.BaseView;
import com.hhj.merchant.bean.ProductTypeBean;
import com.hhj.merchant.bean.SellerGoodsBean;

import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.ui.shop.contract
 * @ClassName: SelectGoodsContract
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/22 13:32
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/22 13:32
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface SelectGoodsContract extends BaseView {
    void getProductType(List<ProductTypeBean> list);
    void getSellerGoods(List<SellerGoodsBean> list);
}
