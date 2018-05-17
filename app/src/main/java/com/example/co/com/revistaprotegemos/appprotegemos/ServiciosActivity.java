package com.example.co.com.revistaprotegemos.appprotegemos;

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
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.PlanesAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.api.DatossApii;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.DataAdapterservicios;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONResponseServicios;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.Servicios;
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.api.DatosVentajas;
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

    PlanesAdapter.ViewHolderN viewHolderN;
    private Retrofit retrofit;
    //private DataAdapter planes;
    // private RecyclerView recyclerView;
    private int ofset;
    private boolean cargar;
    private RecyclerView recyclerView;
    private ArrayList<Servicios> data;
    private ArrayList<Planes> data2;
    private DataAdapterservicios adapter;
    private PlanesAdapter adapter2;
    private FragmentActivity f;
    private int offset;
    private Button butonserivicios;
    private FragmentActivity myContext;
    private ArrayList<Ventajas> data3;
    private DataAdapterVentajas adapter3;
    private RecyclerView recyclerView3;
    private int offset2;
    private Typeface Ofaly,Color;
    private View view;
    TextView titulo;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));

        recyclerView = (RecyclerView)findViewById(R.id.recyy);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        //getIntent().getExtras().getString("parametro");
        Bundle parametros = this.getIntent().getExtras();
        String datos = parametros.getString("param");
        int d1= Integer.parseInt(datos);
        offset = d1;
        loadJSON(offset);


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

/*        recyclerView3 = (RecyclerView)view.findViewById(R.id.recyventaja);
        recyclerView3.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getApplicationContext().getApplicationContext());
        recyclerView3.setLayoutManager(layoutManager3);

        Bundle parametros1 = this.getIntent().getExtras();
        String datos1 = parametros.getString("param");
        int d2= Integer.parseInt(datos1);
        offset2 = d2;
        loadJSONVentajas(offset2);*/


    }

    private void loadJSON(int co){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatossApii request = retrofit.create(DatossApii.class);
        Call<JSONResponseServicios> call = request.getJSON(co);
        call.enqueue(new Callback<JSONResponseServicios>() {
            @Override
            public void onResponse(Call<JSONResponseServicios> call, Response<JSONResponseServicios> response) {

                JSONResponseServicios jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapterservicios(data,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponseServicios> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void loadJSONVentajas(int co){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosVentajas request = retrofit.create(DatosVentajas.class);
        Call<JSONResponseVentajas> call = request.getJSON(co);
        call.enqueue(new Callback<JSONResponseVentajas>() {
            @Override
            public void onResponse(Call<JSONResponseVentajas> call, Response<JSONResponseVentajas> response) {

                JSONResponseVentajas jsonResponse = response.body();
                data3 = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter3 = new DataAdapterVentajas(data3,getApplicationContext());
                recyclerView3.setAdapter(adapter3);
            }

            @Override
            public void onFailure(Call<JSONResponseVentajas> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
