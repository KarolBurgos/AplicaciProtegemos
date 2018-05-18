package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
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
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewAbrirPaginasUrl;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioAppFragment extends Fragment {


    private FragmentActivity myContext;
    private TextView quienes_somos;
    private TextView tg1,nuestrosplanes;
    private ImageButton facebook,twitter;
    private Button bsuscr,btn;
    private AdapterViewFlipper IVF;

    public InicioAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio_app, container, false);

        GifImageView givImageView = (GifImageView) view.findViewById(R.id.iges1);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/tarjetas.gif").into(new GlideDrawableImageViewTarget(givImageView));

        GifImageView givImageView3 = (GifImageView) view.findViewById(R.id.iges2);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/logos.gif").into(new GlideDrawableImageViewTarget(givImageView3));

        quienes_somos=(TextView)view.findViewById(R.id.txquienes);
        tg1=(TextView)view.findViewById(R.id.textView38);
        nuestrosplanes=(TextView)view.findViewById(R.id.textView22);
        facebook=(ImageButton)view.findViewById(R.id.facebook);
        twitter=(ImageButton)view.findViewById(R.id.twitter);

        int images[] = {R.drawable.premiamin, R.drawable.drogueria, R.drawable.bannermin};
        String names[] = {"imagen1", "imagen2", "imagen3"};

        //Bannerconmovimiento
        IVF = (AdapterViewFlipper) view.findViewById(R.id.IVF);
        CustomAdapter custom = new CustomAdapter(myContext.getApplicationContext(), names, images);
        IVF.setAdapter(custom);
        IVF.setFlipInterval(5000);
        //IVF.setAutoStart(true);

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
    }
}
