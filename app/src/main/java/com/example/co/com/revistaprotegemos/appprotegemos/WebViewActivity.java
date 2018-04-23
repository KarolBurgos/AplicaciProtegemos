package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView MWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        setContentView(R.layout.activity_web_view);

        MWebView = (WebView) findViewById(R.id.webview);

        //cargo un .html que he situado en la carpeta asset/ del proyecto
        //mWebView.loadUrl("file:///android_asset/ejemploWebview.html");
        MWebView.getSettings().setJavaScriptEnabled(true);
        MWebView.loadUrl("http://www.revistaprotegemos.com.co/fisica.html");

        }



    }

