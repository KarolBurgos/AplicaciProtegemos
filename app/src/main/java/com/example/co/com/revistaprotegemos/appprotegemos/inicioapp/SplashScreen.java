package com.example.co.com.revistaprotegemos.appprotegemos.inicioapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.MainActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

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

                Intent intent =new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);

                finish();

            }
        },2000);

        //estaConectado();
    }



}
