package com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;

public class sesion extends AppCompatActivity {
    public static final String con_cod="con_cod";
    public static final String per_cc="per_cc";
    public static final String nombre="nombre";
    public static final String tipoPlan="tipoPlan";
    TextView cajabienvenido,na,ed,se,de,use;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

   na=(TextView)findViewById(R.id.con);
   ed=(TextView)findViewById(R.id.contras);
   se=(TextView)findViewById(R.id.nombr);
   de=(TextView)findViewById(R.id.tplan);

   String usuario=getIntent().getStringExtra("con_cod");
   String ed1=getIntent().getStringExtra("per_cc");
   String se1m=getIntent().getStringExtra("nombre");
   String deu=getIntent().getStringExtra("tipoPlan");


   na.setText(usuario);
   ed.setText(ed1);
   se.setText(se1m);
   de.setText(deu);
    }


}
