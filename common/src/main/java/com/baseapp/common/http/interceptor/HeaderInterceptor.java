package com.baseapp.common.http.interceptor;

import com.baseapp.common.BuildConfig;
import com.baseapp.common.base.BaseApplication;
import com.baseapp.common.base.config.BaseConfig;
import com.baseapp.common.utils.EncryptSPUtils;
import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.SPUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator
 * @date 2018/3/17
 */

public class HeaderInterceptor implements Interceptor {

    private int mHeaderType;
    private String token= "";
    private String client_version= "";
    private String os="android";
    private String lang="CN";
    public HeaderInterceptor(int headerType) {
        this.mHeaderType = mHeaderType;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(initBuilder(chain.request().newBuilder()).build());
    }

    private Request.Builder initBuilder(Request.Builder builder) {

        builder.addHeader("Content-Type", "application/json");
        builder.addHeader("token", SPUtils.getInstance().getString(Global.TOKEN));
        builder.addHeader("client_version", AppUtils.getAppVersionName());
        builder.addHeader("os", os);
        builder.addHeader("lang", lang);
        return builder;
    }

    /**
     * 获取Http请求header字符串
     *
     * @param base64 是否使用base64编码
     * @return
     */
    private String getAuthorizationString(boolean base64) {
        String mHeaderString = "";
        JSONObject mJsonObject = new JSONObject();
        try {
            mJsonObject.put("token", EncryptSPUtils.getSharedStringData(BaseApplication.getAppContext(),BaseConfig.BaseSPKey.TOKEN));

            mJsonObject.put("userNo", SPUtils.getInstance().getString(BaseConfig.BaseSPKey.USER_NO));
            mJsonObject.put("appVersion", "");
            if (base64) {
                String mRawString = mJsonObject.toString();
                mHeaderString = EncodeUtils.base64Encode2String(mRawString.getBytes());
            } else {
                mHeaderString = mJsonObject.toString();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mHeaderString;
    }
}
