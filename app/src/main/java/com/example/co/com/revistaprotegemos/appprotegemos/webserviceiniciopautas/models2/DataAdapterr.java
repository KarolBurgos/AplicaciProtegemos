package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */

public class DataAdapterr  extends RecyclerView.Adapter<DataAdapterr.ViewHolder>{

    RequestQueue rq;
    JsonRequest jrq;
    private ArrayList<Pautas> android;
    private Context context;
    public DataAdapterr(ArrayList<Pautas> android, Context context) {
        this.android = android;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rowpautas, viewGroup, false);
        rq= Volley.newRequestQueue(context);
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
    public DataAdapterr(Context context)
    {
        this.context=context;
        android=new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return android.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tit,descr,id,leer;
        private ImageView img;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView)view.findViewById(R.id.imageView6);
            tit = (TextView)view.findViewById(R.id.tv_namee);
            descr = (TextView)view.findViewById(R.id.tv_versionn);
            id=(TextView)view.findViewById(R.id.textView52);
            leer=(TextView)view.findViewById(R.id.ed_particular);
        }
    }
}
