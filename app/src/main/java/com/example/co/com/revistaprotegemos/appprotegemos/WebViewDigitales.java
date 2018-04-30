package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDigitales extends AppCompatActivity {
    private WebView MWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_digitales);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        MWebView = (WebView) findViewById(R.id.webview2);
        MWebView.getSettings().setJavaScriptEnabled(true);
        MWebView.getSettings().setBuiltInZoomControls(true);
        MWebView.loadUrl("http://data.axmag.com/data/201706/20170630/U154892_F446303/FLASH/index.html");

        MWebView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverriceUrlLoading(WebView view,String url)
            {
                return false;
            }
        });
    }
}
