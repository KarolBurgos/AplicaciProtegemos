package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.PlanesAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.api.ApiServicios;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.AdapterServicios;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONServicios;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.Servicios;
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.api.ApiVentajas;
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.models.DataAdapterVentajas;
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.models.JSONResponseVentajas;
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.models.Ventajas;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiciosActivity extends AppCompatActivity {


    private int ofset;
    private RecyclerView recyclerView;
    private ArrayList<Servicios> dataServicios;
    private AdapterServicios adapterServicios;
    private int offset;
    private ArrayList<Ventajas> dataVentajas;
    private DataAdapterVentajas adapterVentajas;
    private RecyclerView recyclerView3;
    private int offset2;
    ProgressBar mProgressBar;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView textView =(TextView)findViewById(R.id.textVie);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));

        mProgressBar = (ProgressBar)findViewById(R.id.progressBar2);
        mProgressBar.setVisibility(View.VISIBLE);

        recyclerView = (RecyclerView)findViewById(R.id.recyy);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        Bundle parametros = this.getIntent().getExtras();
        String datos = parametros.getString("param");
        int d1= Integer.parseInt(datos);
        offset = d1;
        loadJSON(offset);

        if(d1==1)
        {
            textView.setText("Plan Platino");
        }
        else if(d1==2)
        {
            textView.setText("Plan V.I.P");
        }
        else if(d1==3)
        {
            textView.setText("Plan Auxilio Economico por Fallecimiento");
        }
        else if(d1==4)
        {
            textView.setText("Plan Familiar");
        }
        else if(d1==5)
        {
            textView.setText("Plan Unipersonal");
        }



        recyclerView3 = (RecyclerView)findViewById(R.id.recyventaja);
        recyclerView3.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView3.setLayoutManager(layoutManager3);
        //getIntent().getExtras().getString("parametro");
        Bundle parametros3 = this.getIntent().getExtras();
        String datos3 = parametros3.getString("param");
        int d13= Integer.parseInt(datos3);
        offset2 = d13;
        loadJSONVentajas(offset2);


    }

    private void loadJSON(int co){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiServicios request = retrofit.create(ApiServicios.class);
        Call<JSONServicios> call = request.getJSON(co);
        call.enqueue(new Callback<JSONServicios>() {
            @Override
            public void onResponse(Call<JSONServicios> call, Response<JSONServicios> response) {

                JSONServicios jsonResponse = response.body();
                dataServicios = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterServicios = new AdapterServicios(dataServicios,getApplicationContext());
                recyclerView.setAdapter(adapterServicios);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<JSONServicios> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void loadJSONVentajas(int co){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiVentajas request = retrofit.create(ApiVentajas.class);
        Call<JSONResponseVentajas> call = request.getJSON(co);
        call.enqueue(new Callback<JSONResponseVentajas>() {
            @Override
            public void onResponse(Call<JSONResponseVentajas> call, Response<JSONResponseVentajas> response) {

                JSONResponseVentajas jsonResponse = response.body();
                dataVentajas = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterVentajas = new DataAdapterVentajas(dataVentajas,getApplicationContext());
                recyclerView3.setAdapter(adapterVentajas);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<JSONResponseVentajas> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
