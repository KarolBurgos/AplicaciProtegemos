package com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;

public class sesion extends AppCompatActivity {
    public static final String names="names";
    public static final String edad="edad";
    public static final String semestre="semestre";
    public static final String deudas="deudas";
    public static final String user="user";
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

   na=(TextView)findViewById(R.id.name);
   ed=(TextView)findViewById(R.id.edad);
   se=(TextView)findViewById(R.id.seme);
   de=(TextView)findViewById(R.id.deu);
   use=(TextView)findViewById(R.id.user);
   String usuario=getIntent().getStringExtra("names");
   String ed1=getIntent().getStringExtra("edad");
   String se1m=getIntent().getStringExtra("semestre");
   String deu=getIntent().getStringExtra("deudas");
   String us=getIntent().getStringExtra("user");


   na.setText(usuario);
   ed.setText(ed1);
   se.setText(se1m);
   de.setText(deu);
   use.setText(us);
    }


}
