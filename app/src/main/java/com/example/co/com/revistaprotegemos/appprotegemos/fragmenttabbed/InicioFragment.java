package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.co.com.revistaprotegemos.appprotegemos.Banner.CustomAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.validacionnohayinternet.ValidacionNoHayInternet;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2.DatosApii;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.DataAdapterr;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2.DatosApiii;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.DataaAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSOONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.Jornadas;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
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
public class InicioFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ArrayList<Pautas> data;
    private ArrayList<Jornadas> data2;
    private DataAdapterr adapter;
    private DataaAdapter adapter2;
    private ImageView imagen1,img2;
    private TextView t1,t2;
    private FragmentActivity myContext;
    private Button bsuscr,btn;
    private AdapterViewFlipper IVF;
    private String url;
    private TextView quienes_somos,visite,encontrara,jornada;
    private TextView tg1,nuestrosplanes,susc,somo,estaslisto,pautas;
    private Typeface Nuestrosplanes,Aurella;

    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;
    int number=0;
    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.Swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NetworkInfo activeNetwork = ((ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {

                    // Load Webview
                    Fragment fragment = null;
                    Class fragmentClass= PrincipalFragment.class;
                    try{
                        fragment = (Fragment) fragmentClass.newInstance();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager=myContext.getSupportFragmentManager();
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
                },4000);
            }
        });

            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerVieww);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(layoutManager);
            loadJSONn();

            recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerVieew);
            recyclerView2.setHasFixedSize(true);
            /*GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity().getApplicationContext(), 2);
            recyclerView2.setLayoutManager(gridLayoutManager2);*/
            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView2.setLayoutManager(layoutManager2);
            loadJSON();

            t1 = (TextView) view.findViewById(R.id.txtvisita);
            t1.setText(getText(R.string.mi_mensaje));

   /*          Bitmap obtener_imagen = get_imagen("http://www.revistaprotegemos.com.co/imagenesaplicativo/premia.png");
             //uImageView.setImageBitmap(obtener_imagen);
            Drawable d = new BitmapDrawable(getResources(), obtener_imagen);
            int drawableId = Integer.parseInt(d.toString());*/




            int images[] = {R.drawable.premia, R.drawable.drogueria, R.drawable.ips};
            String names[] = {"imagen1", "imagen2", "imagen3"};

        bsuscr=(Button)view.findViewById(R.id.btonsuscribirme);


        IVF = (AdapterViewFlipper) view.findViewById(R.id.IVF);
        CustomAdapter custom = new CustomAdapter(myContext.getApplicationContext(), names, images);
        IVF.setAdapter(custom);
        IVF.setFlipInterval(2000);
        //IVF.setAutoStart(true);

        GifImageView givImageView = (GifImageView) view.findViewById(R.id.iges1);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/tarjetas.gif").into(new GlideDrawableImageViewTarget(givImageView));

        GifImageView givImageView3 = (GifImageView) view.findViewById(R.id.iges2);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/logos.gif").into(new GlideDrawableImageViewTarget(givImageView3));
        quienes_somos=(TextView)view.findViewById(R.id.txquienes);
        tg1=(TextView)view.findViewById(R.id.textView38);
        nuestrosplanes=(TextView)view.findViewById(R.id.textView22);

        String fuente1 ="fuentes/Dehasta Momentos Regular.otf";
        this.Nuestrosplanes =Typeface.createFromAsset(getContext().getAssets(),fuente1);

        visite=(TextView)view.findViewById(R.id.textView41);
        visite.setTypeface(Nuestrosplanes);

        encontrara=(TextView)view.findViewById(R.id.txtvisita);
        encontrara.setTypeface(Nuestrosplanes);

        jornada=(TextView)view.findViewById(R.id.textVie);
        jornada.setTypeface(Nuestrosplanes);

        nuestrosplanes=(TextView)view.findViewById(R.id.textView22);
        nuestrosplanes.setTypeface(Nuestrosplanes);

        susc=(TextView)view.findViewById(R.id.textView38);
        susc.setTypeface(Nuestrosplanes);

        somo=(TextView)view.findViewById(R.id.txquienes);
        somo.setTypeface(Nuestrosplanes);

        pautas=(TextView)view.findViewById(R.id.textView53);
        pautas.setTypeface(Nuestrosplanes);

        String fuente2 ="fuentes/Aurella.ttf";
        this.Aurella =Typeface.createFromAsset(getContext().getAssets(),fuente2);

        estaslisto=(TextView)view.findViewById(R.id.textViews4);
        estaslisto.setTypeface(Nuestrosplanes);

        btn=(Button)view.findViewById(R.id.button5);
        return view;
    }
    public void inter() {

    }
    private Bitmap get_imagen(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {

        }
        return bm;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fragment = null;
                Class fragmentClass= SuscritosFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {




            }
        });

        bsuscr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent=new Intent (getContext(),SuscribeteActivity.class);
                startActivity(intent);


            }
        });


        quienes_somos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent=new Intent (getContext(),NuestraEmpresaActivity.class);
                startActivity(intent);

            }
        });

        tg1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent=new Intent (getContext(),SuscribeteActivity.class);
                startActivity(intent);

            }
        });
        nuestrosplanes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Fragment fragment = null;
                Class fragmentClass= PlanesFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();
                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();

            }
        });

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
                adapter = new DataAdapterr(data,getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponsee> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void loadJSONn(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApiii request = retrofit.create(DatosApiii.class);
        Call<JSOONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSOONResponse>() {
            @Override
            public void onResponse(Call<JSOONResponse> call, Response<JSOONResponse> response) {

                JSOONResponse jsonResponse = response.body();
                data2 = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter2 = new DataaAdapter(data2,getContext());
                recyclerView2.setAdapter(adapter2);
            }

            @Override
            public void onFailure(Call<JSOONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
