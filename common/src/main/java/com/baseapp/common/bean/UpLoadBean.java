package com.baseapp.common.bean;

import com.baseapp.common.base.BaseBean;

import java.util.List;

/**
 * Created by Android-Dev05 on 2017/10/24.得到图片
 */

public class UpLoadBean  extends BaseBean<UpLoadBean.DataBean>{
    public static class DataBean {
        /**
         * url : null
         * thumbUrl : null
         * prefix : http://yuehuapicture.oss-cn-shanghai.aliyuncs.com/
         * urls : ["picture/20171106/024349759_IMG_20171105_191917.jpg"]
         */

        private String url;
        private String thumbUrl;
        private String prefix;
        private List<String> urls;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }
    }


}
