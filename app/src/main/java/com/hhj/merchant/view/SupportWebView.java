package com.hhj.merchant.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baseapp.common.base.BaseApplication;
import com.baseapp.common.base.config.BaseConfig;
import com.baseapp.common.utils.EncryptSPUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/**
 * @company: Coolbit
 * created by {Android-Dev02} on 2018/4/30 17:39
 * @desc:
 */

public class SupportWebView extends BridgeWebView {
    private Context mContext;
    private final String mBridgeName = "CoolbitBridge";
    private WebAppInterface webAppInterface;


    public SupportWebView(Context context) {
        super(context);
        mContext = context;
        disableZoomController();
    }

    public SupportWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        disableZoomController();
    }

    public SupportWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        disableZoomController();
    }

    // 使得控制按钮不可用
    @SuppressLint("SetJavaScriptEnabled")
    private void disableZoomController() {
        // 如果不添加下边这句，可能会报：
        // [INFO:CONSOLE(2)]
        // "Uncaught TypeError: Cannot call method 'getItem' of null", source:
        // http://www.baidu.com/ (2)
        // 原因：http://wazai.net/2969/android-webview-error-uncaught-typeerror-cannot-call-method-getitem-of-null-at
        this.getSettings().setDomStorageEnabled(true); // 开启DOM storage API 功能

        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setDefaultTextEncodingName("utf-8");
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setSupportZoom(false);
        this.getSettings().setSaveFormData(true);
        this.getSettings().setAllowFileAccess(true);
        this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        this.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);// 设置缓存模式
        this.getSettings().setAppCacheEnabled(true);
        this.getSettings().setDatabaseEnabled(true); // 开启database storage API功能
        this.setHorizontalScrollBarEnabled(false);
        // 添加js交互接口类
//        this.addJavascriptInterface(webAppInterface, mBridgeName);
        final String userNoToken = "{" +
                "'userNo':'" + SPUtils.getInstance().getString(BaseConfig.BaseSPKey.USER_NO) + "'," +
                "'sysfrom':'android'," +
                "'token':'" + EncryptSPUtils.getSharedStringData(BaseApplication.getAppContext(), BaseConfig.BaseSPKey.TOKEN) +
                "'}";
        LogUtils.e(userNoToken);


        this.registerHandler("getStatus", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                ToastUtils.showShort(data);
            }
        });
        this.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }

    private WebBridgeCallback webBridgeCallback = null;

    public void setWebBridgeCallback(WebBridgeCallback webBridgeCallback) {
        this.webBridgeCallback = webBridgeCallback;
    }

    public interface WebBridgeCallback {
        void onDone();

        void onError(String message);
    }

    public class WebAppInterface {
        Context mContext;

        public WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void onDone() {
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    if (webBridgeCallback != null) {
                        webBridgeCallback.onDone();
                    }
                }
            });
        }

        @JavascriptInterface
        public void onError(final String message) {
            getHandler().post(new Runnable() {
                @Override
                public void run() {
                    if (webBridgeCallback != null) {
                        webBridgeCallback.onError(message);
                    }
                }
            });
        }
    }
}
