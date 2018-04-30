package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.co.com.revistaprotegemos.appprotegemos.revistaProtegemosEdiciones.EdicionesDigitalesFragment;

public class WebViewActivity extends AppCompatActivity {

    private WebView MWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        MWebView = (WebView) findViewById(R.id.webview);

        MWebView.getSettings().setJavaScriptEnabled(true);
        MWebView.getSettings().setBuiltInZoomControls(true);
        EdicionesDigitalesFragment edicionesDigitalesFragment=new EdicionesDigitalesFragment();
        Button b1=edicionesDigitalesFragment.getB1();
        Button b2=edicionesDigitalesFragment.getB2();
        Button b3=edicionesDigitalesFragment.getB3();
        Button b4=edicionesDigitalesFragment.getB4();
        Button b5=edicionesDigitalesFragment.getB5();
        Button b6=edicionesDigitalesFragment.getB6();


    cargar("https://www.facebook.com/Grupo-Editorial-Protegemos-1810118702587250/?view_public_for=1810118702587250");


        MWebView.setWebViewClient(new WebViewClient()
        {
            public boolean shouldOverriceUrlLoading(WebView view,String url)
            {
                return false;
            }
        });
        //cargo un .html que he situado en la carpeta asset/ del proyecto
        //mWebView.loadUrl("file:///android_asset/ejemploWebview.html");/*
/*        MWebView.getSettings().setJavaScriptEnabled(true);
        MWebView.loadUrl("https://www.facebook.com/Grupo-Editorial-Protegemos-1810118702587250/?view_public_for=1810118702587250");*/

        }

        public void cargar(String ulr)
        {

                MWebView.loadUrl(ulr);

        }


    }

