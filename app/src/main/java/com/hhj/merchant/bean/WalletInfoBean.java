package com.hhj.merchant.bean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: WalletInfoBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 13:45
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 13:45
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class WalletInfoBean {
    /**
     * result : {"totalGolds":"5476.51","principalGolds":2187.7,"freightGolds":2150,"dividendGolds":1138.81,"todayGolds":"0","yesterdayGolds":"69.00"}
     * pager : null
     */
    /**
     * totalGolds : 5476.51
     * principalGolds : 2187.7
     * freightGolds : 2150.0
     * dividendGolds : 1138.81
     * todayGolds : 0
     * yesterdayGolds : 69.00
     */

    private String totalGolds;
    private String principalGolds;
    private String freightGolds;
    private String dividendGolds;
    private String todayGolds;
    private String yesterdayGolds;

    public String getTotalGolds() {
        return totalGolds;
    }

    public void setTotalGolds(String totalGolds) {
        this.totalGolds = totalGolds;
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

    public String getTodayGolds() {
        return todayGolds;
    }

    public void setTodayGolds(String todayGolds) {
        this.todayGolds = todayGolds;
    }

    public String getYesterdayGolds() {
        return yesterdayGolds;
    }

    public void setYesterdayGolds(String yesterdayGolds) {
        this.yesterdayGolds = yesterdayGolds;
    }
}
