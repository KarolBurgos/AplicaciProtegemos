package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
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

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosPlanes;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosplanesActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.sesion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 21/02/2018.
 */

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder > {


    private ArrayList<Planes> android;
    private Context context;
    private AdapterView.OnItemClickListener escucha;

    public DataAdapter(ArrayList<Planes> android, Context context) {
        this.android = android;
        this.context = context;
        this.escucha = escucha;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new DataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tit.setText(android.get(i).getTitulo());
        viewHolder.descr.setText(android.get(i).getDescripcion());
        viewHolder.id.setText(android.get(i).getidString());
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
        RequestQueue rq;
        JsonRequest jrq;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.fotico);
            tit = (TextView) view.findViewById(R.id.tv_name);
            descr = (TextView) view.findViewById(R.id.tv_version);
            id = (TextView) view.findViewById(R.id.numid);
            leer = (TextView) view.findViewById(R.id.leer);
            rq = Volley.newRequestQueue(context);
            view.setOnClickListener((View.OnClickListener) this);
            leer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    iniciarsesion();

                }
            });
        }

        @Override
        public void onClick(View view) {
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(context, "No se encontro el usuario" + id.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResponse(JSONObject response) {
            ServiciosPlanes serplanes = new ServiciosPlanes();
            JSONArray jsonArray = response.optJSONArray("datos");
            JSONObject jsonObject = null;

            try {
                jsonObject = jsonArray.getJSONObject(0);
                serplanes.setId_servicios(Integer.parseInt(jsonObject.optString("id_servicios")));
                serplanes.setTitulo(jsonObject.optString("titulo"));
                serplanes.setDescripcion(jsonObject.optString("descripcion"));
                serplanes.setImg(jsonObject.optString("img"));
               serplanes.setId_planes(Integer.parseInt(jsonObject.optString("id_planes")));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(context, ServiciosplanesActivity.class);
           intent.putExtra(ServiciosplanesActivity.titulo, serplanes.getTitulo());
            intent.putExtra(ServiciosplanesActivity.descripcion, serplanes.getDescripcion());
            intent.putExtra(ServiciosplanesActivity.img, serplanes.getImg());

            context.startActivity(intent);
        }

        private void iniciarsesion() {
            //ViewHolder viewHolder2=null;
            try{
                String url = "http://192.168.43.73/sesion/planesseervicios.php?id_planes=" + id.getText().toString();
                jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
                rq.add(jrq);
            }
            catch (Exception e){

            }
        }
    }

    @Override
    public int getItemCount() {
        return android.size();
    }
}




