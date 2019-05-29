package com.baseapp.common.http.config;

/**
 * Created by Administrator on 2018/3/26 0026.
 *
 * @Desc: Api的配置类
 */

public class ApiConfig {
    /**
     * 服务器域名
     */
    private String mHostServer;

    public String getmHostImgBase() {
        return mHostImgBase;
    }

    public void setmHostImgBase(String mHostImgBase) {
        this.mHostImgBase = mHostImgBase;
    }

    private String mHostImgBase;

    public String getVip_Agreement_Url() {
        return vip_Agreement_Url;
    }

    public void setVip_Agreement_Url(String vip_Agreement_Url) {
        this.vip_Agreement_Url = vip_Agreement_Url;
    }

    public String getHhj_Agreement_Url() {
        return Hhj_Agreement_Url;
    }

    public void setHhj_Agreement_Url(String hhj_Agreement_Url) {
        Hhj_Agreement_Url = hhj_Agreement_Url;
    }

    private String vip_Agreement_Url;
    private String Hhj_Agreement_Url;
    /**
     * 读超时
     */
    private int mReadTimeOut;
    /**
     * 连接超时
     */
    private int mConnectTimeOut;

    public String getHostServer() {
        return mHostServer;
    }

    public void setHostServer(String hostServer) {
        this.mHostServer = hostServer;
    }



    public int getReadTimeOut() {
        return mReadTimeOut;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.mReadTimeOut = readTimeOut;
    }

    public int getConnectTimeOut() {
        return mConnectTimeOut;
    }

    public void setConnectTimeOut(int writeTimeOut) {
        this.mConnectTimeOut = writeTimeOut;
    }



    @Override
    public String toString() {
        return mHostServer + "///" + mReadTimeOut + "///" + mConnectTimeOut;
    }
}
