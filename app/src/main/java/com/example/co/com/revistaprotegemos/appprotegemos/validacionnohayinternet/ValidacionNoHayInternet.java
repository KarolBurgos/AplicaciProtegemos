package com.example.co.com.revistaprotegemos.appprotegemos.validacionnohayinternet;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.co.com.revistaprotegemos.appprotegemos.MainActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

public class ValidacionNoHayInternet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion_no_hay_internet);
    }

    public void validar(View view)
    {
        NetworkInfo activeNetwork = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {

            // Load Webview
            startActivity(new Intent(ValidacionNoHayInternet.this, MainActivity.class));

        } else {

            // Show No internet
            startActivity(new Intent(ValidacionNoHayInternet.this, ValidacionNoHayInternet.class));

        }
    }
}
