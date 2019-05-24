package com.baseapp.common.http.interceptor;


import android.content.Context;
import android.support.annotation.NonNull;

import com.baseapp.common.view.Global;
import com.blankj.utilcode.util.AppUtils;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 封装公共参数（Key和密码）
 * <p>
 *
 * @author Administrator
 *         封装公共参数  12/29 只添加了sysfrom 字段； 有其他字段需封装再修改
 *         <p>
 */
public class ParamsInterceptor implements Interceptor {

    private static final String TAG = "request params";
    private Context context;
    private String token= com.blankj.utilcode.util.SPUtils.getInstance().getString(Global.TOKEN);
    private String client_version=AppUtils.getAppVersionName();
    private String os="android";
    private String lang="CN";

    @Inject
    public ParamsInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request orgRequest = chain.request();
        RequestBody body = orgRequest.body();
        //收集请求参数，方便调试
        StringBuilder paramsBuilder = new StringBuilder();

        if (body != null) {
            RequestBody newBody;
            if (body instanceof FormBody) {
                newBody = addParamsToFormBody((FormBody) body, paramsBuilder);
            } else if (body instanceof MultipartBody) {
                newBody = addParamsToMultipartBody((MultipartBody) body, paramsBuilder);
            } else {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                newBody = new FormBody.Builder()
                        .add("Content-Type", "application/json")
                        .add("token", token)
                        .add("client-version", client_version)
                        .add("os", os)
                        .add("lang", lang)
                        .build();
                Request.Builder requestBuilder = original.newBuilder()
                        .method(original.method(), newBody)
                        .url(originalHttpUrl);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }


            //打印参数
            Request newRequest = orgRequest.newBuilder()
                    .url(orgRequest.url())
                    .method(orgRequest.method(), newBody)
                    .build();

            return chain.proceed(newRequest);

        }

        return chain.proceed(orgRequest);
    }

    /**
     * 为MultipartBody类型请求体添加参数
     * <p>
     *
     * @param body          请求主体
     * @param paramsBuilder 参数builder
     * @return builder.build();
     */
    private MultipartBody addParamsToMultipartBody(MultipartBody body, StringBuilder paramsBuilder) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("token", token);
        builder.addFormDataPart("client-version", client_version);
        builder.addFormDataPart("os", os);
        builder.addFormDataPart("lang", lang);
        paramsBuilder.append("token=").append(token);
        paramsBuilder.append("client-version=").append(client_version);
        paramsBuilder.append("os=").append(os);
        paramsBuilder.append("lang=").append(lang);
        //添加原请求体
        for (int i = 0; i < body.size(); i++) {
            builder.addPart(body.part(i));
        }

        return builder.build();
    }


    /**
     * 为FormBody类型请求体添加参数
     * <p>
     *
     * @param body          请求主体
     * @param paramsBuilder 参数builder
     * @return builder.build();
     */

    private FormBody addParamsToFormBody(FormBody body, StringBuilder paramsBuilder) {
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("token", token);
        builder.add("client-version", client_version);
        builder.add("os", os);
        builder.add("lang", lang);
        paramsBuilder.append("token=").append(token);
        paramsBuilder.append("client-version=").append(client_version);
        paramsBuilder.append("os=").append(os);
        paramsBuilder.append("lang=").append(lang);
        //添加原请求体
        for (int i = 0; i < body.size(); i++) {
            if (!"userNo".equals(body.encodedName(i))) {
                builder.addEncoded(body.encodedName(i), body.encodedValue(i));
                paramsBuilder.append("&");
                paramsBuilder.append(body.name(i));
                paramsBuilder.append("=");
                paramsBuilder.append(body.value(i));
            }
        }
        return builder.build();
    }
}

