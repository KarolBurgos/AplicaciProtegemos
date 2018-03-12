package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.DataAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;
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
    public DataAdapterservicios(ArrayList<Servicios> android) {
        this.android = android;
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
        public ViewHolder(View view) {
            super(view);

            nombre = (TextView)view.findViewById(R.id.titservc);
            desc = (TextView)view.findViewById(R.id.tvdes);
        }
    }
}
