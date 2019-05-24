package com.hhj.merchant.bean;

/**
 * @ProjectName: TestCode
 * @Package: com.hhj.merchant.bean
 * @ClassName: SysNewVersionBean
 * @Description: java类作用描述
 * @Author: yuantanglong
 * @CreateDate: 2019/5/19 18:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2019/5/19 18:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class SysNewVersionBean  {
    /**
     * result : {"id":3,"source":3,"version":"513","downloadUrl":"http://img.hahajing.com/userfiles/app/hhj_store_5.1.3.apk","updateContent":"1、BUG修复；\n2、系统优化；","isForce":1,"isTip":1,"createTime":"2018-10-27 19:57:58","number":513}
     * pager : null
     */
    /**
     * id : 3
     * source : 3
     * version : 513
     * downloadUrl : http://img.hahajing.com/userfiles/app/hhj_store_5.1.3.apk
     * updateContent : 1、BUG修复；
     * 2、系统优化；
     * isForce : 1
     * isTip : 1
     * createTime : 2018-10-27 19:57:58
     * number : 513
     */

    private String id;
    private String source;
    private String version;
    private String downloadUrl;
    private String updateContent;
    private String isForce;
    private String isTip;
    private String createTime;
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getIsForce() {
        return isForce;
    }

    public void setIsForce(String isForce) {
        this.isForce = isForce;
    }

    public String getIsTip() {
        return isTip;
    }

    public void setIsTip(String isTip) {
        this.isTip = isTip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
