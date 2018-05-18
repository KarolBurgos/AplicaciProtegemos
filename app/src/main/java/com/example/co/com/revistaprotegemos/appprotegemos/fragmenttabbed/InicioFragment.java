package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
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

import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.validacionnohayinternet.ValidacionNoHayInternet;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2.ApiPautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.AdapterPautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2.DatosApiii;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.DataaAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSOONResponse;
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
    private DataaAdapter adapterJornadas;
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

        facebook = (ImageButton) view.findViewById(R.id.facebook);
        twitter = (ImageButton) view.findViewById(R.id.twitter);

        //Permite actualizar la pagina
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.Swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NetworkInfo activeNetwork = ((ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {

                    // Load Webview
                    Fragment fragment = null;
                    Class fragmentClass = PrincipalFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();

                } else {

                    // Show No internet
                    Intent intent = new Intent(getActivity().getApplication(), ValidacionNoHayInternet.class);
                    startActivity(intent);

                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 4000);
            }
        });

        //Listado de pautas
        recyclerViewPautas = (RecyclerView) view.findViewById(R.id.recyclerVieww);
        recyclerViewPautas.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPautas.setLayoutManager(layoutManager);
        loadJSONPautas();

        //Listado de jornadas
        recyclerViewJornadas = (RecyclerView) view.findViewById(R.id.recyclerVieew);
        recyclerViewJornadas.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewJornadas.setLayoutManager(layoutManager2);
        loadJSONJornadas();
        bsuscr = (Button) view.findViewById(R.id.btonsuscribirme);

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        bsuscr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), SuscribeteActivity.class);
                startActivity(intent);


            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(), WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "www.facebook.com/Grupo-Editorial-Protegemos-1810118702587250/?view_public_for=1810118702587250");
                startActivity(myIntent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(), WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "twitter.com/citas_grupo");
                startActivity(myIntent);
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
        Call<JSONResponsee> call = request.getJSON();
        call.enqueue(new Callback<JSONResponsee>() {
            @Override
            public void onResponse(Call<JSONResponsee> call, Response<JSONResponsee> response) {

                JSONResponsee jsonResponse = response.body();
                dataPautas = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterPautas = new AdapterPautas(dataPautas, getContext());
                recyclerViewPautas.setAdapter(adapterPautas);
            }

            @Override
            public void onFailure(Call<JSONResponsee> call, Throwable t) {
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
        DatosApiii request = retrofit.create(DatosApiii.class);
        Call<JSOONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSOONResponse>() {
            @Override
            public void onResponse(Call<JSOONResponse> call, Response<JSOONResponse> response) {

                JSOONResponse jsonResponse = response.body();
                dataJornadas = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterJornadas = new DataaAdapter(dataJornadas, getContext());
                recyclerViewJornadas.setAdapter(adapterJornadas);
            }

            @Override
            public void onFailure(Call<JSOONResponse> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

    }

}
