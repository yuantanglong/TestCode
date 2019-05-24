package com.hhj.merchant.api;

/**
 * @ProjectName: hhj_android_merchant
 * @Package: com.new_hhj.code.api
 * @ClassName: ApiUrls
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/4/16 14:23
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/4/16 14:23
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ApiUrls {
    /**
     * 登录
     */
    public static final String SELLER_UC_LOGIN = "seller/uc/login";
    /**
     * 获取商户资料
     */
    public static final String SELLER_INFO_GETSELLERINFO = "seller/info/getSellerInfo";

    /**
     * seller/uc/getVerifyCode1`
     * 获取手机验证码
     */
    public static final String SEND_AUTH_CODE = "seller/uc/getVerifyCode";
    /**
     * /seller/order/orders/sevenDay/queryCount
     * 查询7天各种状态下销售量
     */
    public static final String SELLER_ORDER_ORDERS_SEVENDAY_QUERYCOUNT = "seller/order/orders/sevenDay/queryCount";
    /**
     * seller/order/orders/noSettleOrders/query
     * 获取商户订单列表
     */
    public static final String SELLER_ORDER_ORDERS_NOSETTLEORDERS_QUERY = "seller/order/orders/noSettleOrders/query";
    /**
     * seller/order/orders/changeOrdersStatus
     * 改变订单状态
     * 1.拒单2.接单3.添加备注4.发货（修改状态）5.同意退款6.拒绝退款（+退款备注）7.完成
     */
    public static final String SELLER_ORDER_ORDERS_CHANGEORDERSSTATUS = "seller/order/orders/changeOrdersStatus";
    /**
     * seller/delivery/staff/getList
     * 获取配送员列表
     */
    public static final String SELLER_STAFF_GETLIST = "seller/delivery/staff/getList";
    /**
     * seller/order/orders/deliverGoods
     * 发货
     */
    public static final String SELLER_ORDER_ORDERS_DELIVERGOODS = "seller/order/orders/deliverGoods";
    /**
     * seller/order/orders/cancelDeliverGoods
     * 取消发货接口
     */
    public static final String SELLER_ORDER_ORDERS_CANCELDELIVERGOODS = "seller/order/orders/cancelDeliverGoods";
    /**
     * seller/order/orders/getOrders
     * 订单搜索
     */
    public static final String SELLER_ORDER_ORDERS_GETORDERS = "seller/order/orders/getOrders";
    /**
     * apporderGoods/getSellerOrdersCount
     * 获得未完成的订单数量
     */
    public static final String APPORDERGOODS_GETSELLERORDERSCOUNT = "apporderGoods/getSellerOrdersCount";
    /**
     * apporderGoods/getProductType
     * 获取所有商品类型（不需要参数）
     */
    public static final String APPORDERGOODS_GETPRODUCTTYPE = "apporderGoods/getProductType";
    /**
     * apporderGoods/getSellerGoods
     * 根据类型查询sku（productTypeId必传）
     */
    public static final String APPORDERGOODS_GETSELLERGOODS = "apporderGoods/getSellerGoods";
//====================================================钱包=========================================================================

    /**
     * seller/wallet/getWalletInfo
     * 获取商户金币概览
     */
    public static final String SELLER_WALLET_GETWALLETINFO = "seller/wallet/getWalletInfo";
    /**
     * seller/wallet/getWalletFlow
     * 查询商户金币变动流水
     */
    public static final String SELLER_WALLET_GETWALLETFLOW = "seller/wallet/getWalletFlow";


//=========================================店铺=================================================

    /**
     * seller/info/getSellerMessage
     * 消息列表
     */
    public static final String SELLER_INFO_GETSELLERMESSAGE = "seller/info/getSellerMessage";
    /**
     * seller/info/updateSellerPhone
     * 修改店铺联系方式
     */
    public static final String SELLER_INFO_UPDATESELLERPHONE = "seller/info/updateSellerPhone";
    /**
     * seller/info/updateSellerPassword
     * 商户修改密码
     */
    public static final String SELLER_INFO_UPDATESELLERPASSWORD = "seller/info/updateSellerPassword";
    /**
     * seller/delivery/getVerifyCode
     * 获取配送员验证码
     */
    public static final String SELLER_DELIVERY_GETVERIFYCODE = "seller/delivery/getVerifyCode";
    /**
     * seller/delivery/staff/create
     * 配送员配送员添加
     */
    public static final String SELLER_DELIVERY_STAFF_CREATE = "seller/delivery/staff/create";
    /**
     * seller/delivery/staff/modify
     * 配送员配送员修改
     */
    public static final String SELLER_DELIVERY_STAFF_MODIFY = "seller/delivery/staff/modify";
    /**
     * seller/delivery/staff/remove
     * 配送员删除
     */
    public static final String SELLER_DELIVERY_STAFF_REMOVE = "seller/delivery/staff/remove";

    /**
     * 软件更新
     */
    public static final String SELLER_SYS_GETSYSNEWVERSION = "seller/sys/getSysNewVersion";

    /**
     * 修改店铺联系方式
     */

    public static final String SELLER_DELIVERY_PATH_DISTRIBUTORINDEX = "seller/delivery/path/distributorIndex";

}
