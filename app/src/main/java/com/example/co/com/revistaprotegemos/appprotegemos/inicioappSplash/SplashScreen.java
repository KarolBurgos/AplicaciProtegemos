package com.example.co.com.revistaprotegemos.appprotegemos.inicioappSplash;

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
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.MainActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.validacionnohayinternet.ValidacionNoHayInternet;

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

                    //startActivity(new Intent(SplashScreen.this, ValidacionNoHayInternet.class));
                {

                    // Show No internet
                    /*Intent intent = new Intent(getActivity().getApplication(), ValidacionNoHayInternet.class);
                    startActivity(intent);*/
                    Toast toast = Toast.makeText(getApplicationContext(), "No se puede actualizar, Conecte Internet", Toast.LENGTH_SHORT);
                    toast.show();
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));

                }
            }
        },2000);

    }

}
