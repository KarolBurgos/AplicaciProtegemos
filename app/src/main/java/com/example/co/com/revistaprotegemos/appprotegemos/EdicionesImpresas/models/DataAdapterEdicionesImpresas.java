package com.example.co.com.revistaprotegemos.appprotegemos.EdicionesImpresas.models;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewAbrirPaginasUrl;

import java.util.List;

/**
 * Created by ASPIRE VX15 on 20/04/2018.
 */

public class DataAdapterEdicionesImpresas extends RecyclerView.Adapter<DataAdapterEdicionesImpresas.ViewHolder>{
    List<Ediciones> edicio;
    private Context context;

    public DataAdapterEdicionesImpresas(List<Ediciones> edicio, Context context) {
        this.edicio = edicio;
        this.context = context;
    }

    @Override
    public DataAdapterEdicionesImpresas.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewedicionesimpresas, parent, false);
        return new DataAdapterEdicionesImpresas.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapterEdicionesImpresas.ViewHolder holder, int i) {
        Ediciones ed = edicio.get(i);

        holder.id.setText(ed.getId());
        holder.des.setText(ed.getDescripcion());

        final String edi1 = holder.id.getText().toString();
        int edd1=Integer.parseInt(edi1);
        if(edd1==1)
        {
            String url="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion1.png";
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
        }
        else if(edd1==2)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion2.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==3)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion3.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==4)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion4.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==5)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion5.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==6)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion6.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==7)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion7.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }

        else if(edd1==8)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion8.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }

        else if(edd1==9)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion9.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }

        else if(edd1==10)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion10.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==11)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion11.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==12)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion12.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==13)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion13.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==14)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion14.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
       // holder.img.setImageResource(ed.getImg());
    }


    @Override
    public int getItemCount() {
        return edicio.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tit,id;
        TextView des;
        ImageView img;
        Button b1;
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
                    final String edi1 = id.getText().toString();
                    int ed=Integer.parseInt(edi1);
                    if(ed==1) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443501/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==2) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                        context.startActivity(myIntent);
                    }

                    else if(ed==3) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443502/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==4) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443498/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==5) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "cdn.flipsnack.com/widget/v2/flipsnackwidget.html?hash=fdnqt6v4i&bgcolor=EEEEEE&t=1501278660");
                        context.startActivity(myIntent);
                    }
                    else if(ed==6) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201507/20150729/U137868_F347338/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==7) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201507/20150729/U137868_F347294/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==8) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201507/20150729/U137868_F347341/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==9) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443515/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==10) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201507/20150727/U137868_F347002/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==11) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201705/20170526/U154892_F441324/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==12) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201605/20160517/U137868_F381774/FLASH/index.html");
                        context.startActivity(myIntent);
                    }
                    else if(ed==13) {
                        Intent myIntent = new Intent(context, WebViewAbrirPaginasUrl.class);
                        myIntent.putExtra("direccion", "data.axmag.com/data/201706/20170615/U154892_F443505/FLASH/index.html");
                        context.startActivity(myIntent);
                    }

                }
            });

        }
        @Override
        public void onClick(View view) {

        }


    }
}
