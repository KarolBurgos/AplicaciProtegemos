package com.example.co.com.revistaprotegemos.appprotegemos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.api.DatosApi;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.DataAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class ServiciosVentajasFragment extends Fragment {

    private Retrofit retrofit;
    //private DataAdapter planes;
    // private RecyclerView recyclerView;
    private int ofset;
    private boolean cargar;
    private RecyclerView recyclerView;
    private ArrayList<Servicios> data;
    private ArrayList<Planes> data2;
    private DataAdapterservicios adapter;
    private DataAdapter adapter2;
    private FragmentActivity f;
    private int offset;
    private Button butonserivicios;

    private ArrayList<Ventajas> data3;
    private DataAdapterVentajas adapter3;
    private RecyclerView recyclerView3;
    private int offset2;

    public ServiciosVentajasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_servicios_ventajas, container, false);




        recyclerView = (RecyclerView)view.findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        offset = numero();
        loadJSON(offset);

        recyclerView3 = (RecyclerView)view.findViewById(R.id.recyventajas);
        recyclerView3.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager3 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView3.setLayoutManager(layoutManager3);
        offset2 = numero();
        loadJSONVentajas(offset2);
        return view;
    }

    private void loadJSON(int co){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatossApii request = retrofit.create(DatossApii.class);
        Call<JSONResponseServicios> call = request.getJSON(co);
        call.enqueue(new Callback<JSONResponseServicios>() {
            @Override
            public void onResponse(Call<JSONResponseServicios> call, Response<JSONResponseServicios> response) {

                JSONResponseServicios jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapterservicios(data,getContext());
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
                .baseUrl("http://192.168.0.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosVentajas request = retrofit.create(DatosVentajas.class);
        Call<JSONResponseVentajas> call = request.getJSON(co);
        call.enqueue(new Callback<JSONResponseVentajas>() {
            @Override
            public void onResponse(Call<JSONResponseVentajas> call, Response<JSONResponseVentajas> response) {

                JSONResponseVentajas jsonResponse = response.body();
                data3 = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter3 = new DataAdapterVentajas(data3,getContext());
                recyclerView3.setAdapter(adapter3);
            }

            @Override
            public void onFailure(Call<JSONResponseVentajas> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    public int numero()
    {
/*        int num=1;
        return num;*/

        PlanesFragment pa=new PlanesFragment();
        int n1= pa.numero();
        return n1;
    }

/*   public int cont(){
        adapter2=new DataAdapter(data2,getContext(),f);
        int j= adapter2.obtId();
        return j;
    }*/
}
