package com.hhj.merchant.bean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: SellerMessageBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/18 17:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/18 17:08
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SellerMessageBean {
    /**
     * result : [{"id":10,"title":"全部商户","content":"全部商户","status":1,"isDel":null,"messageType":2,"recipientType":2,"sendMode":6,"createTime":"2018-11-07 13:47:43","createUserId":null,"updateTime":null,"updateUserId":null,"cityIds":null,"mobilesOrCodes":null,"recipient":null,"memberIds":null}]
     * pager : {"pageIndex":1,"pageSize":20,"rowsCount":1,"start":0}
     */
    /**
     * id : 10
     * title : 全部商户
     * content : 全部商户
     * status : 1
     * isDel : null
     * messageType : 2
     * recipientType : 2
     * sendMode : 6
     * createTime : 2018-11-07 13:47:43
     * createUserId : null
     * updateTime : null
     * updateUserId : null
     * cityIds : null
     * mobilesOrCodes : null
     * recipient : null
     * memberIds : null
     */

    private String id;
    private String title;
    private String content;
    private String status;
    private String isDel;
    private String messageType;
    private String recipientType;
    private String sendMode;
    private String createTime;
    private String createUserId;
    private String updateTime;
    private String updateUserId;
    private String cityIds;
    private String mobilesOrCodes;
    private String recipient;
    private String memberIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public String getSendMode() {
        return sendMode;
    }

    public void setSendMode(String sendMode) {
        this.sendMode = sendMode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getCityIds() {
        return cityIds;
    }

    public void setCityIds(String cityIds) {
        this.cityIds = cityIds;
    }

    public String getMobilesOrCodes() {
        return mobilesOrCodes;
    }

    public void setMobilesOrCodes(String mobilesOrCodes) {
        this.mobilesOrCodes = mobilesOrCodes;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getMemberIds() {
        return memberIds;
    }

    public void setMemberIds(String memberIds) {
        this.memberIds = memberIds;
    }
}
