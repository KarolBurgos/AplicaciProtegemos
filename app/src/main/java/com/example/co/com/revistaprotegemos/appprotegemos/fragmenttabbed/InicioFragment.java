package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.api2.DatosApii;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.models2.DataAdapterr;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.models2.Pautas;

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
    private RecyclerView recyclerView;
    private ArrayList<Pautas> data;
    private DataAdapterr adapter;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerVieww);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
        return view;
    }
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApii request = retrofit.create(DatosApii.class);
        Call<JSONResponsee> call = request.getJSON();
        call.enqueue(new Callback<JSONResponsee>() {
            @Override
            public void onResponse(Call<JSONResponsee> call, Response<JSONResponsee> response) {

                JSONResponsee jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapterr(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponsee> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }
}
