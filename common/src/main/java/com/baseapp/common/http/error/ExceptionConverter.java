package com.baseapp.common.http.error;

import android.net.ParseException;

import com.baseapp.common.http.error.ApiException;
import com.baseapp.common.http.error.ErrorCode;
import com.baseapp.common.http.error.ErrorType;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

/**
 * Created by Administrator on 2018/1/26 0026.
 * @Desc 异常转换器，
 */

public class ExceptionConverter {

    /**
     * 将非{@link ApiException}转换为该种异常
     * @param throwable
     * @return ApiException
     */
    public static ApiException convertException(Throwable throwable){
        ApiException apiException;
        String errorMessage="";
        ErrorType errorType=null;
        String errorCode;
        if (throwable instanceof ApiException){
            apiException = (ApiException) throwable;
        } else if (throwable instanceof HttpException){
            HttpException httpException = (HttpException) throwable;
            switch (httpException.code()) {
                default:
                    errorMessage="未知网络错误";
                    errorType=ErrorType.ERROR_UNKNOWN_HTTP;
                    errorCode= ErrorCode.CODE_UNKNOWN;
                    break;
            }
            apiException = new ApiException(errorCode,errorType,errorMessage,throwable);

        }else if (throwable instanceof JsonSyntaxException ||
                throwable instanceof JsonParseException
                ||throwable instanceof JSONException
                ||throwable instanceof ParseException){
            errorMessage="数据解析错误";
            errorType=ErrorType.ERROR_PARSE;
            errorCode= ErrorCode.CODE_PARSE;
            apiException = new ApiException(errorCode,errorType,errorMessage,throwable);
        }else if (throwable instanceof ConnectException){
            errorMessage="当前无网络，请检查网络";
            errorType=ErrorType.ERROR_NETWORK;
            errorCode= ErrorCode.CODE_NETWORK;
            apiException = new ApiException(errorCode,errorType,errorMessage,throwable);

        }else if (throwable instanceof UnknownHostException){
            errorMessage="似乎已断开与互联网的连接";
            errorType=ErrorType.ERROR_NETWORK;
            errorCode= ErrorCode.CODE_NETWORK;

            apiException = new ApiException(errorCode,errorType,errorMessage,throwable);

        }else if (throwable instanceof SocketTimeoutException){
            errorMessage="网络请求超时";
            errorType=ErrorType.ERROR_NETWORK;
            errorCode= ErrorCode.CODE_NETWORK;
            apiException = new ApiException(errorCode,errorType,errorMessage,throwable);
        }else {
            errorMessage="未知错误";
            errorType=ErrorType.ERROR_UNKNOWN;
            errorCode= ErrorCode.CODE_UNKNOWN;
            apiException = new ApiException(errorCode,errorType,errorMessage,throwable);

        }
        return apiException;
    }
}
