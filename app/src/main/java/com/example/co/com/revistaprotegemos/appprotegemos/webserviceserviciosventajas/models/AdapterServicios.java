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

public class AdapterServicios extends RecyclerView.Adapter<AdapterServicios.ViewHolder>{
    private ArrayList<Servicios> servicios;
    private Context context;
    public AdapterServicios(ArrayList<Servicios> servicios, Context context) {
        this.servicios = servicios;
        this.context = context;
    }

    @Override
    public AdapterServicios.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row_servicios, viewGroup, false);
        return new AdapterServicios.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(servicios.get(position).getTitulo());
        holder.desc.setText(servicios.get(position).getDescripcion());
        Glide.with(context)
                .load(servicios.get(position).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);
    }

    public AdapterServicios(Context context)
    {
        this.context=context;
        servicios=new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return servicios.size();
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

        }

        
    }
}
