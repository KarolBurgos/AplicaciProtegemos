package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public class DataAdapterservicios extends RecyclerView.Adapter<DataAdapterservicios.ViewHolder>{
    private ArrayList<Servicios> android;
    private Context context;
    private ImageLoader imageLoader;
    private ImageView img2;
    public DataAdapterservicios(ArrayList<Servicios> android, Context context) {
        this.android = android;
        this.context = context;
    }

    @Override
    public DataAdapterservicios.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row_servicios, viewGroup, false);
        return new DataAdapterservicios.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(android.get(position).getTitulo());
        holder.desc.setText(android.get(position).getDescripcion());
        Glide.with(context)
                .load(android.get(position).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);
    }

    public DataAdapterservicios(Context context)
    {
        this.context=context;
        android=new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,desc,tv_api_level,titulo;
        private  ImageView img;

        private Typeface Ofaly,Color;
        public ViewHolder(View view) {
            super(view);

            nombre = (TextView)view.findViewById(R.id.tit);
            desc = (TextView)view.findViewById(R.id.tvdes);
            img=(ImageView)view.findViewById(R.id.fotoopro);

            String fuente ="fuentes/Dehasta Momentos Regular.otf";
            this.Color = Typeface.createFromAsset(context.getAssets(),fuente);

            nombre.setTypeface(Color);
            desc.setTypeface(Color);
        }

        
    }
}
