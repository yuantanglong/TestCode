package com.hhj.merchant.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: GetListBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/16 19:13
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/16 19:13
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GetListBean  implements Serializable {
    /**
     * result : {"nativePeople":[{"id":53,"diliveryStaffId":53,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"fanxiaolu","name":"范晓露","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"18518572534","workStatus":2,"status":1,"createTime":"2018-12-09 16:37:11","updateTime":"2019-01-15 11:11:09","workOrderCount":31,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":172,"diliveryStaffId":172,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"18101271416","name":"王红杰","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"18101271416","workStatus":2,"status":1,"createTime":"2018-12-19 16:14:46","updateTime":"2018-12-19 16:14:46","workOrderCount":7,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":174,"diliveryStaffId":174,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"13361111602","name":"朱建委","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"13361111602","workStatus":2,"status":1,"createTime":"2018-12-19 16:15:24","updateTime":"2018-12-19 16:15:24","workOrderCount":3,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":175,"diliveryStaffId":175,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"15811183450","name":"古强","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"15811183450","workStatus":2,"status":1,"createTime":"2018-12-19 16:15:48","updateTime":"2018-12-19 16:15:48","workOrderCount":3,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":176,"diliveryStaffId":176,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"17701131002","name":"燕亚波","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"17701131002","workStatus":2,"status":1,"createTime":"2018-12-19 16:16:05","updateTime":"2018-12-19 16:16:05","workOrderCount":0,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":177,"diliveryStaffId":177,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"13439480681","name":"文栋杰","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"13439480681","workStatus":2,"status":1,"createTime":"2018-12-19 16:16:34","updateTime":"2018-12-19 16:16:34","workOrderCount":0,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":178,"diliveryStaffId":178,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"18510291191","name":"谭其万","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"18510291191","workStatus":2,"status":1,"createTime":"2018-12-19 16:16:51","updateTime":"2018-12-19 16:16:51","workOrderCount":0,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":179,"diliveryStaffId":179,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"18510463556","name":"靳仁夺","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"18510463556","workStatus":2,"status":1,"createTime":"2018-12-19 16:17:16","updateTime":"2018-12-19 16:17:16","workOrderCount":0,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":180,"diliveryStaffId":180,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"17600983537","name":"袁庆","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"17600983537","workStatus":2,"status":1,"createTime":"2018-12-19 16:17:34","updateTime":"2018-12-19 16:17:34","workOrderCount":1,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":181,"diliveryStaffId":181,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"13651001292","name":"王金奎","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"13651001292","workStatus":2,"status":1,"createTime":"2018-12-19 16:17:48","updateTime":"2018-12-19 16:17:48","workOrderCount":1,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":182,"diliveryStaffId":182,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"13993945310","name":"王兆宏","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"13993945310","workStatus":2,"status":1,"createTime":"2018-12-19 16:18:04","updateTime":"2018-12-19 16:18:04","workOrderCount":0,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":198,"diliveryStaffId":198,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"yangzhao","name":"yangzhao","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"13394559023","workStatus":2,"status":1,"createTime":"2019-01-22 16:48:29","updateTime":"2019-01-22 16:51:46","workOrderCount":7,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null},{"id":200,"diliveryStaffId":200,"sellerId":5055,"sellerName":"哈哈镜东直门总店","userName":"袁堂龙","name":"袁堂龙","passwd":"e10adc3949ba59abbe56e057f20f883e","avatar":null,"mobile":"18810653452","workStatus":2,"status":1,"createTime":"2019-05-16 18:48:42","updateTime":"2019-05-16 18:48:42","workOrderCount":0,"type":1,"verifyCode":null,"newPasswd":null,"requestType":null,"loginIP":null,"token":null}],"thirdList":[{"id":1,"name":"美团配送","company":"美团","status":1,"createTime":"2018-11-19 16:51:01","type":2}]}
     * pager : null
     */
    private List<NativePeopleBean> nativePeople;
    private List<ThirdListBean> thirdList;

    public List<NativePeopleBean> getNativePeople() {
        return nativePeople;
    }

    public void setNativePeople(List<NativePeopleBean> nativePeople) {
        this.nativePeople = nativePeople;
    }

    public List<ThirdListBean> getThirdList() {
        return thirdList;
    }

    public void setThirdList(List<ThirdListBean> thirdList) {
        this.thirdList = thirdList;
    }

    public static class NativePeopleBean implements Serializable{
        /**
         * id : 53
         * diliveryStaffId : 53
         * sellerId : 5055
         * sellerName : 哈哈镜东直门总店
         * userName : fanxiaolu
         * name : 范晓露
         * passwd : e10adc3949ba59abbe56e057f20f883e
         * avatar : null
         * mobile : 18518572534
         * workStatus : 2
         * status : 1
         * createTime : 2018-12-09 16:37:11
         * updateTime : 2019-01-15 11:11:09
         * workOrderCount : 31
         * type : 1
         * verifyCode : null
         * newPasswd : null
         * requestType : null
         * loginIP : null
         * token : null
         */

        private String id;
        private String diliveryStaffId;
        private String sellerId;
        private String sellerName;
        private String userName;
        private String name;
        private String passwd;
        private String avatar;
        private String mobile;
        private String workStatus;
        private String status;
        private String createTime;
        private String updateTime;
        private String workOrderCount;
        private String type;
        private String verifyCode;
        private String newPasswd;
        private String requestType;
        private String loginIP;
        private String token;

        public boolean isSetChecked() {
            return setChecked;
        }

        public void setSetChecked(boolean setChecked) {
            this.setChecked = setChecked;
        }

        private boolean setChecked;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDiliveryStaffId() {
            return diliveryStaffId;
        }

        public void setDiliveryStaffId(String diliveryStaffId) {
            this.diliveryStaffId = diliveryStaffId;
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

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWorkStatus() {
            return workStatus;
        }

        public void setWorkStatus(String workStatus) {
            this.workStatus = workStatus;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public String getWorkOrderCount() {
            return workOrderCount;
        }

        public void setWorkOrderCount(String workOrderCount) {
            this.workOrderCount = workOrderCount;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(String verifyCode) {
            this.verifyCode = verifyCode;
        }

        public String getNewPasswd() {
            return newPasswd;
        }

        public void setNewPasswd(String newPasswd) {
            this.newPasswd = newPasswd;
        }

        public String getRequestType() {
            return requestType;
        }

        public void setRequestType(String requestType) {
            this.requestType = requestType;
        }

        public String getLoginIP() {
            return loginIP;
        }

        public void setLoginIP(String loginIP) {
            this.loginIP = loginIP;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class ThirdListBean implements Serializable{
        /**
         * id : 1
         * name : 美团配送
         * company : 美团
         * status : 1
         * createTime : 2018-11-19 16:51:01
         * type : 2
         */

        private String id;
        private String name;
        private String company;
        private String status;
        private String createTime;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
