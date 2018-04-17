package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.PautasLeerActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.PautasVariables;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.sesion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */

public class DataAdapterr  extends RecyclerView.Adapter<DataAdapterr.ViewHolder > {


    private ArrayList<Pautas> android;
    private Context context;
    private FragmentActivity mycontext;
    private AdapterView.OnItemClickListener escucha;

    public DataAdapterr(ArrayList<Pautas> android, Context context) {
        this.android = android;
        this.context = context;
        this.escucha = escucha;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rowpautas, viewGroup, false);
        return new DataAdapterr.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapterr.ViewHolder viewHolder, int i) {
        viewHolder.tit.setText(android.get(i).getLugar());
        viewHolder.descr.setText(android.get(i).getDescripcion());
        viewHolder.id.setText(android.get(i).getId_zona_pautas());
        Glide.with(context)
                .load(android.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.img);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {
        public TextView tit, descr, id, leer;
        public ImageView img;
        Button b1;
        RequestQueue rq;
        JsonRequest jrq;
        private Typeface Ofaly,Color;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.imageView6);
            tit = (TextView) view.findViewById(R.id.tv_namee);
            descr = (TextView) view.findViewById(R.id.tv_versionn);
            id = (TextView) view.findViewById(R.id.textView52);
            //leer = (TextView) view.findViewById(R.id.leerpautas);
            b1=(Button)view.findViewById(R.id.button4);
            rq = Volley.newRequestQueue(context);
            view.setOnClickListener((View.OnClickListener) this);
            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    iniciarsesion();

                }
            });

/*            String fuente3 ="fuentes/LouisG.ttf";
            this.Ofaly = Typeface.createFromAsset(context.getAssets(),fuente3);


            descr.setTypeface(Ofaly);

            String fuente ="fuentes/LouisI.ttf";
            this.Color =Typeface.createFromAsset(context.getAssets(),fuente);

            tit.setTypeface(Color);*/
            String fuente3 ="fuentes/Dehasta Momentos Regular.otf";
            this.Ofaly = Typeface.createFromAsset(context.getAssets(),fuente3);


            descr.setTypeface(Ofaly);
        }

        @Override
        public void onClick(View view) {
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(context, "No se encontro el usuario" + error.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResponse(JSONObject response) {
            PautasVariables pautasVariables = new PautasVariables();
            JSONArray jsonArray = response.optJSONArray("datos");
            JSONObject jsonObject = null;

            try {
                jsonObject = jsonArray.getJSONObject(0);
                pautasVariables.setId_imagen(jsonObject.optString("id_imagen"));
                pautasVariables.setImagen(jsonObject.optString("imagen"));
                pautasVariables.setLugar(jsonObject.optString("lugar"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(context, PautasLeerActivity.class);
            intent.putExtra(PautasLeerActivity.id_imagen, pautasVariables.getId_imagen());
            intent.putExtra(PautasLeerActivity.imagen, pautasVariables.getImagen());
            intent.putExtra(PautasLeerActivity.lugar, pautasVariables.getLugar());

            context.startActivity(intent);


        }

        private void iniciarsesion() {
            //ViewHolder viewHolder2=null;
            String url = "http://192.168.0.17/sesion/pautasid.php?id_pauta=" + id.getText().toString();
            jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            rq.add(jrq);
        }
    }

    @Override
    public int getItemCount() {
        return android.size();
    }
}
