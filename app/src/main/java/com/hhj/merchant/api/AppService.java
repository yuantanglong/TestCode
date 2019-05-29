package com.hhj.merchant.api;

import com.baseapp.common.base.BaseBean;
import com.hhj.merchant.bean.DistributionListBean;
import com.hhj.merchant.bean.GetListBean;
import com.hhj.merchant.bean.GoldAmountBean;
import com.hhj.merchant.bean.GoodsInfoBean;
import com.hhj.merchant.bean.LoginBean;
import com.hhj.merchant.bean.OrdersBean;
import com.hhj.merchant.bean.ProductGoodListBean;
import com.hhj.merchant.bean.ProductTypeBean;
import com.hhj.merchant.bean.QueryCountBean;
import com.hhj.merchant.bean.SellerGoodsBean;
import com.hhj.merchant.bean.SellerMessageBean;
import com.hhj.merchant.bean.SellernInfoBean;
import com.hhj.merchant.bean.SubmitOrderBean;
import com.hhj.merchant.bean.SysNewVersionBean;
import com.hhj.merchant.bean.UnfinishedSellerOrdersBean;
import com.hhj.merchant.bean.WalletFlowBean;
import com.hhj.merchant.bean.WalletInfoBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.api
 * @ClassName: AppService
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/10 18:27
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/10 18:27
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public interface AppService {
    /**
     * 登陆
     */
    @POST(ApiUrls.SELLER_UC_LOGIN)
    Observable<BaseBean<LoginBean>> login(@Body Map<String, String> map);

    /**
     * 登陆
     */
    @POST(ApiUrls.SELLER_INFO_GETSELLERINFO)
    Observable<BaseBean<SellernInfoBean>> getSellerInfo();

    /**
     * 获取登录验证码
     */
    @POST(ApiUrls.SEND_AUTH_CODE)
    Observable<BaseBean> getVerifyCode(@Body Map<String, String> map);

    /**
     * 查询7天各种状态下销售量
     */
    @POST(ApiUrls.SELLER_ORDER_ORDERS_SEVENDAY_QUERYCOUNT)
    Observable<BaseBean<List<QueryCountBean>>> getQueryCount();

    /**
     * 获取商户订单列表
     */
    @POST(ApiUrls.SELLER_ORDER_ORDERS_NOSETTLEORDERS_QUERY)
    Observable<BaseBean<OrdersBean>> query(@Body Map<String, String> map);

    /**
     * seller/order/orders/changeOrdersStatus
     * 改变订单状态
     * 1.拒单2.接单3.添加备注4.发货（修改状态）5.同意退款6.拒绝退款（+退款备注）7.完成
     */
    @POST(ApiUrls.SELLER_ORDER_ORDERS_CHANGEORDERSSTATUS)
    Observable<BaseBean> changeOrdersStatus(@Body Map<String, String> map);

    /**
     * 获取配送员列表
     */
    @POST(ApiUrls.SELLER_STAFF_GETLIST)
    Observable<BaseBean<GetListBean>> getList();

    /**
     * 发货
     */
    @POST(ApiUrls.SELLER_ORDER_ORDERS_DELIVERGOODS)
    Observable<BaseBean> deliverGoods(@Body Map<String, String> map);

    /**
     * 取消发货接口
     */
    @POST(ApiUrls.SELLER_ORDER_ORDERS_CANCELDELIVERGOODS)
    Observable<BaseBean> cancelDeliverGoods(@Body Map<String, String> map);

    /**
     * 取消发货接口
     */
    @POST(ApiUrls.SELLER_ORDER_ORDERS_GETORDERS)
    Observable<BaseBean<OrdersBean>> getOrders(@Body Map<String, String> map);

    /**
     * 获得未完成的订单数量
     */
    @POST(ApiUrls.APPORDERGOODS_GETSELLERORDERSCOUNT)
    Observable<BaseBean> getSellerOrdersCount();

    /**
     * 获取所有商品类型（不需要参数）
     */
    @POST(ApiUrls.APPORDERGOODS_GETPRODUCTTYPE)
    Observable<BaseBean<List<ProductTypeBean>>> getApporderGoodsProductType();

    /**
     * 根据类型查询sku（productTypeId必传）
     */
    @POST(ApiUrls.APPORDERGOODS_GETSELLERGOODS)
    Observable<BaseBean<List<SellerGoodsBean>>> getSellerGoods(@Body Map<String, String> map);

    /**
     * 获取抵扣金币数量
     */
    @POST(ApiUrls.APPORDERGOODS_GETGOLDAMOUNT)
    Observable<BaseBean<GoldAmountBean>> getGoldAmount(@Body Map<String, String> map);

    /**
     * 提交订单
     */
    @POST(ApiUrls.APPORDERGOODS_SUBMITORDER)
    Observable<BaseBean<SubmitOrderBean>> submitOrder(@Body Map<String, String> map);


    /**
     * 提交订单
     */
    @POST(ApiUrls.SELLER_PRODUCT_EDITSELLERGOODSSTOCK)
    Observable<BaseBean> editSellerGoodsStock(@Body Map<String, String> map);
    /**
     * 提交订单
     */
    @POST(ApiUrls.APPORDERGOODS_GETUNFINISHEDSELLERORDERS)
    Observable<BaseBean<List<UnfinishedSellerOrdersBean>>> getUnfinishedSellerOrders(@Body Map<String, String> map);

    /**
     * 提交订单
     */
    @POST(ApiUrls.APPORDERGOODS_REJECTODER)
    Observable<BaseBean> rejectOder(@Body Map<String, String> map);
    /**
     * 确认补货
     */
    @POST(ApiUrls. APPORDERGOODS_CONFIRMGOODS)
    Observable<BaseBean> confirmGoods(@Body Map<String, String> map);
    /**
     * 取消订货
     */
    @POST(ApiUrls. APPORDERGOODS_CANCELORDER)
    Observable<BaseBean> cancelOrder(@Body Map<String, String> map);
    /**
     * 查询已经完成的订单
     */
    @POST(ApiUrls. APPORDERGOODS_GETSELLERHIS)
    Observable<BaseBean<List<UnfinishedSellerOrdersBean>>> getSellerHis(@Body Map<String, String> map);
    /**
     * 商品管理-商品分类
     */
    @POST(ApiUrls. SELLER_PRODUCT_GETPRODUCTTYPE)
    Observable<BaseBean<List<ProductTypeBean>>> getProductType();

    /**
     * 商品列表
     */
    @POST(ApiUrls. SELLER_PRODUCT_PRODUCTGOODLIST)
    Observable<BaseBean<List<ProductGoodListBean>>> productGoodList(@Body Map<String, String> map);
    /**
     * 豆浆业务订单 订单数量
     */
    @POST(ApiUrls. SELLER_ORDER_ORDERS_DOUJIANG_ORDERCOUNT)
    Observable<BaseBean<QueryCountBean>> ordercount();
    /**
     * 豆浆业务订单 发货
     */
    @POST(ApiUrls. SELLER_ORDER_ORDERS_DOUJIANG_CHANGESTATUS)
    Observable<BaseBean> changestatus(@Body Map<String, String> map);

    /**
     * 豆浆业务订单 订单列表
     */
    @POST(ApiUrls. SELLER_ORDER_ORDERS_DOUJIANG_LIST)
    Observable<BaseBean<List<DistributionListBean>>> doujiangList(@Body Map<String, String> map);
    /**
     * 豆浆业务订单 配送
     */
    @POST(ApiUrls. SELLER_ORDER_ORDERS_DOUJIANG_DELIVERY)
    Observable<BaseBean> delivery(@Body Map<String, String> map);
    //=====================================================钱包===========================================================

    /**
     * 获取商户金币概览
     */
    @POST(ApiUrls.SELLER_WALLET_GETWALLETINFO)
    Observable<BaseBean<WalletInfoBean>> getWalletInfo();

    /**
     * 查询商户金币变动流水
     */
    @POST(ApiUrls.SELLER_WALLET_GETWALLETFLOW)
    Observable<BaseBean<WalletFlowBean>> getWalletFlow(@Body Map<String, String> map);
    //=======================================店铺===============================================

    /**
     * 消息列表
     */
    @POST(ApiUrls.SELLER_INFO_GETSELLERMESSAGE)
    Observable<BaseBean<List<SellerMessageBean>>> getSellerMessage(@Body Map<String, String> map);

    /**
     * 修改店铺联系方式
     */
    @POST(ApiUrls.SELLER_INFO_UPDATESELLERPHONE)
    Observable<BaseBean> updateSellerPhone(@Body Map<String, String> map);

    /**
     * 商户修改密码
     */
    @POST(ApiUrls.SELLER_INFO_UPDATESELLERPASSWORD)
    Observable<BaseBean> updateSellerPassword(@Body Map<String, String> map);

    /**
     * 软件更新
     */
    @POST(ApiUrls.SELLER_SYS_GETSYSNEWVERSION)
    Observable<BaseBean<SysNewVersionBean>> getSysNewVersion(@Body Map<String, String> map);

    /**
     * 获取配送员验证码
     */
    @POST(ApiUrls.SELLER_DELIVERY_GETVERIFYCODE)
    Observable<BaseBean> getDeliveryVerifyCode(@Body Map<String, String> map);

    /**
     * 配送员配送员添加
     */
    @POST(ApiUrls.SELLER_DELIVERY_STAFF_CREATE)
    Observable<BaseBean> create(@Body Map<String, String> map);

    /**
     * 配送员配送员修改
     */
    @POST(ApiUrls.SELLER_DELIVERY_STAFF_MODIFY)
    Observable<BaseBean> modify(@Body Map<String, String> map);

    /**
     * 配送员删除
     */
    @POST(ApiUrls.SELLER_DELIVERY_STAFF_REMOVE)
    Observable<BaseBean> remove(@Body Map<String, String> map);
    /**
     * 条码获取产品信息
     */
    @POST(ApiUrls.SELLER_UNDERLINE_GETGOODSINFO)
    Observable<BaseBean<GoodsInfoBean>> getGoodsInfo(@Body Map<String, String> map);
    /**
     * 线下买单
     */
    @POST(ApiUrls.SELLER_UNDERLINE_SALERECORD)
    Observable<BaseBean> saleRecord(@Body List<Map<String,String>> mapList);
    /**
     * 订单核销
     */
    @POST(ApiUrls.SELLER_VERIFYORDER_VERIFYORDER)
    Observable<BaseBean> verifyOrder(@Body Map<String, String> map);

}
