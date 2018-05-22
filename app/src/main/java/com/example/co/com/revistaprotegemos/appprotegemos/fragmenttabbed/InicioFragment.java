package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2.ApiPautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.AdapterPautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONPautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2.ApiJornadas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JornadasAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSONJornadas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.Jornadas;

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
public class InicioFragment extends Fragment {

    //Banner protegemos
    private RecyclerView recyclerViewPautas;
    private RecyclerView recyclerViewJornadas;
    private ArrayList<Pautas> dataPautas;
    private ArrayList<Jornadas> dataJornadas;
    private AdapterPautas adapterPautas;
    private JornadasAdapter adapterJornadas;
    private FragmentActivity myContext;
    private Button bsuscr, btn;
    //Botones de facebook y twitter
    private ImageButton facebook, twitter;

    //Atributo para actualizar la pagina
    SwipeRefreshLayout swipeRefreshLayout;


    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);


        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setIcon(R.mipmap.ic_launcher);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();



        //Listado de pautas
        recyclerViewPautas = (RecyclerView) view.findViewById(R.id.recyclerVieww);
        recyclerViewPautas.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPautas.setLayoutManager(layoutManager);
        loadJSONPautas();
        progressDialog.dismiss();



        //Listado de jornadas
        recyclerViewJornadas = (RecyclerView) view.findViewById(R.id.recyclerVieew);
        recyclerViewJornadas.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewJornadas.setLayoutManager(layoutManager2);
        loadJSONJornadas();
        progressDialog.dismiss();
        bsuscr = (Button) view.findViewById(R.id.btonsuscribirme);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        bsuscr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fragment = null;

                Class fragmentClass = SuscribeteFragment.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();


            }
        });

    }

    //Metodo para cargar las jPautas , llamand a la interfaz api y al adaptador
    private void loadJSONPautas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiPautas request = retrofit.create(ApiPautas.class);
        Call<JSONPautas> call = request.getJSON();
        call.enqueue(new Callback<JSONPautas>() {
            @Override
            public void onResponse(Call<JSONPautas> call, Response<JSONPautas> response) {

                JSONPautas jsonResponse = response.body();
                dataPautas = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterPautas = new AdapterPautas(dataPautas, getContext());
                recyclerViewPautas.setAdapter(adapterPautas);
            }

            @Override
            public void onFailure(Call<JSONPautas> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }

    //Metodo para cargar Jornadas
    private void loadJSONJornadas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiJornadas request = retrofit.create(ApiJornadas.class);
        Call<JSONJornadas> call = request.getJSON();
        call.enqueue(new Callback<JSONJornadas>() {
            @Override
            public void onResponse(Call<JSONJornadas> call, Response<JSONJornadas> response) {

                JSONJornadas jsonResponse = response.body();
                dataJornadas = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterJornadas = new JornadasAdapter(dataJornadas, getContext());
                recyclerViewJornadas.setAdapter(adapterJornadas);
            }

            @Override
            public void onFailure(Call<JSONJornadas> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }

}
