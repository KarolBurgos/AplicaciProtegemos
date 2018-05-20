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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.co.com.revistaprotegemos.appprotegemos.Banner.CustomAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.validacionnohayinternet.ValidacionNoHayInternet;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.PautasLeerActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioAppFragment extends Fragment {


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
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/tarjetas.gif").into(new GlideDrawableImageViewTarget(givImageView));

        GifImageView givImageView3 = (GifImageView) view.findViewById(R.id.iges2);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/logos.gif").into(new GlideDrawableImageViewTarget(givImageView3));

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
}
