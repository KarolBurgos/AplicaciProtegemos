package com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models;

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

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 5/03/2018.
 */

public class JornadasAdapter extends RecyclerView.Adapter<JornadasAdapter.ViewHolder> {

    private ArrayList<Jornadas> jornadas;
    private Context context;
    public JornadasAdapter(ArrayList<Jornadas> android, Context context) {
        this.jornadas = android;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rowjornadas, viewGroup, false);
        return new JornadasAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tit.setText(jornadas.get(i).getTipojornada());
        viewHolder.descr.setText(jornadas.get(i).getDescrjornada());

        Glide.with(context)
                .load(jornadas.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.img1);
    }

    public JornadasAdapter(Context context)
    {
        this.context=context;
        jornadas=new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return jornadas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tit,descr;
        private ImageView img1;

        public ViewHolder(View view) {
            super(view);

            tit = (TextView)view.findViewById(R.id.tipoj);
            descr = (TextView)view.findViewById(R.id.describjornada);
            img1 = (ImageView) view.findViewById(R.id.imageView3);


        }
    }
}
