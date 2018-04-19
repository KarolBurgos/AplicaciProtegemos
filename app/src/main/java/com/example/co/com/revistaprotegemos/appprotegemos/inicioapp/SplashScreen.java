package com.example.co.com.revistaprotegemos.appprotegemos.inicioapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.MainActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.PautasLeerActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.ValidacionNoHayInternet;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private TextView mLoadingText;
    private int mProgressStatus=0;
    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        mProgressBar =(ProgressBar)findViewById(R.id.pro);
        mLoadingText =(TextView)findViewById(R.id.LoadingCompleteTextView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus<100)
                {
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mLoadingText.setVisibility(View.VISIBLE);
                    }
                });
            }
        }).start();




        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               /* NetworkInfo activeNetwork = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

                if (activeNetwork != null && activeNetwork.isConnectedOrConnecting() ) {

                    // Load Webview
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));

                } else {

                    // Show No internet
                    startActivity(new Intent(SplashScreen.this, ValidacionNoHayInternet.class));

                }
                finish();*/
    /*            Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);

                finish();*/

                ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (null != activeNetwork) {
                    if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                        startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                        startActivity(new Intent(SplashScreen.this, MainActivity.class));
                }
                else
                    startActivity(new Intent(SplashScreen.this, ValidacionNoHayInternet.class));

            }
        },2000);

        //estaConectado();
    }



}
