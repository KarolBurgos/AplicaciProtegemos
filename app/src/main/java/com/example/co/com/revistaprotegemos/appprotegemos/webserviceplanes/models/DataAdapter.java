package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import com.example.co.com.revistaprotegemos.appprotegemos.ExpandAndCollapseViewUtil;
import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosLeermas;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosVentajasFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.Servicios;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static javax.xml.datatype.DatatypeConstants.DURATION;

/**
 * Created by ASPIRE VX15 on 21/02/2018.
 */

public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder > {
    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;

    private ArrayList<Planes> android;
    private Context context;
    private List<String> countries;
    private FragmentActivity myContext;
    private AdapterView.OnItemClickListener escucha;

    public DataAdapter(ArrayList<Planes> android, Context context,FragmentActivity f) {
        this.android = android;
        this.context = context;
        this.escucha = escucha;
        this.myContext=f;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);

        return new DataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tit.setText(android.get(i).getTitulo());
        viewHolder.descr.setText(android.get(i).getDescripcion());
        viewHolder.id.setText(android.get(i).getidString());
        Glide.with(context)
                .load(android.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.img);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

        public TextView tit, descr, id, leer;
        public ImageView img;
        RequestQueue rq;
        JsonRequest jrq;
        private Typeface Ofaly,Color;
        TextView titu;
        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.fotico);
            tit = (TextView) view.findViewById(R.id.txt2);
            descr = (TextView) view.findViewById(R.id.tv_version);
            id = (TextView) view.findViewById(R.id.idpla);
            leer = (TextView) view.findViewById(R.id.leer);
            rq = Volley.newRequestQueue(context);

/*            linearLayoutDetails = (ViewGroup) view.findViewById(R.id.linearLayoutDetails);
            imageViewExpand = (ImageView) view.findViewById(R.id.imageViewExpand);*/

            leer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Fragment fragment = null;

                    Class fragmentClass = ServiciosVentajasFragment.class;
                    try {
                        fragment = (Fragment) fragmentClass.newInstance();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager = myContext.getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();



                }
            });

            String fuente3 ="fuentes/April.ttf";
            this.Ofaly =Typeface.createFromAsset(context.getAssets(),fuente3);

            titu=(TextView)view.findViewById(R.id.txt2);
            titu.setTypeface(Ofaly);

            String fuente ="fuentes/Nuestrosplanes.ttf";
            this.Color =Typeface.createFromAsset(context.getAssets(),fuente);

            titu=(TextView)view.findViewById(R.id.tv_version);
            titu.setTypeface(Color);



        }

        @Override
        public void onClick(View view) {
        }

        public String iniciarsesion()
        {
            String id_P=id.getText().toString();

            return id_P;
        }

        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(context, "No se encontro el usuario" + error.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResponse(JSONObject response) {
            Servicios servicios = new Servicios();
            JSONArray jsonArray = response.optJSONArray("datos");
            JSONObject jsonObject = null;

            try {
                jsonObject = jsonArray.getJSONObject(0);
                servicios.setTitulo(jsonObject.optString("titulo"));
                servicios.setDescripcion(jsonObject.optString("descripcion"));
                servicios.setImg(jsonObject.optString("img"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Intent intent = new Intent(context, ServiciosLeermas.class);
            intent.putExtra(ServiciosLeermas.titu, servicios.getTitulo());
            intent.putExtra(ServiciosLeermas.des, servicios.getDescripcion());
            intent.putExtra(ServiciosLeermas.im, servicios.getImg());

            context.startActivity(intent);
        }

        private void iniciarsesin() {
            //ViewHolder viewHolder2=null;
            String url = "http://192.168.43.73/sesion/planesseervicios.php?id_planes=";
            jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            rq.add(jrq);
        }
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

public  String it()
    {
        String t;
        View view = null;
        ViewHolder v= new ViewHolder(view);
        t = v.iniciarsesion();
        return t;
    }

    public void setcountries(List<String> countries)
    {
        this.countries=countries;
        notifyDataSetChanged();
    }

/*
    public void toggleDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.ic_launcher);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.ic_launcher);
            rotate(180.0f);
        }
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }
*/

}




