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
        holder.img.setImageResource(ed.getImg());

        if(holder.id.equals("1"))
        {
            String url="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion1.png";
            Glide.with(context)
                    .load(url)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
            holder.img.setImageResource(ed.getImg());
        }
        else if(holder.id.equals("2"))
        {
            String url2="http://www.revistaprotegemos.com.co/imagenesaplicativo/Edicion2.png";
            Glide.with(context)
                    .load(url2)
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img);
            holder.img.setImageResource(ed.getImg());
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
            id = (TextView)itemView.findViewById(R.id.ids);
            des = (TextView)itemView.findViewById(R.id.descripcions);
            img = (ImageView)itemView.findViewById(R.id.imageView9);
            b1=(Button)itemView.findViewById(R.id.button3);

            itemView.setOnClickListener((View.OnClickListener) this);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String edi1 = id.getText().toString();
                    int ed=Integer.parseInt(edi1);
                    if(ed==1) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443501/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==2) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443495/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }

                    else if(ed==3) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443502/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==4) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443498/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==5) {
                        Uri uri = Uri.parse("https://cdn.flipsnack.com/widget/v2/flipsnackwidget.html?hash=fdnqt6v4i&bgcolor=EEEEEE&t=1501278660");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==6) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150729/U137868_F347338/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==7) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150729/U137868_F347294/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==8) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150729/U137868_F347341/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==9) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443515/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==10) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201507/20150727/U137868_F347002/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==11) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201705/20170526/U154892_F441324/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==12) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201605/20160517/U137868_F381774/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    else if(ed==13) {
                        Uri uri = Uri.parse("http://data.axmag.com/data/201706/20170615/U154892_F443505/FLASH/index.html");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }

                }
            });

        }
        @Override
        public void onClick(View view) {

        }


    }
}
