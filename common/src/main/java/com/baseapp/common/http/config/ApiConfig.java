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
    /**
     * 商城服务器域名
     */
    private String mShopHostServer;
    /**
     * 商城服务器支付域名
     */
    private String mShopH5HostServer;
    /**
     * 资产钱包2.0服务器支付域名
     */
    private String mAssetsWallet2HostServer;

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

    public String getShopHostServer() {
        return mShopHostServer;
    }

    public void setShopHostServer(String shopHostServer) {
        this.mShopHostServer = shopHostServer;
    }

    public String getShopH5HostServer() {
        return mShopH5HostServer;
    }

    public void setShopH5HostServerr(String shopH5HostServerr) {
        this.mShopH5HostServer = shopH5HostServerr;
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

    public String getmAssetsWallet2HostServer() {
        return mAssetsWallet2HostServer;
    }

    public void setmAssetsWallet2HostServer(String mAssetsWallet2HostServer) {
        this.mAssetsWallet2HostServer = mAssetsWallet2HostServer;
    }

    @Override
    public String toString() {
        return mHostServer + "///" + mReadTimeOut + "///" + mConnectTimeOut;
    }
}
