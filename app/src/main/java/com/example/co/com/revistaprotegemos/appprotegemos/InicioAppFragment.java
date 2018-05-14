package com.example.co.com.revistaprotegemos.appprotegemos;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;

import pl.droidsonroids.gif.GifImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioAppFragment extends Fragment {

    private FragmentActivity myContext;
    private TextView quienes_somos,visite,encontrara,jornada;
    private TextView tg1,nuestrosplanes,susc,somo,estaslisto,pautas;
    private ImageButton facebook,twitter;
    private Button bsuscr,btn;
    public InicioAppFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio_app, container, false);

        ImageView img = (ImageView)view.findViewById(R.id.imageView7);
        String url="http://www.revistaprotegemos.com.co/imagenesaplicativo/premia.png";
        Glide.with(this)
                .load(url)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);

        GifImageView givImageView = (GifImageView) view.findViewById(R.id.iges1);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/tarjetas.gif").into(new GlideDrawableImageViewTarget(givImageView));

        GifImageView givImageView3 = (GifImageView) view.findViewById(R.id.iges2);
        Glide.with(getContext()).load("http://www.revistaprotegemos.com.co/imagenesaplicativo/logos.gif").into(new GlideDrawableImageViewTarget(givImageView3));
        quienes_somos=(TextView)view.findViewById(R.id.txquienes);
        tg1=(TextView)view.findViewById(R.id.textView38);
        nuestrosplanes=(TextView)view.findViewById(R.id.textView22);
        facebook=(ImageButton)view.findViewById(R.id.facebook);
        twitter=(ImageButton)view.findViewById(R.id.twitter);
        btn=(Button)view.findViewById(R.id.button5);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

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
        super.onActivityCreated(savedInstanceState);
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
