package com.hhj.merchant.bean;

import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: WalletFlowBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 13:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 13:20
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WalletFlowBean{
    /**
     * result : {"list":[{"id":2304,"sellerId":5055,"orderType":1,"ordersId":20350,"ordersSn":"519051112254784649071","tradeType":1,"memberId":588072,"memberPhone":"18700002222","content":"商户订单分成","createTime":"2019-05-17 05:00:00","dateType":null,"startDate":null,"endDate":null,"principalGoldsChange":18,"freightGoldsChange":7.5,"dividendGoldsChange":6,"beforeTradeGolds":5407.51,"afterTradeGolds":5439.01,"reflectTradeGolds":3288.81,"pageIndex":null,"pageSize":null,"coinDesc":"产生金币:31.50 (本金:18.00 分成:6.00运费:7.50)"},{"id":2303,"sellerId":5055,"orderType":1,"ordersId":20342,"ordersSn":"519051111090553728951","tradeType":1,"memberId":588071,"memberPhone":"18500003333","content":"商户订单分成","createTime":"2019-05-17 05:00:00","dateType":null,"startDate":null,"endDate":null,"principalGoldsChange":22.5,"freightGoldsChange":7.5,"dividendGoldsChange":7.5,"beforeTradeGolds":5407.51,"afterTradeGolds":5445.01,"reflectTradeGolds":3275.31,"pageIndex":null,"pageSize":null,"coinDesc":"产生金币:37.50 (本金:22.50 分成:7.50运费:7.50)"}],"count":2,"resultStatus":1,"rowsCount":2}
     * pager : {"pageIndex":1,"pageSize":10,"rowsCount":2,"start":0}
     */
    /**
     * list : [{"id":2304,"sellerId":5055,"orderType":1,"ordersId":20350,"ordersSn":"519051112254784649071","tradeType":1,"memberId":588072,"memberPhone":"18700002222","content":"商户订单分成","createTime":"2019-05-17 05:00:00","dateType":null,"startDate":null,"endDate":null,"principalGoldsChange":18,"freightGoldsChange":7.5,"dividendGoldsChange":6,"beforeTradeGolds":5407.51,"afterTradeGolds":5439.01,"reflectTradeGolds":3288.81,"pageIndex":null,"pageSize":null,"coinDesc":"产生金币:31.50 (本金:18.00 分成:6.00运费:7.50)"},{"id":2303,"sellerId":5055,"orderType":1,"ordersId":20342,"ordersSn":"519051111090553728951","tradeType":1,"memberId":588071,"memberPhone":"18500003333","content":"商户订单分成","createTime":"2019-05-17 05:00:00","dateType":null,"startDate":null,"endDate":null,"principalGoldsChange":22.5,"freightGoldsChange":7.5,"dividendGoldsChange":7.5,"beforeTradeGolds":5407.51,"afterTradeGolds":5445.01,"reflectTradeGolds":3275.31,"pageIndex":null,"pageSize":null,"coinDesc":"产生金币:37.50 (本金:22.50 分成:7.50运费:7.50)"}]
     * count : 2
     * resultStatus : 1
     * rowsCount : 2
     */

    private String count;
    private String resultStatus;
    private String rowsCount;
    private List<ListBean> list;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getRowsCount() {
        return rowsCount;
    }

    public void setRowsCount(String rowsCount) {
        this.rowsCount = rowsCount;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 2304
         * sellerId : 5055
         * orderType : 1
         * ordersId : 20350
         * ordersSn : 519051112254784649071
         * tradeType : 1
         * memberId : 588072
         * memberPhone : 18700002222
         * content : 商户订单分成
         * createTime : 2019-05-17 05:00:00
         * dateType : null
         * startDate : null
         * endDate : null
         * principalGoldsChange : 18.0
         * freightGoldsChange : 7.5
         * dividendGoldsChange : 6.0
         * beforeTradeGolds : 5407.51
         * afterTradeGolds : 5439.01
         * reflectTradeGolds : 3288.81
         * pageIndex : null
         * pageSize : null
         * coinDesc : 产生金币:31.50 (本金:18.00 分成:6.00运费:7.50)
         */

        private String id;
        private String sellerId;
        private String orderType;
        private String ordersId;
        private String ordersSn;
        private String tradeType;
        private String memberId;
        private String memberPhone;
        private String content;
        private String createTime;
        private String dateType;
        private String startDate;
        private String endDate;
        private String principalGoldsChange;
        private String freightGoldsChange;
        private String dividendGoldsChange;
        private String beforeTradeGolds;
        private String afterTradeGolds;
        private String reflectTradeGolds;
        private String pageIndex;
        private String pageSize;
        private String coinDesc;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSellerId() {
            return sellerId;
        }

        public void setSellerId(String sellerId) {
            this.sellerId = sellerId;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
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

        public String getTradeType() {
            return tradeType;
        }

        public void setTradeType(String tradeType) {
            this.tradeType = tradeType;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getMemberPhone() {
            return memberPhone;
        }

        public void setMemberPhone(String memberPhone) {
            this.memberPhone = memberPhone;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDateType() {
            return dateType;
        }

        public void setDateType(String dateType) {
            this.dateType = dateType;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getPrincipalGoldsChange() {
            return principalGoldsChange;
        }

        public void setPrincipalGoldsChange(String principalGoldsChange) {
            this.principalGoldsChange = principalGoldsChange;
        }

        public String getFreightGoldsChange() {
            return freightGoldsChange;
        }

        public void setFreightGoldsChange(String freightGoldsChange) {
            this.freightGoldsChange = freightGoldsChange;
        }

        public String getDividendGoldsChange() {
            return dividendGoldsChange;
        }

        public void setDividendGoldsChange(String dividendGoldsChange) {
            this.dividendGoldsChange = dividendGoldsChange;
        }

        public String getBeforeTradeGolds() {
            return beforeTradeGolds;
        }

        public void setBeforeTradeGolds(String beforeTradeGolds) {
            this.beforeTradeGolds = beforeTradeGolds;
        }

        public String getAfterTradeGolds() {
            return afterTradeGolds;
        }

        public void setAfterTradeGolds(String afterTradeGolds) {
            this.afterTradeGolds = afterTradeGolds;
        }

        public String getReflectTradeGolds() {
            return reflectTradeGolds;
        }

        public void setReflectTradeGolds(String reflectTradeGolds) {
            this.reflectTradeGolds = reflectTradeGolds;
        }

        public String getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(String pageIndex) {
            this.pageIndex = pageIndex;
        }

        public String getPageSize() {
            return pageSize;
        }

        public void setPageSize(String pageSize) {
            this.pageSize = pageSize;
        }

        public String getCoinDesc() {
            return coinDesc;
        }

        public void setCoinDesc(String coinDesc) {
            this.coinDesc = coinDesc;
        }
    }
}
