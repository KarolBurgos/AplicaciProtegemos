package com.example.co.com.revistaprotegemos.appprotegemos;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class PautasLeerActivity extends AppCompatActivity {
    public static final String id_imagen="id_imagen";
    public static final String imagen="imagen";
    public static final String lugar="lugar";
    TextView t1;
    ImageView im1;
    float scalediff;
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int mode = NONE;
    private float oldDist = 1f;
    private float d = 0f;
    private float newRot = 0f;
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
/*        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(250, 250);
        layoutParams.leftMargin = 50;
        layoutParams.topMargin = 50;
        layoutParams.bottomMargin = -250;
        layoutParams.rightMargin = -250;
        im1.setLayoutParams(layoutParams);*/

    }
}
