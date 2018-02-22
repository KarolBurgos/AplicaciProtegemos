package com.example.co.com.revistaprotegemos.appprotegemos.models;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 21/02/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private ArrayList<Planes> android;
    public DataAdapter(ArrayList<Planes> data) {
        this.android = android;
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tv_titulo.setText(android.get(i).getTitulo());
        viewHolder.tv_descripcion.setText(android.get(i).getDescripcion());
        viewHolder.tv_img.setImageDrawable(Drawable.createFromPath(android.get(i).getImg()));
    }

    @Override
    public int getItemCount() {
        return android.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_titulo,tv_descripcion;
        private ImageView tv_img;
        public ViewHolder(View view) {
            super(view);

            tv_titulo = (TextView)view.findViewById(R.id.ed_titulo);
            tv_descripcion= (TextView)view.findViewById(R.id.ed_descr);
            tv_img = (ImageView) view.findViewById(R.id.ed_img);

        }
    }
}
