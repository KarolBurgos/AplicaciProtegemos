package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosVentajasFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;

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
    private FragmentActivity myContext;
    private AdapterView.OnItemClickListener escucha;

    public DataAdapter(ArrayList<Planes> android, Context context,FragmentActivity f) {
        this.android = android;
        this.context = context;
        this.escucha = escucha;
        this.myContext=f;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tit, descr, id, leer;
        public ImageView img;
        RequestQueue rq;
        JsonRequest jrq;

/*

        public String getId_P() {
            return id_P;
        }

        public void setId_P(String id_P) {
            this.id_P = id_P;
        }*/

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.fotico);
            tit = (TextView) view.findViewById(R.id.tv_name);
            descr = (TextView) view.findViewById(R.id.tv_version);
            id = (TextView) view.findViewById(R.id.idpla);
            leer = (TextView) view.findViewById(R.id.leer);


            leer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Fragment fragment = null;

                    Class fragmentClass = ServiciosVentajasFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();

                }
            });

        }

        @Override
        public void onClick(View view) {
        }


/*

        public String getId_P() {
            return id_P;
        }

        public void setId_P(String id_P) {
            this.id_P = id_P;
        }*/

        public int iniciarsesion()
        {
            String id_P=id.getText().toString();
            int f=Integer.parseInt(id_P);
            return f;
        }
    }

    @Override
    public int getItemCount() {
        return android.size();
    }


}




