package com.example.co.com.revistaprotegemos.appprotegemos.settings;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

public class NuestraEmpresaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuestra_empresa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



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
