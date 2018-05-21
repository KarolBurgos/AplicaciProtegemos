package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsImpresas;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.R;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 20/05/2018.
 */

public class AdapterDigitalesPrueba extends RecyclerView.Adapter<AdapterDigitalesPrueba.ViewHolder>{

    private ArrayList<DigitalesPrueba> digitalesPruebas;
    private Context context;
    private FragmentActivity mycontext;

    public AdapterDigitalesPrueba(ArrayList<DigitalesPrueba> digitalesPruebas, Context context) {
        this.digitalesPruebas = digitalesPruebas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewedicionesimpresas, parent, false);
        return new AdapterDigitalesPrueba.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        DigitalesPrueba ed = digitalesPruebas.get(i);

        //holder.id.setText(ed.getidString());
        holder.des.setText(ed.getDescripcion());

        Glide.with(context)
                .load(digitalesPruebas.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img);
}

    @Override
    public int getItemCount() {
        return digitalesPruebas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tit,id;
        TextView des;
        ImageView img;
        Button b1;
        RequestQueue rq;
        JsonRequest jrq;
        public ViewHolder(View itemView) {
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.descripcions);
            des = (TextView)itemView.findViewById(R.id.ids);
            img = (ImageView)itemView.findViewById(R.id.imageView9);
            b1=(Button)itemView.findViewById(R.id.button3);

            itemView.setOnClickListener((View.OnClickListener) this);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                seleDigitales();

                }
            });
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                seleDigitales();


                }
            });
        }
        private void seleDigitales()
        {
            final String edi1 = id.getText().toString();
            int ed=Integer.parseInt(edi1);
            if(ed==1) {
                Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170630/U154892_F446303/FLASH/index.html");
                context.startActivity(myIntent);

            }
            else if(ed==2) {
                Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170630/U154892_F446305/FLASH/index.html");
                context.startActivity(myIntent);
            }

            else if(ed==3) {
                Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "data.axmag.com/data/201605/20160517/U137868_F381778/FLASH/index.html");
                context.startActivity(myIntent);
            }
            else if(ed==4) {
                Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                context.startActivity(myIntent);
            }
            else if(ed==5) {
                Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                context.startActivity(myIntent);
            }
            else if(ed==6) {
                Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "data.axmag.com/data/201605/20160517/U137868_F381781/FLASH/index.html");
                context.startActivity(myIntent);
            }
        }

        @Override
        public void onClick(View view) {

        }
    }
}
