package com.example.co.com.revistaprotegemos.appprotegemos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class PautasLeerActivity extends AppCompatActivity {
    public static final String id_imagen="id_imagen";
    public static final String imagen="imagen";
    public static final String lugar="lugar";
    TextView t1;
    ImageView im1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_pautas_leer);
       // t1=(TextView)findViewById(R.id.textView51);
/*        getActionBar().hide();
        getSupportActionBar().hide();*/
        im1=(ImageView)findViewById(R.id.imageView4);
        String usuario=getIntent().getStringExtra("id_imagen");
        String image=getIntent().getStringExtra("imagen");
        String usuario2=getIntent().getStringExtra("lugar");

        //t1.setText(""+usuario+usuario2+"");
        Glide.with(this)
                .load(image)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(im1);
        //im1.setImageResource(Integer.parseInt(image));
    }
}
