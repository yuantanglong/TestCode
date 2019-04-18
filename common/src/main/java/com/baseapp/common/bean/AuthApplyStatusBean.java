package com.baseapp.common.bean;

/**
 * @author Android-Dev04
 * @date 2018/5/3
 * description:实名认证状态bean
 */

public class AuthApplyStatusBean {

    /**
     * personTime : 0
     * cardIdHide :
     * imgMsg :
     * cardId :
     * cardType :
     * cTime : 0
     * disableCashTransfer : 1
     * message : 未申请
     * truenameHide :
     * status : 201
     */

    private String cardId;
    private String cardType;
    private String disableCashTransfer;
    private String message;
    private String status;
    private String opinion;
    private String username;
    private int cTime;
    private String truenameHide;
    private int personTime;
    private String cardIdHide;
    private String imgMsg;
    private String validDate;
    private String validMsg;


    public String getUsername() {
        return username == null ? "" : username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPersonTime() {
        return personTime;
    }

    public void setPersonTime(int personTime) {
        this.personTime = personTime;
    }

    public String getCardIdHide() {
        return cardIdHide == null ? "" : cardIdHide;
    }

    public void setCardIdHide(String cardIdHide) {
        this.cardIdHide = cardIdHide;
    }

    public String getImgMsg() {
        return imgMsg == null ? "" : imgMsg;
    }

    public void setImgMsg(String imgMsg) {
        this.imgMsg = imgMsg;
    }

    public String getCardId() {
        return cardId == null ? "" : cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardType() {
        return cardType == null ? "" : cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getcTime() {
        return cTime;
    }

    public void setcTime(int cTime) {
        this.cTime = cTime;
    }

    public String getDisableCashTransfer() {
        return disableCashTransfer == null ? "" : disableCashTransfer;
    }

    public void setDisableCashTransfer(String disableCashTransfer) {
        this.disableCashTransfer = disableCashTransfer;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTruenameHide() {
        return truenameHide == null ? "" : truenameHide;
    }

    public void setTruenameHide(String truenameHide) {
        this.truenameHide = truenameHide;
    }

    public String getStatus() {
        return status == null ? "" : status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidDate() {
        return validDate == null ? "" : validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getValidMsg() {
        return validMsg == null ? "" : validMsg;
    }

    public void setValidMsg(String validMsg) {
        this.validMsg = validMsg;
    }

    public String getOpinion() {
        return opinion == null ? "" : opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
