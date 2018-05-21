package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.annotation.SuppressLint;
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
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales.APIImpresasPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales.AdapterImpresasPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales.ImpresasPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales.JSOnImpresasPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsImpresas.APIDigitalesPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsImpresas.AdapterDigitalesPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsImpresas.DigitalesPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsImpresas.JSONDigitalesPrueba;
import com.example.co.com.revistaprotegemos.appprotegemos.Banner.CustomAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;
import java.util.ArrayList;
import java.util.Arrays;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioAppFragment extends Fragment {

    private RecyclerView recyclerViewImp;
    private ArrayList<ImpresasPrueba> dataImprP;
    private AdapterImpresasPrueba adapterImp;

    private RecyclerView recyclerView;
    private ArrayList<DigitalesPrueba> dataDig;
    private AdapterDigitalesPrueba adapterDig;

    private FragmentActivity myContext;
    private TextView quienes_somos;
    private TextView tg1,nuestrosplanes;
    private ImageButton facebook,twitter;
    private Button bsuscr,btn,btnQuienes,btnnuestrplanes,btnsus;
    private AdapterViewFlipper IVF;
    SwipeRefreshLayout swipeRefreshLayout;

    public InicioAppFragment() {
        // Required empty public constructor
    }


    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio_app, container, false);

        getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getContext(),
                R.color.colorPrimaryDark));
        GifImageView givImageView = (GifImageView) view.findViewById(R.id.iges1);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/Imagenes_mauricio/Gastro_mayo-01.jpg").into(new GlideDrawableImageViewTarget(givImageView));

        GifImageView givImageView3 = (GifImageView) view.findViewById(R.id.iges2);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/logos.gif").into(new GlideDrawableImageViewTarget(givImageView3));

        ImageView im1=view.findViewById(R.id.imageView7);

        Glide.with(this)
                .load("http://www.revistaprotegemos.com.co/imagenesaplicativo/Imagenes_mauricio/Miniatura_gastro.jpg")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(im1);

        btnQuienes=(Button)view.findViewById(R.id.btnquien);
        btnnuestrplanes=(Button)view.findViewById(R.id.btnplanes);
        btnsus=(Button)view.findViewById(R.id.btnsus);
        facebook=(ImageButton)view.findViewById(R.id.facebook);
        twitter=(ImageButton)view.findViewById(R.id.twitter);

        int images[] = {R.drawable.premiamin, R.drawable.drogueria, R.drawable.bannermin};
        String names[] = {"imagen1", "imagen2", "imagen3"};

        //Bannerconmovimiento
        IVF = (AdapterViewFlipper) view.findViewById(R.id.IVF);
        CustomAdapter custom = new CustomAdapter(myContext.getApplicationContext(), names, images);
        IVF.setAdapter(custom);
        IVF.setFlipInterval(5000);
        IVF.setAutoStart(true);

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
                    /*Intent intent = new Intent(getActivity().getApplication(), ValidacionNoHayInternet.class);
                    startActivity(intent);*/
                    Toast toast = Toast.makeText(getContext(), "No se puede actualizar, Conecte Internet", Toast.LENGTH_SHORT);
                    toast.show();

                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 4000);
            }
        });

/*        recyclerViewImp = (RecyclerView)view.findViewById(R.id.rec);
        recyclerViewImp.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerViewImp.setLayoutManager(layoutManager);
        loadJSONImpresas();


        recyclerView = (RecyclerView) view.findViewById(R.id.recedr);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager2);
        loadJSONDigitales();*/

        return view;
    }

    @Override
    public void onAttach(Context activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

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
        btnQuienes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getContext(),NuestraEmpresaActivity.class);
                startActivity(intent);
            }
        });
        btnnuestrplanes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment = null;

                Class fragmentClass = PlanesFragment.class;
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();
            }
        });
        btnsus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getContext(),SuscribeteActivity.class);
                startActivity(intent);
            }
        });
    }


    private void loadJSONImpresas() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.73")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIImpresasPrueba request = retrofit.create(APIImpresasPrueba.class);
        Call<JSOnImpresasPrueba> call = request.getJSON();
        call.enqueue(new Callback<JSOnImpresasPrueba>() {
            @Override
            public void onResponse(Call<JSOnImpresasPrueba> call, Response<JSOnImpresasPrueba> response) {

                JSOnImpresasPrueba jsonResponse = response.body();
                dataImprP = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterImp = new AdapterImpresasPrueba(dataImprP, getContext());
                recyclerViewImp.setAdapter(adapterImp);
            }

            @Override
            public void onFailure(Call<JSOnImpresasPrueba> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void loadJSONDigitales() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.73")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIDigitalesPrueba request = retrofit.create(APIDigitalesPrueba.class);
        Call<JSONDigitalesPrueba> call = request.getJSON();
        call.enqueue(new Callback<JSONDigitalesPrueba>() {
            @Override
            public void onResponse(Call<JSONDigitalesPrueba> call, Response<JSONDigitalesPrueba> response) {

                JSONDigitalesPrueba jsonResponse = response.body();
                dataDig = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapterDig = new AdapterDigitalesPrueba(dataDig, getContext());
                recyclerView.setAdapter(adapterDig);
            }

            @Override
            public void onFailure(Call<JSONDigitalesPrueba> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
