package com.example.co.com.revistaprotegemos.appprotegemos.revistaProtegemos;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class EdicionesDigitalesFragment extends Fragment {


    private Button b1,b2,b3,b4,b5,b6;
    public EdicionesDigitalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ediciones_digitales, container, false);

        ImageView img = (ImageView)view.findViewById(R.id.imd1);
        String url="http://192.168.43.73/aplicacionprotegemos/fotos/EdicionPapa1.png";
        Glide.with(this)
                .load(url)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);
        ImageView img2 = (ImageView)view.findViewById(R.id.imd2);
        String url2="http://192.168.43.73/aplicacionprotegemos/fotos/EdicionPapa2.png";
        Glide.with(this)
                .load(url2)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img2);

        ImageView img3 = (ImageView)view.findViewById(R.id.imd3);
        String url3="http://192.168.43.73/aplicacionprotegemos/fotos/EdicionPapa3.png";
        Glide.with(this)
                .load(url3)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img3);

        ImageView img4 = (ImageView)view.findViewById(R.id.imd4);
        String url4="http://192.168.43.73/aplicacionprotegemos/fotos/EdicionManualidades1.png";
        Glide.with(this)
                .load(url4)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img4);
        ImageView img5 = (ImageView)view.findViewById(R.id.imd5);
        String url5="http://192.168.43.73/aplicacionprotegemos/fotos/EdicionManualidades2.png";
        Glide.with(this)
                .load(url5)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img5);

        ImageView img6 = (ImageView)view.findViewById(R.id.imd6);
        String url6="http://192.168.43.73/aplicacionprotegemos/fotos/EdicionManualidades3.png";
        Glide.with(this)
                .load(url6)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img6);

        b1=(Button)view.findViewById(R.id.tbd1);
        b2=(Button)view.findViewById(R.id.tbd2);
        b3=(Button)view.findViewById(R.id.tbd3);
        b4=(Button)view.findViewById(R.id.tbd4);
        b5=(Button)view.findViewById(R.id.tbd5);
        b6=(Button)view.findViewById(R.id.tbd6);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  Log.e("fdgfdfgfgfgfh--->","SI");
/*                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443501/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent)*/;
                Intent myIntent = new Intent(getContext(), WebViewActivity.class);
                startActivity(myIntent);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170630/U154892_F446305/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201605/20160517/U137868_F381778/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201605/20160517/U137868_F381781/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
    }
}
