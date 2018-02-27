package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.models2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */

public class DataAdapterr  extends RecyclerView.Adapter<DataAdapterr.ViewHolder>{
    private ArrayList<Pautas> android;
    public DataAdapterr(ArrayList<Pautas> android) {
        this.android = android;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rowjornads, viewGroup, false);
        return new DataAdapterr.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapterr.ViewHolder viewHolder, int i) {
        viewHolder.tit.setText(android.get(i).getLugar());
        viewHolder.descr.setText(android.get(i).getDescripcion());
    }


    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tit,descr;
        public ViewHolder(View view) {
            super(view);

            tit = (TextView)view.findViewById(R.id.tv_namee);
            descr = (TextView)view.findViewById(R.id.tv_versionn);

        }
    }
}
