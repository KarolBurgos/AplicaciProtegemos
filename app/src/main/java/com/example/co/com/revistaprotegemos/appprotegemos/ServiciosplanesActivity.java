package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ServiciosplanesActivity extends AppCompatActivity {
    public static final String titulo="titulo";
    public static final String img="img";
    public static final String descripcion="descripcion";
    TextView t1,t2;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serviciosplanes);
        t1=(TextView)findViewById(R.id.titulosd);
        t2=(TextView)findViewById(R.id.descripcion);
        im1=(ImageView)findViewById(R.id.imgks);

        String image=getIntent().getStringExtra("img");
        String usuario=getIntent().getStringExtra("titulo");
        String usuario2=getIntent().getStringExtra("descripcion");

        t1.setText("hol"+""+usuario+usuario2);
        Glide.with(this)
                .load(image)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(im1);
    }
}
