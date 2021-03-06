package com.example.co.com.revistaprotegemos.appprotegemos.ChatProtegemos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ASPIRE VX15 on 29/04/2018.
 */

public class AdapterMensajes extends RecyclerView.Adapter<HolderMensaje>

{

    //Adaptador de mensajes para el chat en tiempo real
    List<MensajeRecibir> listMensaje = new ArrayList<>();
    private Context c;


    public AdapterMensajes(Context c) {
        this.c = c;
    }

    public void  addMensaje(MensajeRecibir m)
    {
        listMensaje.add(m);
        notifyItemInserted(listMensaje.size());
    }


    @Override
    public HolderMensaje onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.card_view_mensajes,parent,false);
        return new HolderMensaje(v);
    }

    @Override
    public void onBindViewHolder(HolderMensaje holder, int position)
    {
        holder.getNombre().setText(listMensaje.get(position).getNombre());
        holder.getMensaje().setText(listMensaje.get(position).getMensaje());
        //holder.getHora().setText(listMensaje.get(position).getHora());

        if(listMensaje.get(position).getType_mensaje().equals("2"))
        {
            holder.getFotoMensaje().setVisibility(View.VISIBLE);
            holder.getMensaje().setVisibility(View.VISIBLE);
            Glide.with(c).load(listMensaje.get(position).getUrlFoto()).into(holder.getFotoMensaje());
        } else if (listMensaje.get(position).getType_mensaje().equals("1")) {
            holder.getFotoMensaje().setVisibility(View.GONE);
        }
        if (listMensaje.get(position).getFotoPerfil().isEmpty())
        {
            holder.getFotoMensajePerfil().setImageResource(R.drawable.logo);
        }
        else
        {
            Glide.with(c).load(listMensaje.get(position).getFotoPerfil()).into(holder.getFotoMensajePerfil());
        }

        Long codigoHora=listMensaje.get(position).getHora();
        Date d= new Date(codigoHora);
        SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss a");
        holder.getHora().setText(sdf.format(d));
    }

    @Override
    public int getItemCount() {
        return listMensaje.size();
    }
}
