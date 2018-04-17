package com.example.co.com.revistaprotegemos.appprotegemos.revistaProtegemos;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class EdicionesImpresas extends Fragment {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
    private FragmentActivity myContext;
    private Button regresar;
    public EdicionesImpresas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ediciones_impresas, container, false);


        ImageView img = (ImageView)view.findViewById(R.id.imgrevisss);
        String url="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion1.png";
        Glide.with(this)
                .load(url)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);

        ImageView img2 = (ImageView)view.findViewById(R.id.imr2);
        String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion2.png";
        Glide.with(this)
                .load(url2)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img2);

        ImageView img3 = (ImageView)view.findViewById(R.id.imr3);
        String url3="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion3.png";
        Glide.with(this)
                .load(url3)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img3);

        ImageView img4 = (ImageView)view.findViewById(R.id.imr4);
        String url4="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion4.png";
        Glide.with(this)
                .load(url4)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img4);

        ImageView img5 = (ImageView)view.findViewById(R.id.imr5);
        String url5="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion5.png";
        Glide.with(this)
                .load(url5)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img5);

        ImageView img6 = (ImageView)view.findViewById(R.id.imr6);
        String url6="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion6.png";
        Glide.with(this)
                .load(url6)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img6);

        ImageView img7 = (ImageView)view.findViewById(R.id.imr7);
        String url7="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion7.png";
        Glide.with(this)
                .load(url7)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img7);

        ImageView img8 = (ImageView)view.findViewById(R.id.imr8);
        String url8="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion8.png";
        Glide.with(this)
                .load(url8)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img8);

        ImageView img9 = (ImageView)view.findViewById(R.id.imr9);
        String url9="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion9.png";
        Glide.with(this)
                .load(url9)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img9);

        ImageView img10 = (ImageView)view.findViewById(R.id.imr10);
        String url10="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion10.png";
        Glide.with(this)
                .load(url10)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img10);

        ImageView img11 = (ImageView)view.findViewById(R.id.imr11);
        String url11="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion11.png";
        Glide.with(this)
                .load(url11)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img11);

        ImageView img12 = (ImageView)view.findViewById(R.id.imr12);
        String url12="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion12.png";
        Glide.with(this)
                .load(url12)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img12);

        ImageView img13 = (ImageView)view.findViewById(R.id.imr13);
        String url13="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion13.png";
        Glide.with(this)
                .load(url13)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img13);

        ImageView img14 = (ImageView)view.findViewById(R.id.imr14);
        String url14="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion14.png";
        Glide.with(this)
                .load(url14)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img14);

        b1=(Button)view.findViewById(R.id.txtbut1);
        b2=(Button)view.findViewById(R.id.trb);
        b3=(Button)view.findViewById(R.id.trb1);
        b4=(Button)view.findViewById(R.id.trb2);
        b5=(Button)view.findViewById(R.id.trb3);
        b6=(Button)view.findViewById(R.id.trb4);
        b7=(Button)view.findViewById(R.id.trb5);
        b8=(Button)view.findViewById(R.id.trb6);
        b9=(Button)view.findViewById(R.id.trb7);
        b10=(Button)view.findViewById(R.id.trb8);
        b11=(Button)view.findViewById(R.id.trb9);
        b12=(Button)view.findViewById(R.id.trb10);
        b13=(Button)view.findViewById(R.id.trb11);
        b14=(Button)view.findViewById(R.id.trb12);

        /* regresar = (Button) view.findViewById(R.id.regre);*/




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443502/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443498/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("https://cdn.flipsnack.com/widget/v2/flipsnackwidget.html?hash=fdnqt6v4i&bgcolor=EEEEEE&t=1501278660");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150729/U137868_F347338/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150729/U137868_F347294/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150729/U137868_F347341/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443515/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150727/U137868_F347002/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201705/20170526/U154892_F441324/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201605/20160517/U137868_F381774/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443505/FLASH/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
      /*  regresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  Log.e("fdgfdfgfgfgfh--->","SI");
                //getActivity().finish();
                Fragment fragment = null;

                Class fragmentClass= PrincipalFragment.class;
                try{
                    fragment = (Fragment) fragmentClass.newInstance();

                }catch (Exception e){
                    e.printStackTrace();
                }
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();


            }
        });*/

    }

    public void salir()
    {
        getActivity().finish();
    }
}
