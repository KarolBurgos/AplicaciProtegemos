package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewTwitter extends AppCompatActivity {
    private WebView MWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_twitter);

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
        MWebView.loadUrl("https://twitter.com/citas_grupo");

        MWebView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverriceUrlLoading(WebView view,String url)
            {
                return false;
            }
        });
/*        MWebView = (WebView) findViewById(R.id.webview2);

        //cargo un .html que he situado en la carpeta asset/ del proyecto
        //mWebView.loadUrl("file:///android_asset/ejemploWebview.html");
        MWebView.getSettings().setJavaScriptEnabled(true);
        MWebView.loadUrl("https://twitter.com/citas_grupo");*/
    }
}
