package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Surface;
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
    private FragmentActivity myContext;
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


/*        spinner = (Spinner) view.findViewById(R.id.spinner);
        String []opciones={"Pasto","Neiva"};
        ArrayAdapter <String>adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);*/

        return view;

    }

    @Override
    public void onErrorResponse(VolleyError error) {

            Toast.makeText(getContext(),"No se encontro el usuario"+error.toString(),Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getActivity().setContentView(R.layout.fragment_suscritos);
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
                usuario.setCon_cod(jsonObject.optString("con_cod"));
                usuario.setPer_cc(jsonObject.optString("per_cc"));
                usuario.setNombre(jsonObject.optString("nombre"));
                usuario.setTipoPlan(jsonObject.optString("tipoPlan"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(getContext(), sesion.class);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarsesion();
            }
        });

        int rotacion = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        if (rotacion == Surface.ROTATION_0 || rotacion == Surface.ROTATION_180) {
            //...hacer lo que quiera con la pantalla vertical

        } else {
            //...hacer lo que quiera con la pantalla horizontal

        }
    }

}
