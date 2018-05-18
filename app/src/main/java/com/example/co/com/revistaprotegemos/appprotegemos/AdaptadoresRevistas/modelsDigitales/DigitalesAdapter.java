package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.modelsDigitales;

import android.content.Context;
import android.content.Intent;
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
 * Created by ASPIRE VX15 on 11/05/2018.
 */

public class DigitalesAdapter extends RecyclerView.Adapter<DigitalesAdapter.ViewHolder>
{

    List<Digitales> digitales;
    private Context context;

    public DigitalesAdapter(List<Digitales> digitales, Context context) {
        this.digitales = digitales;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewedicionesimpresas, parent, false);
        return new DigitalesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Digitales ed = digitales.get(i);

        holder.id.setText(ed.getId());
        holder.des.setText(ed.getDescripcion());

        final String edi1 = holder.id.getText().toString();
        int edd1=Integer.parseInt(edi1);
        if(edd1==1)
        {
            String url="http://www.revistaprotegemos.com.co/imagenesaplicativo/EdicionPapa1.png";
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
            holder.b1.setText("Ver Online");
            holder.b1.setVisibility(View.VISIBLE);
        }
        else if(edd1==2)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/EdicionPapa2.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==3)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/EdicionPapa3.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==4)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/EdicionManualidades1.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==5)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/EdicionManualidades2.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }
        else if(edd1==6)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/EdicionManualidades3.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);

        }

        else if(edd1==7)
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/t1.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
            holder.b1.setText("Ver más");
            holder.b1.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return digitales.size();
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
