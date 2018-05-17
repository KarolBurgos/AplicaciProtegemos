package com.example.co.com.revistaprotegemos.appprotegemos;

import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.models.DataAdapterVentajas;
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

        recyclerView = (RecyclerView)findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);


        //getIntent().getExtras().getString("parametro");
        Bundle parametros = this.getIntent().getExtras();
        String datos = parametros.getString("param");
        int d1= Integer.parseInt(datos);
        offset = d1;
        loadJSON(offset);


        String fuente ="fuentes/Dehasta Momentos Regular.otf";
        this.Color = Typeface.createFromAsset(getApplicationContext().getAssets(),fuente);
        titulo = (TextView)findViewById(R.id.textView16);
        titulo.setTypeface(Color);
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

    public int numero(View view)
    {
/*        int num=1;
        return num;*/

        PlanesFragment pa=new PlanesFragment();
        int n1= pa.numero(view);
        return n1;
    }
}
