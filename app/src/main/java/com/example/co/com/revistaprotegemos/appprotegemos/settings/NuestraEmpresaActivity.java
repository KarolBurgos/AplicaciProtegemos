package com.example.co.com.revistaprotegemos.appprotegemos.settings;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

public class NuestraEmpresaActivity extends AppCompatActivity {

    private Typeface Ofaly,Color;
    TextView nuestra,mision;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuestra_empresa);

        String fuente3 ="fuentes/Abril.otf";
        this.Ofaly =Typeface.createFromAsset(getAssets(),fuente3);

        nuestra=(TextView)findViewById(R.id.nues);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)findViewById(R.id.textView3);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)findViewById(R.id.textView10);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)findViewById(R.id.textView14);
        nuestra.setTypeface(Ofaly);

        nuestra=(TextView)findViewById(R.id.textView12);
        nuestra.setTypeface(Ofaly);

        //Parrafos
        String fuente ="fuentes/Dehasta Momentos Regular.otf";
        this.Color =Typeface.createFromAsset(getAssets(),fuente);

        nuestra=(TextView)findViewById(R.id.textView9);
        nuestra.setTypeface(Color);

        nuestra=(TextView)findViewById(R.id.textView7);
        nuestra.setTypeface(Color);

        nuestra=(TextView)findViewById(R.id.textView11);
        nuestra.setTypeface(Color);

        nuestra=(TextView)findViewById(R.id.textView15);
        nuestra.setTypeface(Color);

        nuestra=(TextView)findViewById(R.id.textView13);
        nuestra.setTypeface(Color);


/*        DocumentView dvtext=(DocumentView)view.findViewById(R.id.dvText);
        dvtext.getDocumentLayoutParams().setHyphenator(new Hyphenator(HyphenPattern.PT));
        dvtext.getDocumentLayoutParams().setHyphenated(true);*/
        ImageView img = (ImageView)findViewById(R.id.imageView8);
        String url="http://www.revistaprotegemos.com.co/imagenesaplicativo/premia.png";
        Glide.with(this)
                .load(url)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(img);
    }
}
