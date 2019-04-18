package com.baseapp.common.app;

import com.baseapp.common.base.BaseBean;
import com.baseapp.common.bean.AuthApplyStatusBean;
import com.baseapp.common.bean.MyFullInfoBean;
import com.baseapp.common.bean.UpLoadBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @项目名称: PublicService
 * @类描述: 2018/4/17
 * @创建时间： 2018/4/17
 * @作者: Android-Dev05
 */
public interface PublicService {
    /**
     * Android-Dev05
     * 图片上传-OSS
     *
     * @return
     */
//    @Multipart
    //   @FormUrlEncoded
    @POST("mda/v1/oss/upload/multiFile")
//    @POST("v1/oss/upload/multiFile")
//    @POST("mda/v1/oss/upload/image")

    Observable<UpLoadBean> getImage(@Body RequestBody filedata);

    @POST("mda/v1/oss/upload/ciImage")
    Observable<UpLoadBean> getImageCertificate(@Body RequestBody filedata);
    /**
     * 获取登录用户的基础信息
     *
     * @author Android-Dev06
     */
    @POST("/usr/v1/u/getMyFullInfor")
    Observable<MyFullInfoBean> getMyFullInfor();


    /**
     * 个人中心 获取实名认证状态
     */
    @POST("usr/v1/usr/getMyAuthApplyStatus")
    Observable<BaseBean<AuthApplyStatusBean>> getAuthApplyStatus();
}
