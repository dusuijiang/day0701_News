package com.example.dusj.day0701_news.home.ui;


import android.content.Intent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.dusj.day0701_news.R;
import com.example.dusj.day0701_news.base.BaseActivity;

//新闻内容的一个activity
public class ContentActivity extends BaseActivity {

    private WebView mWebView;

    @Override
    protected int setViewId() {
        return R.layout.activity_content;
    }

    @Override
    protected void findViews() {
        mWebView = (WebView) findViewById(R.id.webView);
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("Url");
        mWebView.loadUrl(url);
        WebSettings webSettings = mWebView.getSettings();
        mWebView.setVerticalScrollBarEnabled(false);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

}
