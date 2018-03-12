package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.Jornadas;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */

public class DataAdapterr  extends RecyclerView.Adapter<DataAdapterr.ViewHolder>{
    private ArrayList<Pautas> android;
    private Context context;
    public DataAdapterr(ArrayList<Pautas> android, Context context) {
        this.android = android;
        this.context = context;
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
        private TextView tit,descr;
        private ImageView img;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView)view.findViewById(R.id.imageView6);
            tit = (TextView)view.findViewById(R.id.tv_namee);
            descr = (TextView)view.findViewById(R.id.tv_versionn);

        }
    }
}
