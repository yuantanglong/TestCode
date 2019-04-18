package com.baseapp.common.bean;

import com.baseapp.common.base.BaseBean;
import com.google.gson.annotations.SerializedName;

/**
 * 获取登录用户的基础信息
 * @author Android-Dev06
 */
public class MyFullInfoBean extends BaseBean<MyFullInfoBean.DataBean>{
    public static class DataBean {
        /**
         * issetUprank : 1
         * isImRegist : Y
         * city : 朝阳区
         * belongOperate : hns1711379
         * county :
         * cardNo : 2****************9
         * loginNum : 397
         * tjuid : 9
         * userCode : 100000000
         * operateUsername :
         * tjruserid : 180906
         * province : 北京市
         * shareCodeUrl : https://yuehuapic.oss-cn-shanghai.aliyuncs.com/usercode/100000000/shareCode.png
         * receivablesQrCodeUrl : https://yuehuapic.oss-cn-shanghai.aliyuncs.com/usercode/100000000/receivablesQrCode.png
         * truename : 袁
         * address :
         * imStatus : 1
         * town :
         * level : 5
         * nickName : 此号已用 请勿更换手机号
         * haveNumberPassword : 1
         * sex : 1
         * changeOperate : 1
         * mobile : 188****3452
         * cardType : 0
         * avatar : https://yuehuapic.oss-cn-shanghai.aliyuncs.com/picture/20180104/887986a6a4984e65be4744287250559c.jpg
         * userId : 100000000
         * mobileApprove : 1
         * lastLoginTime : 1526262072
         * uId : 1390815
         * havePassword : 1
         * isIdentityApprove : 1
         * createTime : 1514967665
         * isOperateCenter : 0
         * qrCodeUrl : https://yuehuapic.oss-cn-shanghai.aliyuncs.com/usercode/100000000/qrCode.png
         * imToken : df7f6c32620740339784242390e8013a
         */

        private int issetUprank;
        private String isImRegist;
        private String city;
        private String belongOperate;
        private String county;
        private String cardNo;
        private int loginNum;
        private int tjuid;
        private String userCode;
        private String operateUsername;
        private String tjruserid;
        private String province;
        private String shareCodeUrl;
        private String receivablesQrCodeUrl;
        private String truename;
        private String address;
        private String imStatus;
        private String town;
        private String level;
        private String nickName;
        private String haveNumberPassword;
        private int sex;
        private int changeOperate;
        private String mobile;
        private String cardType;
        private String avatar;
        private String userId;
        private int mobileApprove;
        private String lastLoginTime;
        private String uId;
        private int havePassword;
        private String isIdentityApprove;
        private String createTime;
        private int isOperateCenter;
        private String qrCodeUrl;
        private String imToken;

        public int getIssetUprank() {
            return issetUprank;
        }

        public void setIssetUprank(int issetUprank) {
            this.issetUprank = issetUprank;
        }

        public String getIsImRegist() {
            return isImRegist;
        }

        public void setIsImRegist(String isImRegist) {
            this.isImRegist = isImRegist;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getBelongOperate() {
            return belongOperate;
        }

        public void setBelongOperate(String belongOperate) {
            this.belongOperate = belongOperate;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public int getLoginNum() {
            return loginNum;
        }

        public void setLoginNum(int loginNum) {
            this.loginNum = loginNum;
        }

        public int getTjuid() {
            return tjuid;
        }

        public void setTjuid(int tjuid) {
            this.tjuid = tjuid;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getOperateUsername() {
            return operateUsername;
        }

        public void setOperateUsername(String operateUsername) {
            this.operateUsername = operateUsername;
        }

        public String getTjruserid() {
            return tjruserid;
        }

        public void setTjruserid(String tjruserid) {
            this.tjruserid = tjruserid;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getShareCodeUrl() {
            return shareCodeUrl;
        }

        public void setShareCodeUrl(String shareCodeUrl) {
            this.shareCodeUrl = shareCodeUrl;
        }

        public String getReceivablesQrCodeUrl() {
            return receivablesQrCodeUrl;
        }

        public void setReceivablesQrCodeUrl(String receivablesQrCodeUrl) {
            this.receivablesQrCodeUrl = receivablesQrCodeUrl;
        }

        public String getTruename() {
            return truename;
        }

        public void setTruename(String truename) {
            this.truename = truename;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getImStatus() {
            return imStatus;
        }

        public void setImStatus(String imStatus) {
            this.imStatus = imStatus;
        }

        public String getTown() {
            return town;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHaveNumberPassword() {
            return haveNumberPassword;
        }

        public void setHaveNumberPassword(String haveNumberPassword) {
            this.haveNumberPassword = haveNumberPassword;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getChangeOperate() {
            return changeOperate;
        }

        public void setChangeOperate(int changeOperate) {
            this.changeOperate = changeOperate;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getMobileApprove() {
            return mobileApprove;
        }

        public void setMobileApprove(int mobileApprove) {
            this.mobileApprove = mobileApprove;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getUId() {
            return uId;
        }

        public void setUId(String uId) {
            this.uId = uId;
        }

        public int getHavePassword() {
            return havePassword;
        }

        public void setHavePassword(int havePassword) {
            this.havePassword = havePassword;
        }

        public String getIsIdentityApprove() {
            return isIdentityApprove;
        }

        public void setIsIdentityApprove(String isIdentityApprove) {
            this.isIdentityApprove = isIdentityApprove;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getIsOperateCenter() {
            return isOperateCenter;
        }

        public void setIsOperateCenter(int isOperateCenter) {
            this.isOperateCenter = isOperateCenter;
        }

        public String getQrCodeUrl() {
            return qrCodeUrl;
        }

        public void setQrCodeUrl(String qrCodeUrl) {
            this.qrCodeUrl = qrCodeUrl;
        }

        public String getImToken() {
            return imToken;
        }

        public void setImToken(String imToken) {
            this.imToken = imToken;
        }
    }
}
