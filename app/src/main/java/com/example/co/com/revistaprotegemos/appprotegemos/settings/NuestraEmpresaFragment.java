package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.HyphenPattern;
import com.bluejamesbond.text.hyphen.Hyphenator;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

import org.w3c.dom.Document;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuestraEmpresaFragment extends Fragment {

    private Typeface Ofaly,Color;
    TextView nuestra,mision;
    public NuestraEmpresaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_nuestra_empresa, container, false);
        String fuente3 ="fuentes/Abril.otf";
        this.Ofaly =Typeface.createFromAsset(getContext().getAssets(),fuente3);

        nuestra=(TextView)view.findViewById(R.id.nues);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)view.findViewById(R.id.textView3);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)view.findViewById(R.id.textView10);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)view.findViewById(R.id.textView14);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)view.findViewById(R.id.textView12);
        nuestra.setTypeface(Ofaly);

        //Parrafos
        String fuente ="fuentes/April.ttf";
        this.Color =Typeface.createFromAsset(getContext().getAssets(),fuente);

        nuestra=(TextView)view.findViewById(R.id.textView9);
        nuestra.setTypeface(Color);

        nuestra=(TextView)view.findViewById(R.id.textView7);
        nuestra.setTypeface(Color);

        nuestra=(TextView)view.findViewById(R.id.textView11);
        nuestra.setTypeface(Color);

        nuestra=(TextView)view.findViewById(R.id.textView15);
        nuestra.setTypeface(Color);

        nuestra=(TextView)view.findViewById(R.id.textView13);
        nuestra.setTypeface(Color);


/*        DocumentView dvtext=(DocumentView)view.findViewById(R.id.dvText);
        dvtext.getDocumentLayoutParams().setHyphenator(new Hyphenator(HyphenPattern.PT));
        dvtext.getDocumentLayoutParams().setHyphenated(true);*/
        ImageView img = (ImageView)view.findViewById(R.id.imageView8);
        String url="http://192.168.43.73/fotos/premia.png";
        Glide.with(this)
                .load(url)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);
        return view;
    }

}
