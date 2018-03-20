package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.co.com.revistaprotegemos.appprotegemos.CustomAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2.DatosApii;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.DataAdapterr;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2.DatosApiii;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.DataaAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSOONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.Jornadas;

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
    private Button b1;
    private AdapterViewFlipper IVF;
    private String url;
    private TextView quienes_somos;


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



            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerVieww);
            recyclerView.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 1);
            recyclerView.setLayoutManager(gridLayoutManager);
            loadJSONn();

            recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerVieew);
            recyclerView2.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity().getApplicationContext(), 2);
            recyclerView2.setLayoutManager(gridLayoutManager2);
            loadJSON();

            t1 = (TextView) view.findViewById(R.id.txtvisita);
            t1.setText(getText(R.string.mi_mensaje));

            int images[] = {R.drawable.premia, R.drawable.drogueria, R.drawable.ips};
            String names[] = {"imagen1", "imagen2", "imagen3"};

            IVF = (AdapterViewFlipper) view.findViewById(R.id.IVF);
        if (!compruebaConexion(getContext())) {
            //Toast.makeText(getActivity().getBaseContext(), "Necesaria conexión a internet ", Toast.LENGTH_SHORT).show();

            String url="http://192.168.0.17/webser.php";
            WebView view2=(WebView) view.findViewById(R.id.wv_home);
            view2.getSettings().setJavaScriptEnabled(true);
            view2.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
            view2.loadUrl(url);
        }
        else {
            CustomAdapter custom = new CustomAdapter(myContext.getApplicationContext(), names, images);
            IVF.setAdapter(custom);
            IVF.setFlipInterval(2000);
            IVF.setAutoStart(true);


/*        ImageView img2 = (ImageView)view.findViewById(R.id.iges);
        String url2="http://192.168.0.17/fotos/pic01.jpg";
        Glide.with(this)
                .load(url2)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img2);*/
            String url2="http://192.168.0.17/fotos/tarjetas.gif";
            GifImageView givImageView = (GifImageView) view.findViewById(R.id.iges1);
            Glide.with(getContext()).load("http://192.168.0.17/fotos/tarjetas.gif").into(new GlideDrawableImageViewTarget(givImageView));

            GifImageView givImageView2 = (GifImageView) view.findViewById(R.id.iges2);
            Glide.with(getContext()).load("http://192.168.0.17/fotos/logos.gif").into(new GlideDrawableImageViewTarget(givImageView2));
        }
        quienes_somos=(TextView)view.findViewById(R.id.txquienes);

        return view;
    }
    public void inter() {

    }

    public static boolean compruebaConexion(Context context) {

        boolean connected = false;

        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Recupera todas las redes (tanto móviles como wifi)
        NetworkInfo[] redes = connec.getAllNetworkInfo();

        for (int i = 0; i < redes.length; i++) {
            // Si alguna red tiene conexión, se devuelve true
            if (redes[i].getState() == NetworkInfo.State.CONNECTED) {
                connected = true;
            }
        }
        return connected;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        t1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder uBuilder2 = new AlertDialog.Builder(InicioFragment.super.getContext());
                View aView2 = getLayoutInflater().inflate(R.layout.fragment_suscritos, null);
                uBuilder2.setView(aView2);
                final AlertDialog dialog2 = uBuilder2.create();
                dialog2.show();
                Button close = (Button) aView2.findViewById(R.id.close);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog2.cancel();
                    }
                });

            }
        });


        quienes_somos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder uBuilder2 = new AlertDialog.Builder(InicioFragment.super.getContext());
                View aView2 = getLayoutInflater().inflate(R.layout.fragment_nuestra_empresa, null);
                uBuilder2.setView(aView2);
                final AlertDialog dialog2 = uBuilder2.create();
                dialog2.show();
                Button close = (Button) aView2.findViewById(R.id.close);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog2.cancel();
                    }
                });

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
