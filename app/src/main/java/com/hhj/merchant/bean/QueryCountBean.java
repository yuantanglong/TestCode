package com.hhj.merchant.bean;

import com.baseapp.common.base.BaseBean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: QueryCountBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/13 13:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/13 13:52
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class QueryCountBean extends BaseBean {
    /**
     * result : [{"date":"2019-05-13 00:00:00","dateStr":"今日","totalCount":6,"pendingCount":5,"deliverGoodStateCount":1,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null},{"date":"2019-05-14 00:00:00","dateStr":"明日","totalCount":0,"pendingCount":0,"deliverGoodStateCount":0,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null},{"date":"2019-05-15 00:00:00","dateStr":"15日","totalCount":0,"pendingCount":0,"deliverGoodStateCount":0,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null},{"date":"2019-05-16 00:00:00","dateStr":"16日","totalCount":0,"pendingCount":0,"deliverGoodStateCount":0,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null},{"date":"2019-05-17 00:00:00","dateStr":"17日","totalCount":0,"pendingCount":0,"deliverGoodStateCount":0,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null},{"date":"2019-05-18 00:00:00","dateStr":"18日","totalCount":0,"pendingCount":0,"deliverGoodStateCount":0,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null},{"date":"2019-05-19 00:00:00","dateStr":"19日","totalCount":0,"pendingCount":0,"deliverGoodStateCount":0,"takeGoodStateCount":0,"dispatchingStateCount":0,"doneStateCount":null}]
     * pager : null
     */
    /**
     * date : 2019-05-13 00:00:00
     * dateStr : 今日
     * totalCount : 6
     * pendingCount : 5
     * deliverGoodStateCount : 1
     * takeGoodStateCount : 0
     * dispatchingStateCount : 0
     * doneStateCount : null
     */

    private String date;
    private String dateStr;
    private String totalCount;
    private String pendingCount;
    private String deliverGoodStateCount;
    private String takeGoodStateCount;
    private String dispatchingStateCount;
    private String doneStateCount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    public String getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(String pendingCount) {
        this.pendingCount = pendingCount;
    }

    public String getDeliverGoodStateCount() {
        return deliverGoodStateCount;
    }

    public void setDeliverGoodStateCount(String deliverGoodStateCount) {
        this.deliverGoodStateCount = deliverGoodStateCount;
    }

    public String getTakeGoodStateCount() {
        return takeGoodStateCount;
    }

    public void setTakeGoodStateCount(String takeGoodStateCount) {
        this.takeGoodStateCount = takeGoodStateCount;
    }

    public String getDispatchingStateCount() {
        return dispatchingStateCount;
    }

    public void setDispatchingStateCount(String dispatchingStateCount) {
        this.dispatchingStateCount = dispatchingStateCount;
    }

    public String getDoneStateCount() {
        return doneStateCount;
    }

    public void setDoneStateCount(String doneStateCount) {
        this.doneStateCount = doneStateCount;
    }
}
