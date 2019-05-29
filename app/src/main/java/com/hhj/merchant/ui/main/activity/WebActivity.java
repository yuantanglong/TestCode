package com.hhj.merchant.ui.main.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.baseapp.common.base.callback.IToolbar;
import com.baseapp.common.base.ui.BaseActivity;
import com.baseapp.common.utility.ToolbarBackTitle;
import com.baseapp.common.utils.UIUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.hhj.merchant.R;
import com.hhj.merchant.view.SupportWebView;

import butterknife.BindView;

/**
 * @company: Coolbit
 * created by {Android-Dev02} on 2018/4/30 17:45
 * @desc:
 */

public class WebActivity extends BaseActivity {
    @BindView(R.id.activity_web_view)
    SupportWebView activityWebView;
    @BindView(R.id.activity_web_progress)
    ProgressBar mProgressBar;

    private ValueCallback<Uri> uploadMessage;
    private ValueCallback<Uri[]> uploadMessageAboveL;
    private final static int FILE_CHOOSER_RESULT_CODE = 10000;

    public final static String WEB_TITLE = "WEB_TITLE";
    public final static String WEB_URL = "WEB_URL";
    private ToolbarBackTitle toolbarBackTitle;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected boolean enableSwipeBack() {
        return true;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        if (!getIntent().hasExtra(WEB_URL) || !getIntent().hasExtra(WEB_TITLE)) {
            throw new IllegalArgumentException(UIUtils.getString(R.string.exception_tip_illegal_argument));
        }
        final String mURL = getIntent().getStringExtra(WEB_URL);
        String mTitle = getIntent().getStringExtra(WEB_TITLE);
        toolbarBackTitle.setTitleText(mTitle);
        activityWebView.postDelayed(new Runnable() {
            @Override
            public void run() {
                activityWebView.loadUrl(mURL);
            }
        }, 100);
        activityWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                if (message != null) {
                    ToastUtils.showShort(message);
                }
                result.cancel();
                return true;
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mProgressBar.setProgress(newProgress);
                }
            }

        });
        activityWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (mProgressBar != null) {
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
        activityWebView.setWebChromeClient(new WebChromeClient() {

            // For Android < 3.0
            public void openFileChooser(ValueCallback<Uri> valueCallback) {
                uploadMessage = valueCallback;
                pickFile();
            }

            // For Android  >= 3.0
            public void openFileChooser(ValueCallback valueCallback, String acceptType) {
                uploadMessage = valueCallback;
                pickFile();
            }

            //For Android  >= 4.1
            public void openFileChooser(ValueCallback<Uri> valueCallback, String acceptType, String capture) {
                uploadMessage = valueCallback;
                pickFile();
            }

            // For Android >= 5.0
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                uploadMessageAboveL = filePathCallback;
                pickFile();
                return true;
            }

        });

    }

    public void pickFile() {
        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);
        i.setType("image/*");
        startActivityForResult(Intent.createChooser(i, "Image Chooser"), FILE_CHOOSER_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FILE_CHOOSER_RESULT_CODE) {
            if (null == uploadMessage && null == uploadMessageAboveL) return;
            Uri result = data == null || resultCode != RESULT_OK ? null : data.getData();
            if (uploadMessageAboveL != null) {
                onActivityResultAboveL(requestCode, resultCode, data);
            } else if (uploadMessage != null) {
                uploadMessage.onReceiveValue(result);
                uploadMessage = null;
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void onActivityResultAboveL(int requestCode, int resultCode, Intent intent) {
        if (requestCode != FILE_CHOOSER_RESULT_CODE || uploadMessageAboveL == null)
            return;
        Uri[] results = null;
        if (resultCode == Activity.RESULT_OK) {
            if (intent != null) {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    results = new Uri[clipData.getItemCount()];
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        ClipData.Item item = clipData.getItemAt(i);
                        results[i] = item.getUri();
                    }
                }
                if (dataString != null)
                    results = new Uri[]{Uri.parse(dataString)};
            }
        }
        uploadMessageAboveL.onReceiveValue(results);
        uploadMessageAboveL = null;
    }

    @Override
    protected IToolbar getIToolbar() {
        toolbarBackTitle = new ToolbarBackTitle(this, "");
        return toolbarBackTitle;
    }

    //Activity退出销毁WebView
    @Override
    protected void onDestroy() {
        if (activityWebView != null) {
            activityWebView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            activityWebView.clearHistory();
            activityWebView.destroy();
            activityWebView = null;
        }
        super.onDestroy();
    }
}
