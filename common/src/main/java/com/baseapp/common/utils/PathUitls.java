package com.baseapp.common.utils;

import android.app.Application;
import android.os.Environment;

import com.blankj.utilcode.util.ToastUtils;

import java.io.File;

/**
 * Created by Administrator on 2018/1/22 0022.
 * @Desc: 管理App用到的所有文件路径的工具类，以后文件路径方法都放在该工具类中
 */

public class PathUitls {

    private static Application mApplication;

    public static void init(Application application) {
        mApplication = application;
    }

    /**
     * 如果手机有内存卡，则返回内存卡的根路径
     * 如果手机没有内存卡，则返回App的cache目录
     *
     * @return
     */
    public static String getRootPath() {
        String mRootPath;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            mRootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } else {
            mRootPath = mApplication.getExternalCacheDir().getPath();
        }
        return mRootPath;
    }

    /**
     * 获取App的图片存储路径
     * @warning 返回路径可能为null
     * @return 绝对路径
     */
    public static String getImageCacheDir() {
        StringBuilder sb = new StringBuilder();
        sb.append(getRootPath()).append("/哈哈镜商户/image/");
        File mImageFile=new File(sb.toString());
        if (!mImageFile.exists() || mImageFile.isFile()){
            boolean isSuccess=mImageFile.mkdirs();
            if (!isSuccess){
                ToastUtils.showShort("获取压缩图片存放路径失败！");
                return null;
            }else {
                return mImageFile.getAbsolutePath();
            }
        }else {
            return sb.toString();
        }
    }

    /**
     * 获取App安装包的存放路径
     * @warning 返回路径可能为null
     * @return
     */
    public static String getApkStorageDir(){
        StringBuilder sb = new StringBuilder();
        sb.append(getRootPath()).append("/哈哈镜商户/apk/");
        File mApkFile = new File(sb.toString());
        if (!mApkFile.exists() || mApkFile.isFile()){
            boolean isSuccess = mApkFile.mkdirs();
            if (!isSuccess){
                ToastUtils.showShort("获取安装包存放路径失败！");
                return null;
            }else {
                return mApkFile.getAbsolutePath();
            }
        }else {
            return sb.toString();
        }
    }

    /**
     * 获取缩略图存放路径
     * @warning 返回路径可能为null
     * @return
     */
    public static String getThumbnailDir(){
        StringBuilder sb = new StringBuilder();
        sb.append(getRootPath()).append("/哈哈镜商户/thumbnail/");

        File mThumbnailFile = new File(sb.toString());
        if (!mThumbnailFile.exists() || mThumbnailFile.isFile()){
            boolean isSuccess = mThumbnailFile.mkdirs();
            if (!isSuccess){
                ToastUtils.showShort("获取图片存放路径失败！");
                return null;
            }else {
                return mThumbnailFile.getAbsolutePath();
            }
        }else {
            return sb.toString();
        }

    }

    /**
     * 获取缩略图文件的路径
     * @warning 返回路径可能为null
     * @param thumbnailRemoteUrl
     * @return
     */
    public static String getThumbnailImagePath(String thumbnailRemoteUrl){
        String thumbImageName= thumbnailRemoteUrl.substring(thumbnailRemoteUrl.lastIndexOf("/") + 1, thumbnailRemoteUrl.length());
        return getThumbnailDir()+"thumb"+thumbImageName;
    }
}
