package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2.DatosApii;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.DataAdapterr;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2.DatosApiii;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.DataaAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSOONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.Jornadas;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ArrayList<Pautas> data;
    private ArrayList<Jornadas> data2;
    private DataAdapterr adapter;
    private DataaAdapter adapter2;
    private ImageView imagen1,img2;
    private TextView t1,t2;
    private FragmentActivity myContext;
    private Button b1;
    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerVieww);
        recyclerView.setHasFixedSize(true);
       GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
     /*   RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);*/
        //imagen1 = (ImageView)getView().findViewById(R.id.imagen1);
        //imagen1.setImageResource(R.drawable.imgd);
        loadJSONn();

        recyclerView2 = (RecyclerView)view.findViewById(R.id.recyclerVieew);
        recyclerView2.setHasFixedSize(true);
        /*RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView2.setLayoutManager(layoutManager2);*/
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView2.setLayoutManager(gridLayoutManager2);
        loadJSON();

        t1 = (TextView) view.findViewById(R.id.txtvisita);
        t1.setText(getText(R.string.mi_mensaje));

        //t2 = (TextView) view.findViewById(R.id.txquienes);

/*        TransitionDrawable td = new TransitionDrawable( new Drawable[] {
                getResources().getDrawables(mImages[x]), //Imagen 1
                getResources().getDrawables(mImages[y]) //Imagen 2
        });
        img2.setImageDrawable(td);
        td.startTransition(1000);
        // and
        td.reverseTransition(1000);*/

/*        BitmapDrawable bitmapDrawable = new BitmapDrawable(img2.getResources(), bitmap);
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{img2.getDrawable(), bitmapDrawable});
        img2.setImageDrawable(transitionDrawable);
        transitionDrawable.startTransition(300);*/

        Drawable backgrounds[] = new Drawable[3];
        Resources res = getResources();
        backgrounds[0] = res.getDrawable(R.drawable.inu);
        backgrounds[1] = res.getDrawable(R.drawable.pro);
        backgrounds[2] = res.getDrawable(R.drawable.imgd);


        TransitionDrawable crossfader = new TransitionDrawable(backgrounds);

        ImageView image = (ImageView)view.findViewById(R.id.img1);
        image.setImageDrawable(crossfader);
        crossfader.startTransition(8000);

        crossfader.reverseTransition(8000);



        Drawable backgrounds2[] = new Drawable[5];
        Resources res2 = getResources();
        backgrounds2[0] = res2.getDrawable(R.drawable.pplatino);
        backgrounds2[1] = res2.getDrawable(R.drawable.pvip);
        backgrounds2[2] = res2.getDrawable(R.drawable.pfallecimiento);
        backgrounds2[3] = res2.getDrawable(R.drawable.pfamiliar);
        backgrounds2[4] = res2.getDrawable(R.drawable.punipersonal);


        TransitionDrawable crossfader2 = new TransitionDrawable(backgrounds2);

        ImageView image2 = (ImageView)view.findViewById(R.id.imageView7);
        image2.setImageDrawable(crossfader2);
        crossfader2.startTransition(6000);

        crossfader2.reverseTransition(3000);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApii request = retrofit.create(DatosApii.class);
        Call<JSONResponsee> call = request.getJSON();
        call.enqueue(new Callback<JSONResponsee>() {
            @Override
            public void onResponse(Call<JSONResponsee> call, Response<JSONResponsee> response) {

                JSONResponsee jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapterr(data,getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponsee> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void loadJSONn(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.17")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApiii request = retrofit.create(DatosApiii.class);
        Call<JSOONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSOONResponse>() {
            @Override
            public void onResponse(Call<JSOONResponse> call, Response<JSOONResponse> response) {

                JSOONResponse jsonResponse = response.body();
                data2 = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter2 = new DataaAdapter(data2,getContext());
                recyclerView2.setAdapter(adapter2);
            }

            @Override
            public void onFailure(Call<JSOONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

}
