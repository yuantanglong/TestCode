package com.baseapp.common.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/26 0026.
 * @Desc 接口返回数据JavaBean的基类，所有JavaBean务必继承该基类，方便封装错误统一处理
 */

public class BaseBean<T> implements Serializable{

    //接口返回的业务码
    private String code;
    //接口返回信息
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    private boolean success;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    //接口返回数据
    private T result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
