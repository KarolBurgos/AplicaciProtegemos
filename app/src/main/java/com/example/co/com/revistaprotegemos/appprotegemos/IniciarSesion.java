package com.example.co.com.revistaprotegemos.appprotegemos;

import android.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.co.com.revistaprotegemos.appprotegemos.ChatProtegemos.ChatProtegemos;
import com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion.User;
import com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion.sesion;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IniciarSesion extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    RequestQueue rq;
    JsonRequest jrq;
    private Spinner spinner;
    EditText contrato, contraseña;
    TextView inicio, senior;
    Button btnconsultar;
    private Typeface Abril;
    private Typeface April, Senior;

    String[] items;
    private boolean isFirstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

    /*    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_left_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        contrato=(EditText)findViewById(R.id.contrato);
        contraseña=(EditText)findViewById(R.id.contraseña);

        btnconsultar=(Button) findViewById(R.id.iniciar);
        rq= Volley.newRequestQueue(getApplicationContext());

        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarsesion();
            }
        });


    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"No se encontro el usuario"+error.toString(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        if(contrato.equals("")&&contraseña.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Ingrese un usuario",Toast.LENGTH_SHORT).show();
        }
        else {
            User usuario = new User();
            //Toast.makeText(getContext(), "Se ha encontrado el usuario" + contrato.getText().toString(), Toast.LENGTH_SHORT).show();
            JSONArray jsonArray = response.optJSONArray("datos");
            JSONObject jsonObject = null;

            try {
                jsonObject = jsonArray.getJSONObject(0);
                usuario.setCon_cod(jsonObject.optString("con_cod"));
                usuario.setPer_cc(jsonObject.optString("per_cc"));
                usuario.setNombre(jsonObject.optString("nombre"));
                usuario.setTipoPlan(jsonObject.optString("tipoPlan"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(getApplicationContext(), sesion.class);
            intent.putExtra(sesion.con_cod, usuario.getCon_cod());
            intent.putExtra(sesion.per_cc, usuario.getPer_cc());
            intent.putExtra(sesion.nombre, usuario.getNombre());
            intent.putExtra(sesion.tipoPlan, usuario.getTipoPlan());

            startActivity(intent);

            contrato.setText("");
            contraseña.setText("");
        }
    }

    private void iniciarsesion()
    {
        String url="http://192.168.0.17/inicio_sesionphp/sesion.php?con_cod="+contrato.getText().toString()+
                "&per_cc="+contraseña.getText().toString();
        jrq=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }
}
