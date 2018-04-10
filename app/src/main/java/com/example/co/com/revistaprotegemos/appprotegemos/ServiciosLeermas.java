package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ServiciosLeermas extends AppCompatActivity {
    public static final String titu="titulo";
    public static final String des="descripcion";
    public static final String im="img";
    TextView t1;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_leermas);
        t1=(TextView)findViewById(R.id.textView5);
        im1=(ImageView)findViewById(R.id.imageView7);
        String usuario=getIntent().getStringExtra("titulo");
        String image=getIntent().getStringExtra("img");
        String usuario2=getIntent().getStringExtra("descripcion");

t1.setText(""+usuario+usuario2+"");
        Glide.with(this)
                .load(image)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(im1);

    }
}
