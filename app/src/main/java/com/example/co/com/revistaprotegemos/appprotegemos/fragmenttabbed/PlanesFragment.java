package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.api.ApiPlanes;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONPlanes;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.PlanesAdapter;

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
public class PlanesFragment extends Fragment {


    private RecyclerView recyclerView;
    private ArrayList<Planes> dataPlanes;
    private PlanesAdapter adapterPlanes;
    private FragmentActivity myContext;
    ProgressBar mProgressBar;
    SwipeRefreshLayout swipeRefreshLayout;

    public PlanesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_planes, container, false);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.Swipeplanes);
        mProgressBar = (ProgressBar)view.findViewById(R.id.progressBar2);
        mProgressBar.setVisibility(View.VISIBLE);
        //Carga el listado de planes de protegemos
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerViewPlanes);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    //Metodo para conecta el JSON con la interface api
    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiPlanes request = retrofit.create(ApiPlanes.class);
        Call<JSONPlanes> call = request.getJSON();
        call.enqueue(new Callback<JSONPlanes>() {
            @Override
            public void onResponse(Call<JSONPlanes> call, Response<JSONPlanes> response) {

                JSONPlanes jsonResponse = response.body();
                dataPlanes = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterPlanes = new PlanesAdapter(dataPlanes, getContext(),myContext,swipeRefreshLayout);
                recyclerView.setAdapter(adapterPlanes);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<JSONPlanes> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
