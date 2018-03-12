package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosVentajasFragment;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 21/02/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


 private ArrayList<Planes> android;
    private Context context;
    private FragmentActivity myContext;

    private ImageLoader imageLoader;
    public TextView tx;
    private ImageView img2;
    public DataAdapter(ArrayList<Planes> android, Context context) {
        this.android = android;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

/*      viewHolder.nombre.setText(android.get(i).getTitulo());
        viewHolder.desc.setText(android.get(i).getDescripcion());*/
        ImageView imgpro;
        Planes pr = android.get(i);
        viewHolder.nombre.setText(android.get(i).getTitulo());
        viewHolder.desc.setText(android.get(i).getDescripcion());
        viewHolder.edPart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Hola",Toast.LENGTH_LONG).show();
                /*ServiciosVentajasFragment serFra = new ServiciosVentajasFragment();
                FragmentTransaction fragTran = null;
                fragTran.add(serFra,"Frag");
                fragTran.commit();*/
            }
        });

        Glide.with(context)
                .load(android.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.img);

    }
    public DataAdapter(Context context)
    {
        this.context=context;
        android=new ArrayList<>();
    }


    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre,desc,tv_api_level,titulo,edPart;
        private Button butonserivicios;
        private  ImageView img;
        TextView leer;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView)view.findViewById(R.id.fotico);
            nombre = (TextView)view.findViewById(R.id.tv_name);
            desc = (TextView)view.findViewById(R.id.tv_version);
            leer = (TextView) view.findViewById(R.id.leermas1);
            edPart = (TextView) view.findViewById(R.id.ed_particular);

        }
    }
}
