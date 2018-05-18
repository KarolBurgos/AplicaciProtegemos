package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.co.com.revistaprotegemos.appprotegemos.R;

public class WebViewAbrirPaginasUrl extends AppCompatActivity {
    private WebView MWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_digitales);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

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
        Bundle bundle = getIntent().getExtras();
        MWebView.loadUrl("http://" + bundle.getString("direccion"));
        MWebView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
            }
        });
    }
}
