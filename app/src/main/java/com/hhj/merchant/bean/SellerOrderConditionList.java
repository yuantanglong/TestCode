package com.hhj.merchant.bean;

import java.io.Serializable;

public class SellerOrderConditionList implements Serializable {
    private String count;
    private String sellerProductGoodsId;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSellerProductGoodsId() {
        return sellerProductGoodsId;
    }

    public void setSellerProductGoodsId(String sellerProductGoodsId) {
        this.sellerProductGoodsId = sellerProductGoodsId;
    }
}
