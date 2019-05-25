package com.hhj.merchant.bean;

public class SubmitOrderBean {


    /**
     * result : {"productAmount":null,"deductionCoins":null,"principalGolds":null,"freightGolds":null,"dividendGolds":null,"productGoodsCount":null,"payment":null,"productCateName":null,"productCateId":null,"sellerProductGoodsVos":null,"isSuccess":true}
     * success : true
     * message :
     * code :
     * pager : null
     */
    /**
     * productAmount : null
     * deductionCoins : null
     * principalGolds : null
     * freightGolds : null
     * dividendGolds : null
     * productGoodsCount : null
     * payment : null
     * productCateName : null
     * productCateId : null
     * sellerProductGoodsVos : null
     * isSuccess : true
     */

    private String productAmount;
    private String deductionCoins;
    private String principalGolds;
    private String freightGolds;
    private String dividendGolds;
    private String productGoodsCount;
    private String payment;
    private String productCateName;
    private String productCateId;
    private String sellerProductGoodsVos;
    private String isSuccess;

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getDeductionCoins() {
        return deductionCoins;
    }

    public void setDeductionCoins(String deductionCoins) {
        this.deductionCoins = deductionCoins;
    }

    public String getPrincipalGolds() {
        return principalGolds;
    }

    public void setPrincipalGolds(String principalGolds) {
        this.principalGolds = principalGolds;
    }

    public String getFreightGolds() {
        return freightGolds;
    }

    public void setFreightGolds(String freightGolds) {
        this.freightGolds = freightGolds;
    }

    public String getDividendGolds() {
        return dividendGolds;
    }

    public void setDividendGolds(String dividendGolds) {
        this.dividendGolds = dividendGolds;
    }

    public String getProductGoodsCount() {
        return productGoodsCount;
    }

    public void setProductGoodsCount(String productGoodsCount) {
        this.productGoodsCount = productGoodsCount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getProductCateName() {
        return productCateName;
    }

    public void setProductCateName(String productCateName) {
        this.productCateName = productCateName;
    }

    public String getProductCateId() {
        return productCateId;
    }

    public void setProductCateId(String productCateId) {
        this.productCateId = productCateId;
    }

    public String getSellerProductGoodsVos() {
        return sellerProductGoodsVos;
    }

    public void setSellerProductGoodsVos(String sellerProductGoodsVos) {
        this.sellerProductGoodsVos = sellerProductGoodsVos;
    }

    public String isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }
}
