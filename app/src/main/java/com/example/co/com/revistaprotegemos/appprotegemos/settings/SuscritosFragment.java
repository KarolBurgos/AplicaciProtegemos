package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;

import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion.User;
import com.example.co.com.revistaprotegemos.appprotegemos.InicioSesion.sesion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuscritosFragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener{

    RequestQueue rq;
    JsonRequest jrq;
    private Spinner spinner;
    EditText contrato,contraseña;
    TextView inicio,senior;
    Button btnconsultar;
    private Typeface Abril;
    private Typeface April,Senior;

    String[] items;
    private boolean isFirstTime=true;
    public SuscritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_suscritos, container, false);


        contrato=(EditText)view.findViewById(R.id.contrato);
        contraseña=(EditText)view.findViewById(R.id.contraseña);

        btnconsultar=(Button) view.findViewById(R.id.iniciar);
        rq= Volley.newRequestQueue(getContext());


        spinner = (Spinner) view.findViewById(R.id.spinner);
        String []opciones={"Pasto","Neiva"};
        ArrayAdapter <String>adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        //Fuentes
        String fuente1 ="fuentes/April.ttf";
        this.April =Typeface.createFromAsset(getContext().getAssets(),fuente1);

        String fuente2 ="fuentes/Abril.otf";
        this.April =Typeface.createFromAsset(getContext().getAssets(),fuente2);

        String fuente3 ="fuentes/Dehasta Momentos Regular.otf";
        this.Senior =Typeface.createFromAsset(getContext().getAssets(),fuente3);

        senior=(TextView)view.findViewById(R.id.senior);
        senior.setTypeface(Senior);

        inicio=(TextView)view.findViewById(R.id.in);
        inicio.setTypeface(April);
        return view;

    }

    @Override
    public void onErrorResponse(VolleyError error) {

            Toast.makeText(getContext(),"No se encontro el usuario"+error.toString(),Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onResponse(JSONObject response) {

        if(contrato.equals("")&&contraseña.equals(""))
        {
            Toast.makeText(getContext(),"Ingrese un usuario",Toast.LENGTH_SHORT).show();
        }
        else {
            User usuario = new User();
            //Toast.makeText(getContext(), "Se ha encontrado el usuario" + contrato.getText().toString(), Toast.LENGTH_SHORT).show();
            JSONArray jsonArray = response.optJSONArray("datos");
            JSONObject jsonObject = null;

            try {
                jsonObject = jsonArray.getJSONObject(0);
                usuario.setNames(jsonObject.optString("names"));
                usuario.setUser(jsonObject.optString("user"));
                usuario.setPwd(jsonObject.optString("pwd"));
                usuario.setEdad(jsonObject.optString("edad"));
                usuario.setSemestre(jsonObject.optString("semestre"));
                usuario.setDeudas(jsonObject.optString("deudas"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(getContext(), sesion.class);
            intent.putExtra(sesion.names, usuario.getNames());
            intent.putExtra(sesion.edad, usuario.getEdad());
            intent.putExtra(sesion.semestre, usuario.getSemestre());
            intent.putExtra(sesion.deudas, usuario.getDeudas());
            intent.putExtra(sesion.user, usuario.getUser());

            startActivity(intent);
        }

    }

    private void iniciarsesion()
    {
        String url="http://192.168.0.17/aplicacionprotegemos/inicio_sesionphp/sesion.php?user="+contrato.getText().toString()+
                "&pwd="+contraseña.getText().toString();
        jrq=new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarsesion();
            }
        });
    }

}
