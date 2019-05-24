package com.hhj.merchant.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: ordersListBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 17:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 17:04
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class OrdersBean  implements Serializable {

    /**
     * result : {"ordersList":[{"id":20350,"orderId":20350,"orderSn":"519051112254784649071","orderPsn":"519051112254784684921","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":359,"distributorName":"东直门簋街哈哈镜","memberId":588072,"memberName":"187****2222","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-11 12:26:26","paymentStatus":1,"moneyProduct":24,"moneyLogistics":10,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"樊弄","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区天一阁(东直门一店)","addressInfo":"15号楼7单元","phone":"18700002222","mobile":"18700002222","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"12:00-14:00","bookEndTime":"2019.05.12","finishTime":null,"tradeSn":"2019051122001471311033668554","source":3,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.946753,"longitude":116.435369,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-11 12:25:47","updateTime":"2019-05-11 12:30:00","evaluateState":0,"isDel":0,"thirdBuyNo":"2088412690871316","cpsChannelId":0,"orderLatitude":39.947237,"orderLongitude":116.435109,"orderCityId":133,"isAutoBack":1,"bookTime":"05.12 12:00-14:00","orderProductList":[{"id":31307,"ordersId":20350,"ordersSn":"519051112254784649071","ordersPsn":"519051112254784684921","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":24,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 12:25:47","updateTime":"2019-05-11 12:25:47","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20342,"orderId":20342,"orderSn":"519051111090553728951","orderPsn":"519051111090553701846","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":359,"distributorName":"东直门簋街哈哈镜","memberId":588071,"memberName":"185****3333","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-11 11:10:29","paymentStatus":1,"moneyProduct":30,"moneyLogistics":10,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"樊女士","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区通乐饭馆(总店)","addressInfo":"15号楼7单元","phone":"18500003333","mobile":"18500003333","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"注意保质期，送货前打电话，尽快送货，到了打电话","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"10:00-12:00","bookEndTime":"2019.05.12","finishTime":null,"tradeSn":"2019051122001471311033714376","source":3,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.94676,"longitude":116.435261,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-11 11:09:05","updateTime":"2019-05-11 11:14:00","evaluateState":0,"isDel":0,"thirdBuyNo":"2088412690871316","cpsChannelId":0,"orderLatitude":39.947237,"orderLongitude":116.435109,"orderCityId":133,"isAutoBack":1,"bookTime":"05.12 10:00-12:00","orderProductList":[{"id":31302,"ordersId":20342,"ordersSn":"519051111090553728951","ordersPsn":"519051111090553701846","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6720,"productGoodsId":331,"sellerProductId":1499046,"sellerProductGoodsId":1588892,"specInfo":"辣度,微辣","productName":"鸭脖","productSku":"143243","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":18,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 11:09:05","updateTime":"2019-05-11 11:09:05","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18},{"id":31303,"ordersId":20342,"ordersSn":"519051111090553728951","ordersPsn":"519051111090553701846","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":12,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 11:09:05","updateTime":"2019-05-11 11:09:05","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20223,"orderId":20223,"orderSn":"519051012112890138910","orderPsn":"519051012112890105497","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":16,"distributorName":"经销商-西城","memberId":588070,"memberName":"160****0313","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-10 12:13:35","paymentStatus":1,"moneyProduct":30,"moneyLogistics":10,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"微信支付","paymentCode":"WXPAY","distributionType":1,"name":"好看","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区中复电讯(东直门店)","addressInfo":"区","phone":"16002120313","mobile":"16002120313","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"12:00-14:00","bookEndTime":"2019.05.11","finishTime":null,"tradeSn":"4200000305201905105673711739","source":3,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.946801,"longitude":116.435252,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-10 12:11:28","updateTime":"2019-05-10 12:17:00","evaluateState":0,"isDel":0,"thirdBuyNo":"oxCQU5h-jB33TpXKo9tnL0-0tGT4","cpsChannelId":0,"orderLatitude":39.947181,"orderLongitude":116.435283,"orderCityId":133,"isAutoBack":1,"bookTime":"05.11 12:00-14:00","orderProductList":[{"id":31248,"ordersId":20223,"ordersSn":"519051012112890138910","ordersPsn":"519051012112890105497","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6720,"productGoodsId":331,"sellerProductId":1499046,"sellerProductGoodsId":1588892,"specInfo":"辣度,微辣","productName":"鸭脖","productSku":"143243","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":18,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-10 12:11:28","updateTime":"2019-05-10 12:11:28","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18},{"id":31249,"ordersId":20223,"ordersSn":"519051012112890138910","ordersPsn":"519051012112890105497","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":12,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-10 12:11:28","updateTime":"2019-05-10 12:11:28","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20219,"orderId":20219,"orderSn":"519051011245815635861","orderPsn":"519051011245815536821","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":16,"distributorName":"经销商-西城","memberId":588069,"memberName":"160****0312","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-10 11:26:11","paymentStatus":1,"moneyProduct":36,"moneyLogistics":8,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"靳万","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区东直门内大街-道路","addressInfo":"2","phone":"16002120312","mobile":"16002120312","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"10:00-12:00","bookEndTime":"2019.05.11","finishTime":null,"tradeSn":"2019051022001449281034248296","source":4,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.947013,"longitude":116.439319,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-10 11:24:58","updateTime":"2019-05-10 11:30:02","evaluateState":0,"isDel":0,"thirdBuyNo":"2088702221649287","cpsChannelId":0,"orderLatitude":39.947241,"orderLongitude":116.435154,"orderCityId":133,"isAutoBack":1,"bookTime":"05.11 10:00-12:00","orderProductList":[{"id":31246,"ordersId":20219,"ordersSn":"519051011245815635861","ordersPsn":"519051011245815536821","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6720,"productGoodsId":331,"sellerProductId":1499046,"sellerProductGoodsId":1588892,"specInfo":"辣度,微辣","productName":"鸭脖","productSku":"143243","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":36,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-10 11:24:58","updateTime":"2019-05-10 11:24:58","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20213,"orderId":20213,"orderSn":"519050910263072058129","orderPsn":"519050910263072085041","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":16,"distributorName":"经销商-西城","memberId":587867,"memberName":"131****5641","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-09 10:42:05","paymentStatus":1,"moneyProduct":36,"moneyLogistics":8,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"106.119.42.15","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"胡","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东直门-地铁站","addressInfo":"122","phone":"13120495641","mobile":"13120495641","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"10:00-12:00","bookEndTime":"2019.05.10","finishTime":null,"tradeSn":"2019050922001449281034183984","source":4,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.947892,"longitude":116.441454,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-09 10:26:30","updateTime":"2019-05-09 10:46:00","evaluateState":0,"isDel":0,"thirdBuyNo":"2088702221649287","cpsChannelId":0,"orderLatitude":39.947318,"orderLongitude":116.43514,"orderCityId":133,"isAutoBack":1,"bookTime":"05.10 10:00-12:00","orderProductList":[{"id":31242,"ordersId":20213,"ordersSn":"519050910263072058129","ordersPsn":"519050910263072085041","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":24882,"productGoodsId":538,"sellerProductId":1499056,"sellerProductGoodsId":1588911,"specInfo":"辣度,微辣","productName":"鸭翅","productSku":"1","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":36,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-09 10:26:30","updateTime":"2019-05-09 10:26:30","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null}],"resultStatus":2}
     * success : true
     * message :
     * code :
     * pager : {"pageIndex":1,"pageSize":10,"rowsCount":5,"start":0}
     */
        /**
         * ordersList : [{"id":20350,"orderId":20350,"orderSn":"519051112254784649071","orderPsn":"519051112254784684921","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":359,"distributorName":"东直门簋街哈哈镜","memberId":588072,"memberName":"187****2222","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-11 12:26:26","paymentStatus":1,"moneyProduct":24,"moneyLogistics":10,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"樊弄","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区天一阁(东直门一店)","addressInfo":"15号楼7单元","phone":"18700002222","mobile":"18700002222","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"12:00-14:00","bookEndTime":"2019.05.12","finishTime":null,"tradeSn":"2019051122001471311033668554","source":3,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.946753,"longitude":116.435369,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-11 12:25:47","updateTime":"2019-05-11 12:30:00","evaluateState":0,"isDel":0,"thirdBuyNo":"2088412690871316","cpsChannelId":0,"orderLatitude":39.947237,"orderLongitude":116.435109,"orderCityId":133,"isAutoBack":1,"bookTime":"05.12 12:00-14:00","orderProductList":[{"id":31307,"ordersId":20350,"ordersSn":"519051112254784649071","ordersPsn":"519051112254784684921","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":24,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 12:25:47","updateTime":"2019-05-11 12:25:47","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20342,"orderId":20342,"orderSn":"519051111090553728951","orderPsn":"519051111090553701846","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":359,"distributorName":"东直门簋街哈哈镜","memberId":588071,"memberName":"185****3333","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-11 11:10:29","paymentStatus":1,"moneyProduct":30,"moneyLogistics":10,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"樊女士","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区通乐饭馆(总店)","addressInfo":"15号楼7单元","phone":"18500003333","mobile":"18500003333","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"注意保质期，送货前打电话，尽快送货，到了打电话","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"10:00-12:00","bookEndTime":"2019.05.12","finishTime":null,"tradeSn":"2019051122001471311033714376","source":3,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.94676,"longitude":116.435261,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-11 11:09:05","updateTime":"2019-05-11 11:14:00","evaluateState":0,"isDel":0,"thirdBuyNo":"2088412690871316","cpsChannelId":0,"orderLatitude":39.947237,"orderLongitude":116.435109,"orderCityId":133,"isAutoBack":1,"bookTime":"05.12 10:00-12:00","orderProductList":[{"id":31302,"ordersId":20342,"ordersSn":"519051111090553728951","ordersPsn":"519051111090553701846","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6720,"productGoodsId":331,"sellerProductId":1499046,"sellerProductGoodsId":1588892,"specInfo":"辣度,微辣","productName":"鸭脖","productSku":"143243","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":18,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 11:09:05","updateTime":"2019-05-11 11:09:05","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18},{"id":31303,"ordersId":20342,"ordersSn":"519051111090553728951","ordersPsn":"519051111090553701846","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":12,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 11:09:05","updateTime":"2019-05-11 11:09:05","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20223,"orderId":20223,"orderSn":"519051012112890138910","orderPsn":"519051012112890105497","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":16,"distributorName":"经销商-西城","memberId":588070,"memberName":"160****0313","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-10 12:13:35","paymentStatus":1,"moneyProduct":30,"moneyLogistics":10,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"微信支付","paymentCode":"WXPAY","distributionType":1,"name":"好看","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区中复电讯(东直门店)","addressInfo":"区","phone":"16002120313","mobile":"16002120313","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"12:00-14:00","bookEndTime":"2019.05.11","finishTime":null,"tradeSn":"4200000305201905105673711739","source":3,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.946801,"longitude":116.435252,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-10 12:11:28","updateTime":"2019-05-10 12:17:00","evaluateState":0,"isDel":0,"thirdBuyNo":"oxCQU5h-jB33TpXKo9tnL0-0tGT4","cpsChannelId":0,"orderLatitude":39.947181,"orderLongitude":116.435283,"orderCityId":133,"isAutoBack":1,"bookTime":"05.11 12:00-14:00","orderProductList":[{"id":31248,"ordersId":20223,"ordersSn":"519051012112890138910","ordersPsn":"519051012112890105497","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6720,"productGoodsId":331,"sellerProductId":1499046,"sellerProductGoodsId":1588892,"specInfo":"辣度,微辣","productName":"鸭脖","productSku":"143243","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":18,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-10 12:11:28","updateTime":"2019-05-10 12:11:28","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18},{"id":31249,"ordersId":20223,"ordersSn":"519051012112890138910","ordersPsn":"519051012112890105497","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":1,"moneyAmount":12,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-10 12:11:28","updateTime":"2019-05-10 12:11:28","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20219,"orderId":20219,"orderSn":"519051011245815635861","orderPsn":"519051011245815536821","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":16,"distributorName":"经销商-西城","memberId":588069,"memberName":"160****0312","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-10 11:26:11","paymentStatus":1,"moneyProduct":36,"moneyLogistics":8,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"101.254.185.130","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"靳万","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东城区东直门内大街-道路","addressInfo":"2","phone":"16002120312","mobile":"16002120312","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"10:00-12:00","bookEndTime":"2019.05.11","finishTime":null,"tradeSn":"2019051022001449281034248296","source":4,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.947013,"longitude":116.439319,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-10 11:24:58","updateTime":"2019-05-10 11:30:02","evaluateState":0,"isDel":0,"thirdBuyNo":"2088702221649287","cpsChannelId":0,"orderLatitude":39.947241,"orderLongitude":116.435154,"orderCityId":133,"isAutoBack":1,"bookTime":"05.11 10:00-12:00","orderProductList":[{"id":31246,"ordersId":20219,"ordersSn":"519051011245815635861","ordersPsn":"519051011245815536821","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6720,"productGoodsId":331,"sellerProductId":1499046,"sellerProductGoodsId":1588892,"specInfo":"辣度,微辣","productName":"鸭脖","productSku":"143243","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":36,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-10 11:24:58","updateTime":"2019-05-10 11:24:58","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null},{"id":20213,"orderId":20213,"orderSn":"519050910263072058129","orderPsn":"519050910263072085041","isSelfLifting":0,"isParent":0,"isShow":1,"relationOrderSn":"","orderType":1,"oldSellerId":1052,"oldSellerName":"外馆西街哈哈镜-VIP","sellerId":5055,"sellerName":"哈哈镜东直门总店","distributorId":16,"distributorName":"经销商-西城","memberId":587867,"memberName":"131****5641","orderState":2,"isFreeze":0,"isBack":0,"backTime":null,"payTime":"2019-05-09 10:42:05","paymentStatus":1,"moneyProduct":36,"moneyLogistics":8,"moneyOrder":0.01,"moneyPaidBalance":0,"moneyPaidReality":0.01,"moneyCoupon":0,"moneyActFull":0,"moneyDiscount":0,"backRemark":null,"moneyBack":0,"refuseOrderReason":4,"refuseBackReason":null,"moneyStringegral":0,"Stringegral":0,"couponUserIds":"","actFullId":0,"activityId":0,"ip":"106.119.42.15","paymentName":"支付宝支付","paymentCode":"ALIPAY","distributionType":1,"name":"胡","provinceId":null,"cityId":133,"areaId":null,"addressAll":"北京市东直门-地铁站","addressInfo":"122","phone":"13120495641","mobile":"13120495641","email":null,"zipCode":null,"deliveryStaffId":null,"deliveryStaffStatus":0,"riderRemark":null,"memberRemark":"","sellerRemark":null,"adminRemark":null,"deliverTime":null,"deliverType":1,"businessType":2,"distributionTime":"10:00-12:00","bookEndTime":"2019.05.10","finishTime":null,"tradeSn":"2019050922001449281034183984","source":4,"businessSource":0,"logisticsId":0,"logisticsName":null,"logisticsNumber":"","latitude":39.947892,"longitude":116.441454,"isTransferOrder":1,"transferCount":1,"sortOrder":null,"createTime":"2019-05-09 10:26:30","updateTime":"2019-05-09 10:46:00","evaluateState":0,"isDel":0,"thirdBuyNo":"2088702221649287","cpsChannelId":0,"orderLatitude":39.947318,"orderLongitude":116.43514,"orderCityId":133,"isAutoBack":1,"bookTime":"05.10 10:00-12:00","orderProductList":[{"id":31242,"ordersId":20213,"ordersSn":"519050910263072058129","ordersPsn":"519050910263072085041","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":24882,"productGoodsId":538,"sellerProductId":1499056,"sellerProductGoodsId":1588911,"specInfo":"辣度,微辣","productName":"鸭翅","productSku":"1","moneyPrice":18,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":36,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-09 10:26:30","updateTime":"2019-05-09 10:26:30","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":18}],"numberCount":2,"isTodayorder":0,"backOrExchangeNum":null,"isShowBackAndExchange":null,"forwardingTime":null,"cancelOrderContent":null,"sellerCancelReason":null,"waitPayTime":null,"isOverCalcProfit":0,"createOrderTime":null,"updateOrderTime":null,"paymentOrderStatus":null,"state":null,"orderDiliverContent":null,"orderLogList":null,"companyAdd":null,"telephone":null,"presidePerson":null,"presidePhone":null,"companyStartTime":null,"companyEndTime":null,"deliveryStartTime":null,"deliveryEndTime":null,"couponTypeId":null,"ordersExpressLog":null,"orderLog":null,"couponUserlist":null,"couponOptLogList":null,"logisticsInformations":null,"icpsChannelService":null}]
         * resultStatus : 2
         */

        private String resultStatus;
        private List<OrdersListBean> ordersList;

        public String getResultStatus() {
            return resultStatus;
        }

        public void setResultStatus(String resultStatus) {
            this.resultStatus = resultStatus;
        }

        public List<OrdersListBean> getOrdersList() {
            return ordersList;
        }

        public void setOrdersList(List<OrdersListBean> ordersList) {
            this.ordersList = ordersList;
        }

        public static class OrdersListBean implements Serializable{
            /**
             * id : 20350
             * orderId : 20350
             * orderSn : 519051112254784649071
             * orderPsn : 519051112254784684921
             * isSelfLifting : 0
             * isParent : 0
             * isShow : 1
             * relationOrderSn :
             * orderType : 1
             * oldSellerId : 1052
             * oldSellerName : 外馆西街哈哈镜-VIP
             * sellerId : 5055
             * sellerName : 哈哈镜东直门总店
             * distributorId : 359
             * distributorName : 东直门簋街哈哈镜
             * memberId : 588072
             * memberName : 187****2222
             * orderState : 2
             * isFreeze : 0
             * isBack : 0
             * backTime : null
             * payTime : 2019-05-11 12:26:26
             * paymentStatus : 1
             * moneyProduct : 24
             * moneyLogistics : 10
             * moneyOrder : 0.01
             * moneyPaidBalance : 0
             * moneyPaidReality : 0.01
             * moneyCoupon : 0
             * moneyActFull : 0
             * moneyDiscount : 0
             * backRemark : null
             * moneyBack : 0
             * refuseOrderReason : 4
             * refuseBackReason : null
             * moneyStringegral : 0
             * Stringegral : 0
             * couponUserIds :
             * actFullId : 0
             * activityId : 0
             * ip : 101.254.185.130
             * paymentName : 支付宝支付
             * paymentCode : ALIPAY
             * distributionType : 1
             * name : 樊弄
             * provinceId : null
             * cityId : 133
             * areaId : null
             * addressAll : 北京市东城区天一阁(东直门一店)
             * addressInfo : 15号楼7单元
             * phone : 18700002222
             * mobile : 18700002222
             * email : null
             * zipCode : null
             * deliveryStaffId : null
             * deliveryStaffStatus : 0
             * riderRemark : null
             * memberRemark :
             * sellerRemark : null
             * adminRemark : null
             * deliverTime : null
             * deliverType : 1
             * businessType : 2
             * distributionTime : 12:00-14:00
             * bookEndTime : 2019.05.12
             * finishTime : null
             * tradeSn : 2019051122001471311033668554
             * source : 3
             * businessSource : 0
             * logisticsId : 0
             * logisticsName : null
             * logisticsNumber :
             * latitude : 39.946753
             * longitude : 116.435369
             * isTransferOrder : 1
             * transferCount : 1
             * sortOrder : null
             * createTime : 2019-05-11 12:25:47
             * updateTime : 2019-05-11 12:30:00
             * evaluateState : 0
             * isDel : 0
             * thirdBuyNo : 2088412690871316
             * cpsChannelId : 0
             * orderLatitude : 39.947237
             * orderLongitude : 116.435109
             * orderCityId : 133
             * isAutoBack : 1
             * bookTime : 05.12 12:00-14:00
             * orderProductList : [{"id":31307,"ordersId":20350,"ordersSn":"519051112254784649071","ordersPsn":"519051112254784684921","sellerId":5055,"sellerName":"哈哈镜东直门总店","productCateId":-1,"productId":6753,"productGoodsId":346,"sellerProductId":1499153,"sellerProductGoodsId":1589171,"specInfo":"辣度,微辣","productName":"鸭头","productSku":"1","moneyPrice":12,"discountAmount":null,"payAmount":null,"number":2,"moneyAmount":24,"moneyActSingle":0,"actSingleId":0,"actGroupId":0,"activityId":null,"actBiddingId":0,"actStringegralId":0,"actStringegralNum":0,"actStringegralMoney":0,"systemRemark":null,"backNumber":0,"exchangeNumber":0,"createTime":"2019-05-11 12:25:47","updateTime":"2019-05-11 12:25:47","isEvaluate":0,"isBook":0,"isTakeGoods":0,"isGift":0,"giftOrdersProductId":0,"sellerProduct":null,"productLeadPicpath":null,"productLeadMiddle":null,"productLeadLittle":null,"images":null,"norms":[{"normName":"辣度","normValue":"微辣"}],"actConfVO":null,"activityCount":null,"activityPrice":12}]
             * numberCount : 2
             * isTodayorder : 0
             * backOrExchangeNum : null
             * isShowBackAndExchange : null
             * forwardingTime : null
             * cancelOrderContent : null
             * sellerCancelReason : null
             * waitPayTime : null
             * isOverCalcProfit : 0
             * createOrderTime : null
             * updateOrderTime : null
             * paymentOrderStatus : null
             * state : null
             * orderDiliverContent : null
             * orderLogList : null
             * companyAdd : null
             * telephone : null
             * presidePerson : null
             * presidePhone : null
             * companyStartTime : null
             * companyEndTime : null
             * deliveryStartTime : null
             * deliveryEndTime : null
             * couponTypeId : null
             * ordersExpressLog : null
             * orderLog : null
             * couponUserlist : null
             * couponOptLogList : null
             * logisticsInformations : null
             * icpsChannelService : null
             */

            private String id;
            private String orderId;
            private String orderSn;
            private String orderPsn;
            private String isSelfLifting;
            private String isParent;
            private String isShow;
            private String relationOrderSn;
            private String orderType;
            private String oldSellerId;
            private String oldSellerName;
            private String sellerId;
            private String sellerName;
            private String distributorId;
            private String distributorName;
            private String memberId;
            private String memberName;
            private String orderState;
            private String isFreeze;
            private String isBack;
            private String backTime;
            private String payTime;
            private String paymentStatus;
            private String moneyProduct;
            private String moneyLogistics;
            private String moneyOrder;
            private String moneyPaidBalance;
            private String moneyPaidReality;
            private String moneyCoupon;
            private String moneyActFull;
            private String moneyDiscount;
            private String backRemark;
            private String moneyBack;
            private String refuseOrderReason;
            private String refuseBackReason;
            private String moneyStringegral;
            private String Stringegral;
            private String couponUserIds;
            private String actFullId;
            private String activityId;
            private String ip;
            private String paymentName;
            private String paymentCode;
            private String distributionType;
            private String name;
            private String provinceId;
            private String cityId;
            private String areaId;
            private String addressAll;
            private String addressInfo;
            private String phone;
            private String mobile;
            private String email;
            private String zipCode;
            private String deliveryStaffId;
            private String deliveryStaffStatus;
            private String riderRemark;
            private String memberRemark;
            private String sellerRemark;
            private String adminRemark;
            private String deliverTime;
            private String deliverType;
            private String businessType;
            private String distributionTime;
            private String bookEndTime;
            private String finishTime;
            private String tradeSn;
            private String source;
            private String businessSource;
            private String logisticsId;
            private String logisticsName;
            private String logisticsNumber;
            private String latitude;
            private String longitude;
            private String isTransferOrder;
            private String transferCount;
            private String sortOrder;
            private String createTime;
            private String updateTime;
            private String evaluateState;
            private String isDel;
            private String thirdBuyNo;
            private String cpsChannelId;
            private String orderLatitude;
            private String orderLongitude;
            private String orderCityId;
            private String isAutoBack;
            private String bookTime;
            private String numberCount;
            private String isTodayorder;
            private String backOrExchangeNum;
            private String isShowBackAndExchange;
            private String forwardingTime;
            private String cancelOrderContent;
            private String sellerCancelReason;
            private String waitPayTime;
            private String isOverCalcProfit;
            private String createOrderTime;
            private String updateOrderTime;
            private String paymentOrderStatus;
            private String state;
            private String orderDiliverContent;
            private String orderLogList;
            private String companyAdd;
            private String telephone;
            private String presidePerson;
            private String presidePhone;
            private String companyStartTime;
            private String companyEndTime;
            private String deliveryStartTime;
            private String deliveryEndTime;
            private String couponTypeId;
            private String ordersExpressLog;
            private String orderLog;
            private String couponUserlist;
            private String couponOptLogList;
            private String logisticsInformations;
            private String icpsChannelService;
            private List<OrderProductListBean> orderProductList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getOrderSn() {
                return orderSn;
            }

            public void setOrderSn(String orderSn) {
                this.orderSn = orderSn;
            }

            public String getOrderPsn() {
                return orderPsn;
            }

            public void setOrderPsn(String orderPsn) {
                this.orderPsn = orderPsn;
            }

            public String getIsSelfLifting() {
                return isSelfLifting;
            }

            public void setIsSelfLifting(String isSelfLifting) {
                this.isSelfLifting = isSelfLifting;
            }

            public String getIsParent() {
                return isParent;
            }

            public void setIsParent(String isParent) {
                this.isParent = isParent;
            }

            public String getIsShow() {
                return isShow;
            }

            public void setIsShow(String isShow) {
                this.isShow = isShow;
            }

            public String getRelationOrderSn() {
                return relationOrderSn;
            }

            public void setRelationOrderSn(String relationOrderSn) {
                this.relationOrderSn = relationOrderSn;
            }

            public String getOrderType() {
                return orderType;
            }

            public void setOrderType(String orderType) {
                this.orderType = orderType;
            }

            public String getOldSellerId() {
                return oldSellerId;
            }

            public void setOldSellerId(String oldSellerId) {
                this.oldSellerId = oldSellerId;
            }

            public String getOldSellerName() {
                return oldSellerName;
            }

            public void setOldSellerName(String oldSellerName) {
                this.oldSellerName = oldSellerName;
            }

            public String getSellerId() {
                return sellerId;
            }

            public void setSellerId(String sellerId) {
                this.sellerId = sellerId;
            }

            public String getSellerName() {
                return sellerName;
            }

            public void setSellerName(String sellerName) {
                this.sellerName = sellerName;
            }

            public String getDistributorId() {
                return distributorId;
            }

            public void setDistributorId(String distributorId) {
                this.distributorId = distributorId;
            }

            public String getDistributorName() {
                return distributorName;
            }

            public void setDistributorName(String distributorName) {
                this.distributorName = distributorName;
            }

            public String getMemberId() {
                return memberId;
            }

            public void setMemberId(String memberId) {
                this.memberId = memberId;
            }

            public String getMemberName() {
                return memberName;
            }

            public void setMemberName(String memberName) {
                this.memberName = memberName;
            }

            public String getOrderState() {
                return orderState;
            }

            public void setOrderState(String orderState) {
                this.orderState = orderState;
            }

            public String getIsFreeze() {
                return isFreeze;
            }

            public void setIsFreeze(String isFreeze) {
                this.isFreeze = isFreeze;
            }

            public String getIsBack() {
                return isBack;
            }

            public void setIsBack(String isBack) {
                this.isBack = isBack;
            }

            public String getBackTime() {
                return backTime;
            }

            public void setBackTime(String backTime) {
                this.backTime = backTime;
            }

            public String getPayTime() {
                return payTime;
            }

            public void setPayTime(String payTime) {
                this.payTime = payTime;
            }

            public String getPaymentStatus() {
                return paymentStatus;
            }

            public void setPaymentStatus(String paymentStatus) {
                this.paymentStatus = paymentStatus;
            }

            public String getMoneyProduct() {
                return moneyProduct;
            }

            public void setMoneyProduct(String moneyProduct) {
                this.moneyProduct = moneyProduct;
            }

            public String getMoneyLogistics() {
                return moneyLogistics;
            }

            public void setMoneyLogistics(String moneyLogistics) {
                this.moneyLogistics = moneyLogistics;
            }

            public String getMoneyOrder() {
                return moneyOrder;
            }

            public void setMoneyOrder(String moneyOrder) {
                this.moneyOrder = moneyOrder;
            }

            public String getMoneyPaidBalance() {
                return moneyPaidBalance;
            }

            public void setMoneyPaidBalance(String moneyPaidBalance) {
                this.moneyPaidBalance = moneyPaidBalance;
            }

            public String getMoneyPaidReality() {
                return moneyPaidReality;
            }

            public void setMoneyPaidReality(String moneyPaidReality) {
                this.moneyPaidReality = moneyPaidReality;
            }

            public String getMoneyCoupon() {
                return moneyCoupon;
            }

            public void setMoneyCoupon(String moneyCoupon) {
                this.moneyCoupon = moneyCoupon;
            }

            public String getMoneyActFull() {
                return moneyActFull;
            }

            public void setMoneyActFull(String moneyActFull) {
                this.moneyActFull = moneyActFull;
            }

            public String getMoneyDiscount() {
                return moneyDiscount;
            }

            public void setMoneyDiscount(String moneyDiscount) {
                this.moneyDiscount = moneyDiscount;
            }

            public String getBackRemark() {
                return backRemark;
            }

            public void setBackRemark(String backRemark) {
                this.backRemark = backRemark;
            }

            public String getMoneyBack() {
                return moneyBack;
            }

            public void setMoneyBack(String moneyBack) {
                this.moneyBack = moneyBack;
            }

            public String getRefuseOrderReason() {
                return refuseOrderReason;
            }

            public void setRefuseOrderReason(String refuseOrderReason) {
                this.refuseOrderReason = refuseOrderReason;
            }

            public String getRefuseBackReason() {
                return refuseBackReason;
            }

            public void setRefuseBackReason(String refuseBackReason) {
                this.refuseBackReason = refuseBackReason;
            }

            public String getMoneyStringegral() {
                return moneyStringegral;
            }

            public void setMoneyStringegral(String moneyStringegral) {
                this.moneyStringegral = moneyStringegral;
            }

            public String getStringegral() {
                return Stringegral;
            }

            public void setStringegral(String Stringegral) {
                this.Stringegral = Stringegral;
            }

            public String getCouponUserIds() {
                return couponUserIds;
            }

            public void setCouponUserIds(String couponUserIds) {
                this.couponUserIds = couponUserIds;
            }

            public String getActFullId() {
                return actFullId;
            }

            public void setActFullId(String actFullId) {
                this.actFullId = actFullId;
            }

            public String getActivityId() {
                return activityId;
            }

            public void setActivityId(String activityId) {
                this.activityId = activityId;
            }

            public String getIp() {
                return ip;
            }

            public void setIp(String ip) {
                this.ip = ip;
            }

            public String getPaymentName() {
                return paymentName;
            }

            public void setPaymentName(String paymentName) {
                this.paymentName = paymentName;
            }

            public String getPaymentCode() {
                return paymentCode;
            }

            public void setPaymentCode(String paymentCode) {
                this.paymentCode = paymentCode;
            }

            public String getDistributionType() {
                return distributionType;
            }

            public void setDistributionType(String distributionType) {
                this.distributionType = distributionType;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(String provinceId) {
                this.provinceId = provinceId;
            }

            public String getCityId() {
                return cityId;
            }

            public void setCityId(String cityId) {
                this.cityId = cityId;
            }

            public String getAreaId() {
                return areaId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getAddressAll() {
                return addressAll;
            }

            public void setAddressAll(String addressAll) {
                this.addressAll = addressAll;
            }

            public String getAddressInfo() {
                return addressInfo;
            }

            public void setAddressInfo(String addressInfo) {
                this.addressInfo = addressInfo;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getZipCode() {
                return zipCode;
            }

            public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
            }

            public String getDeliveryStaffId() {
                return deliveryStaffId;
            }

            public void setDeliveryStaffId(String deliveryStaffId) {
                this.deliveryStaffId = deliveryStaffId;
            }

            public String getDeliveryStaffStatus() {
                return deliveryStaffStatus;
            }

            public void setDeliveryStaffStatus(String deliveryStaffStatus) {
                this.deliveryStaffStatus = deliveryStaffStatus;
            }

            public String getRiderRemark() {
                return riderRemark;
            }

            public void setRiderRemark(String riderRemark) {
                this.riderRemark = riderRemark;
            }

            public String getMemberRemark() {
                return memberRemark;
            }

            public void setMemberRemark(String memberRemark) {
                this.memberRemark = memberRemark;
            }

            public String getSellerRemark() {
                return sellerRemark;
            }

            public void setSellerRemark(String sellerRemark) {
                this.sellerRemark = sellerRemark;
            }

            public String getAdminRemark() {
                return adminRemark;
            }

            public void setAdminRemark(String adminRemark) {
                this.adminRemark = adminRemark;
            }

            public String getDeliverTime() {
                return deliverTime;
            }

            public void setDeliverTime(String deliverTime) {
                this.deliverTime = deliverTime;
            }

            public String getDeliverType() {
                return deliverType;
            }

            public void setDeliverType(String deliverType) {
                this.deliverType = deliverType;
            }

            public String getBusinessType() {
                return businessType;
            }

            public void setBusinessType(String businessType) {
                this.businessType = businessType;
            }

            public String getDistributionTime() {
                return distributionTime;
            }

            public void setDistributionTime(String distributionTime) {
                this.distributionTime = distributionTime;
            }

            public String getBookEndTime() {
                return bookEndTime;
            }

            public void setBookEndTime(String bookEndTime) {
                this.bookEndTime = bookEndTime;
            }

            public String getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(String finishTime) {
                this.finishTime = finishTime;
            }

            public String getTradeSn() {
                return tradeSn;
            }

            public void setTradeSn(String tradeSn) {
                this.tradeSn = tradeSn;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getBusinessSource() {
                return businessSource;
            }

            public void setBusinessSource(String businessSource) {
                this.businessSource = businessSource;
            }

            public String getLogisticsId() {
                return logisticsId;
            }

            public void setLogisticsId(String logisticsId) {
                this.logisticsId = logisticsId;
            }

            public String getLogisticsName() {
                return logisticsName;
            }

            public void setLogisticsName(String logisticsName) {
                this.logisticsName = logisticsName;
            }

            public String getLogisticsNumber() {
                return logisticsNumber;
            }

            public void setLogisticsNumber(String logisticsNumber) {
                this.logisticsNumber = logisticsNumber;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getIsTransferOrder() {
                return isTransferOrder;
            }

            public void setIsTransferOrder(String isTransferOrder) {
                this.isTransferOrder = isTransferOrder;
            }

            public String getTransferCount() {
                return transferCount;
            }

            public void setTransferCount(String transferCount) {
                this.transferCount = transferCount;
            }

            public String getSortOrder() {
                return sortOrder;
            }

            public void setSortOrder(String sortOrder) {
                this.sortOrder = sortOrder;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getEvaluateState() {
                return evaluateState;
            }

            public void setEvaluateState(String evaluateState) {
                this.evaluateState = evaluateState;
            }

            public String getIsDel() {
                return isDel;
            }

            public void setIsDel(String isDel) {
                this.isDel = isDel;
            }

            public String getThirdBuyNo() {
                return thirdBuyNo;
            }

            public void setThirdBuyNo(String thirdBuyNo) {
                this.thirdBuyNo = thirdBuyNo;
            }

            public String getCpsChannelId() {
                return cpsChannelId;
            }

            public void setCpsChannelId(String cpsChannelId) {
                this.cpsChannelId = cpsChannelId;
            }

            public String getOrderLatitude() {
                return orderLatitude;
            }

            public void setOrderLatitude(String orderLatitude) {
                this.orderLatitude = orderLatitude;
            }

            public String getOrderLongitude() {
                return orderLongitude;
            }

            public void setOrderLongitude(String orderLongitude) {
                this.orderLongitude = orderLongitude;
            }

            public String getOrderCityId() {
                return orderCityId;
            }

            public void setOrderCityId(String orderCityId) {
                this.orderCityId = orderCityId;
            }

            public String getIsAutoBack() {
                return isAutoBack;
            }

            public void setIsAutoBack(String isAutoBack) {
                this.isAutoBack = isAutoBack;
            }

            public String getBookTime() {
                return bookTime;
            }

            public void setBookTime(String bookTime) {
                this.bookTime = bookTime;
            }

            public String getNumberCount() {
                return numberCount;
            }

            public void setNumberCount(String numberCount) {
                this.numberCount = numberCount;
            }

            public String getIsTodayorder() {
                return isTodayorder;
            }

            public void setIsTodayorder(String isTodayorder) {
                this.isTodayorder = isTodayorder;
            }

            public String getBackOrExchangeNum() {
                return backOrExchangeNum;
            }

            public void setBackOrExchangeNum(String backOrExchangeNum) {
                this.backOrExchangeNum = backOrExchangeNum;
            }

            public String getIsShowBackAndExchange() {
                return isShowBackAndExchange;
            }

            public void setIsShowBackAndExchange(String isShowBackAndExchange) {
                this.isShowBackAndExchange = isShowBackAndExchange;
            }

            public String getForwardingTime() {
                return forwardingTime;
            }

            public void setForwardingTime(String forwardingTime) {
                this.forwardingTime = forwardingTime;
            }

            public String getCancelOrderContent() {
                return cancelOrderContent;
            }

            public void setCancelOrderContent(String cancelOrderContent) {
                this.cancelOrderContent = cancelOrderContent;
            }

            public String getSellerCancelReason() {
                return sellerCancelReason;
            }

            public void setSellerCancelReason(String sellerCancelReason) {
                this.sellerCancelReason = sellerCancelReason;
            }

            public String getWaitPayTime() {
                return waitPayTime;
            }

            public void setWaitPayTime(String waitPayTime) {
                this.waitPayTime = waitPayTime;
            }

            public String getIsOverCalcProfit() {
                return isOverCalcProfit;
            }

            public void setIsOverCalcProfit(String isOverCalcProfit) {
                this.isOverCalcProfit = isOverCalcProfit;
            }

            public String getCreateOrderTime() {
                return createOrderTime;
            }

            public void setCreateOrderTime(String createOrderTime) {
                this.createOrderTime = createOrderTime;
            }

            public String getUpdateOrderTime() {
                return updateOrderTime;
            }

            public void setUpdateOrderTime(String updateOrderTime) {
                this.updateOrderTime = updateOrderTime;
            }

            public String getPaymentOrderStatus() {
                return paymentOrderStatus;
            }

            public void setPaymentOrderStatus(String paymentOrderStatus) {
                this.paymentOrderStatus = paymentOrderStatus;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getOrderDiliverContent() {
                return orderDiliverContent;
            }

            public void setOrderDiliverContent(String orderDiliverContent) {
                this.orderDiliverContent = orderDiliverContent;
            }

            public String getOrderLogList() {
                return orderLogList;
            }

            public void setOrderLogList(String orderLogList) {
                this.orderLogList = orderLogList;
            }

            public String getCompanyAdd() {
                return companyAdd;
            }

            public void setCompanyAdd(String companyAdd) {
                this.companyAdd = companyAdd;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getPresidePerson() {
                return presidePerson;
            }

            public void setPresidePerson(String presidePerson) {
                this.presidePerson = presidePerson;
            }

            public String getPresidePhone() {
                return presidePhone;
            }

            public void setPresidePhone(String presidePhone) {
                this.presidePhone = presidePhone;
            }

            public String getCompanyStartTime() {
                return companyStartTime;
            }

            public void setCompanyStartTime(String companyStartTime) {
                this.companyStartTime = companyStartTime;
            }

            public String getCompanyEndTime() {
                return companyEndTime;
            }

            public void setCompanyEndTime(String companyEndTime) {
                this.companyEndTime = companyEndTime;
            }

            public String getDeliveryStartTime() {
                return deliveryStartTime;
            }

            public void setDeliveryStartTime(String deliveryStartTime) {
                this.deliveryStartTime = deliveryStartTime;
            }

            public String getDeliveryEndTime() {
                return deliveryEndTime;
            }

            public void setDeliveryEndTime(String deliveryEndTime) {
                this.deliveryEndTime = deliveryEndTime;
            }

            public String getCouponTypeId() {
                return couponTypeId;
            }

            public void setCouponTypeId(String couponTypeId) {
                this.couponTypeId = couponTypeId;
            }

            public String getOrdersExpressLog() {
                return ordersExpressLog;
            }

            public void setOrdersExpressLog(String ordersExpressLog) {
                this.ordersExpressLog = ordersExpressLog;
            }

            public String getOrderLog() {
                return orderLog;
            }

            public void setOrderLog(String orderLog) {
                this.orderLog = orderLog;
            }

            public String getCouponUserlist() {
                return couponUserlist;
            }

            public void setCouponUserlist(String couponUserlist) {
                this.couponUserlist = couponUserlist;
            }

            public String getCouponOptLogList() {
                return couponOptLogList;
            }

            public void setCouponOptLogList(String couponOptLogList) {
                this.couponOptLogList = couponOptLogList;
            }

            public String getLogisticsInformations() {
                return logisticsInformations;
            }

            public void setLogisticsInformations(String logisticsInformations) {
                this.logisticsInformations = logisticsInformations;
            }

            public String getIcpsChannelService() {
                return icpsChannelService;
            }

            public void setIcpsChannelService(String icpsChannelService) {
                this.icpsChannelService = icpsChannelService;
            }

            public List<OrderProductListBean> getOrderProductList() {
                return orderProductList;
            }

            public void setOrderProductList(List<OrderProductListBean> orderProductList) {
                this.orderProductList = orderProductList;
            }

            public static class OrderProductListBean implements Serializable{
                /**
                 * id : 31307
                 * ordersId : 20350
                 * ordersSn : 519051112254784649071
                 * ordersPsn : 519051112254784684921
                 * sellerId : 5055
                 * sellerName : 哈哈镜东直门总店
                 * productCateId : -1
                 * productId : 6753
                 * productGoodsId : 346
                 * sellerProductId : 1499153
                 * sellerProductGoodsId : 1589171
                 * specInfo : 辣度,微辣
                 * productName : 鸭头
                 * productSku : 1
                 * moneyPrice : 12
                 * discountAmount : null
                 * payAmount : null
                 * number : 2
                 * moneyAmount : 24
                 * moneyActSingle : 0
                 * actSingleId : 0
                 * actGroupId : 0
                 * activityId : null
                 * actBiddingId : 0
                 * actStringegralId : 0
                 * actStringegralNum : 0
                 * actStringegralMoney : 0
                 * systemRemark : null
                 * backNumber : 0
                 * exchangeNumber : 0
                 * createTime : 2019-05-11 12:25:47
                 * updateTime : 2019-05-11 12:25:47
                 * isEvaluate : 0
                 * isBook : 0
                 * isTakeGoods : 0
                 * isGift : 0
                 * giftOrdersProductId : 0
                 * sellerProduct : null
                 * productLeadPicpath : null
                 * productLeadMiddle : null
                 * productLeadLittle : null
                 * images : null
                 * norms : [{"normName":"辣度","normValue":"微辣"}]
                 * actConfVO : null
                 * activityCount : null
                 * activityPrice : 12
                 */

                private String id;
                private String ordersId;
                private String ordersSn;
                private String ordersPsn;
                private String sellerId;
                private String sellerName;
                private String productCateId;
                private String productId;
                private String productGoodsId;
                private String sellerProductId;
                private String sellerProductGoodsId;
                private String specInfo;
                private String productName;
                private String productSku;
                private String moneyPrice;
                private String discountAmount;
                private String payAmount;
                private String number;
                private String moneyAmount;
                private String moneyActSingle;
                private String actSingleId;
                private String actGroupId;
                private String activityId;
                private String actBiddingId;
                private String actStringegralId;
                private String actStringegralNum;
                private String actStringegralMoney;
                private String systemRemark;
                private String backNumber;
                private String exchangeNumber;
                private String createTime;
                private String updateTime;
                private String isEvaluate;
                private String isBook;
                private String isTakeGoods;
                private String isGift;
                private String giftOrdersProductId;
                private String sellerProduct;
                private String productLeadPicpath;
                private String productLeadMiddle;
                private String productLeadLittle;
                private String images;
                private String actConfVO;
                private String activityCount;
                private String activityPrice;
                private List<NormsBean> norms;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOrdersId() {
                    return ordersId;
                }

                public void setOrdersId(String ordersId) {
                    this.ordersId = ordersId;
                }

                public String getOrdersSn() {
                    return ordersSn;
                }

                public void setOrdersSn(String ordersSn) {
                    this.ordersSn = ordersSn;
                }

                public String getOrdersPsn() {
                    return ordersPsn;
                }

                public void setOrdersPsn(String ordersPsn) {
                    this.ordersPsn = ordersPsn;
                }

                public String getSellerId() {
                    return sellerId;
                }

                public void setSellerId(String sellerId) {
                    this.sellerId = sellerId;
                }

                public String getSellerName() {
                    return sellerName;
                }

                public void setSellerName(String sellerName) {
                    this.sellerName = sellerName;
                }

                public String getProductCateId() {
                    return productCateId;
                }

                public void setProductCateId(String productCateId) {
                    this.productCateId = productCateId;
                }

                public String getProductId() {
                    return productId;
                }

                public void setProductId(String productId) {
                    this.productId = productId;
                }

                public String getProductGoodsId() {
                    return productGoodsId;
                }

                public void setProductGoodsId(String productGoodsId) {
                    this.productGoodsId = productGoodsId;
                }

                public String getSellerProductId() {
                    return sellerProductId;
                }

                public void setSellerProductId(String sellerProductId) {
                    this.sellerProductId = sellerProductId;
                }

                public String getSellerProductGoodsId() {
                    return sellerProductGoodsId;
                }

                public void setSellerProductGoodsId(String sellerProductGoodsId) {
                    this.sellerProductGoodsId = sellerProductGoodsId;
                }

                public String getSpecInfo() {
                    return specInfo;
                }

                public void setSpecInfo(String specInfo) {
                    this.specInfo = specInfo;
                }

                public String getProductName() {
                    return productName;
                }

                public void setProductName(String productName) {
                    this.productName = productName;
                }

                public String getProductSku() {
                    return productSku;
                }

                public void setProductSku(String productSku) {
                    this.productSku = productSku;
                }

                public String getMoneyPrice() {
                    return moneyPrice;
                }

                public void setMoneyPrice(String moneyPrice) {
                    this.moneyPrice = moneyPrice;
                }

                public String getDiscountAmount() {
                    return discountAmount;
                }

                public void setDiscountAmount(String discountAmount) {
                    this.discountAmount = discountAmount;
                }

                public String getPayAmount() {
                    return payAmount;
                }

                public void setPayAmount(String payAmount) {
                    this.payAmount = payAmount;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public String getMoneyAmount() {
                    return moneyAmount;
                }

                public void setMoneyAmount(String moneyAmount) {
                    this.moneyAmount = moneyAmount;
                }

                public String getMoneyActSingle() {
                    return moneyActSingle;
                }

                public void setMoneyActSingle(String moneyActSingle) {
                    this.moneyActSingle = moneyActSingle;
                }

                public String getActSingleId() {
                    return actSingleId;
                }

                public void setActSingleId(String actSingleId) {
                    this.actSingleId = actSingleId;
                }

                public String getActGroupId() {
                    return actGroupId;
                }

                public void setActGroupId(String actGroupId) {
                    this.actGroupId = actGroupId;
                }

                public String getActivityId() {
                    return activityId;
                }

                public void setActivityId(String activityId) {
                    this.activityId = activityId;
                }

                public String getActBiddingId() {
                    return actBiddingId;
                }

                public void setActBiddingId(String actBiddingId) {
                    this.actBiddingId = actBiddingId;
                }

                public String getActStringegralId() {
                    return actStringegralId;
                }

                public void setActStringegralId(String actStringegralId) {
                    this.actStringegralId = actStringegralId;
                }

                public String getActStringegralNum() {
                    return actStringegralNum;
                }

                public void setActStringegralNum(String actStringegralNum) {
                    this.actStringegralNum = actStringegralNum;
                }

                public String getActStringegralMoney() {
                    return actStringegralMoney;
                }

                public void setActStringegralMoney(String actStringegralMoney) {
                    this.actStringegralMoney = actStringegralMoney;
                }

                public String getSystemRemark() {
                    return systemRemark;
                }

                public void setSystemRemark(String systemRemark) {
                    this.systemRemark = systemRemark;
                }

                public String getBackNumber() {
                    return backNumber;
                }

                public void setBackNumber(String backNumber) {
                    this.backNumber = backNumber;
                }

                public String getExchangeNumber() {
                    return exchangeNumber;
                }

                public void setExchangeNumber(String exchangeNumber) {
                    this.exchangeNumber = exchangeNumber;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getIsEvaluate() {
                    return isEvaluate;
                }

                public void setIsEvaluate(String isEvaluate) {
                    this.isEvaluate = isEvaluate;
                }

                public String getIsBook() {
                    return isBook;
                }

                public void setIsBook(String isBook) {
                    this.isBook = isBook;
                }

                public String getIsTakeGoods() {
                    return isTakeGoods;
                }

                public void setIsTakeGoods(String isTakeGoods) {
                    this.isTakeGoods = isTakeGoods;
                }

                public String getIsGift() {
                    return isGift;
                }

                public void setIsGift(String isGift) {
                    this.isGift = isGift;
                }

                public String getGiftOrdersProductId() {
                    return giftOrdersProductId;
                }

                public void setGiftOrdersProductId(String giftOrdersProductId) {
                    this.giftOrdersProductId = giftOrdersProductId;
                }

                public String getSellerProduct() {
                    return sellerProduct;
                }

                public void setSellerProduct(String sellerProduct) {
                    this.sellerProduct = sellerProduct;
                }

                public String getProductLeadPicpath() {
                    return productLeadPicpath;
                }

                public void setProductLeadPicpath(String productLeadPicpath) {
                    this.productLeadPicpath = productLeadPicpath;
                }

                public String getProductLeadMiddle() {
                    return productLeadMiddle;
                }

                public void setProductLeadMiddle(String productLeadMiddle) {
                    this.productLeadMiddle = productLeadMiddle;
                }

                public String getProductLeadLittle() {
                    return productLeadLittle;
                }

                public void setProductLeadLittle(String productLeadLittle) {
                    this.productLeadLittle = productLeadLittle;
                }

                public String getImages() {
                    return images;
                }

                public void setImages(String images) {
                    this.images = images;
                }

                public String getActConfVO() {
                    return actConfVO;
                }

                public void setActConfVO(String actConfVO) {
                    this.actConfVO = actConfVO;
                }

                public String getActivityCount() {
                    return activityCount;
                }

                public void setActivityCount(String activityCount) {
                    this.activityCount = activityCount;
                }

                public String getActivityPrice() {
                    return activityPrice;
                }

                public void setActivityPrice(String activityPrice) {
                    this.activityPrice = activityPrice;
                }

                public List<NormsBean> getNorms() {
                    return norms;
                }

                public void setNorms(List<NormsBean> norms) {
                    this.norms = norms;
                }

                public static class NormsBean implements Serializable{
                    /**
                     * normName : 辣度
                     * normValue : 微辣
                     */

                    private String normName;
                    private String normValue;

                    public String getNormName() {
                        return normName;
                    }

                    public void setNormName(String normName) {
                        this.normName = normName;
                    }

                    public String getNormValue() {
                        return normValue;
                    }

                    public void setNormValue(String normValue) {
                        this.normValue = normValue;
                    }
                }
            }
        }


}
