package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales;

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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.MainActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.inicioappSplash.SplashScreen;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ASPIRE VX15 on 20/05/2018.
 */

public class AdapterImpresasPrueba extends RecyclerView.Adapter<AdapterImpresasPrueba.ViewHolder>
{
    private ArrayList<ImpresasPrueba> impresasPruebas;
    private Context context;
    private FragmentActivity mycontext;

    public AdapterImpresasPrueba(ArrayList<ImpresasPrueba> impresasPruebas, Context context) {
        this.impresasPruebas = impresasPruebas;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewedicionesimpresas, parent, false);
        return new AdapterImpresasPrueba.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        ImpresasPrueba ed = impresasPruebas.get(i);
        viewHolder.id.setText(ed.getidString());
        viewHolder.des.setText(ed.getDescripcion());

        Glide.with(context)
                .load(impresasPruebas.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return impresasPruebas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

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
                    revistasId();

                }
            });
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    revistasId();

                }
            });
        }

        public void revistasId()
        {
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

        private void BuscarRevistaId() {
            //ViewHolder viewHolder2=null;
            String url = "http://192.168.43.73/webservice/impresasid/impresasid.php?id_impresas=" + id.getText().toString();
            jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            rq.add(jrq);
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public void onErrorResponse(VolleyError error) {

        }

        @Override
        public void onResponse(JSONObject response) {

        }
    }
}
