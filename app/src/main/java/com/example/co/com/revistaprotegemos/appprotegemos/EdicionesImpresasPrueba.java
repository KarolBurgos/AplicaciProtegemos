package com.example.co.com.revistaprotegemos.appprotegemos;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.co.com.revistaprotegemos.appprotegemos.EdicionesImpresas.models.DataAdapterEdicionesImpresas;
import com.example.co.com.revistaprotegemos.appprotegemos.EdicionesImpresas.models.Ediciones;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EdicionesImpresasPrueba extends Fragment {

    private FragmentActivity myContext;
    private RecyclerView listado;
    public EdicionesImpresasPrueba() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ediciones_impresas_prueba, container, false);

        listado = (RecyclerView)view.findViewById(R.id.recyediimpre);
        List<Ediciones> equipos = new ArrayList<Ediciones>();

        equipos.add(new Ediciones(getResources().getString(R.string.id1), getResources().getString(R.string.titulo1)));
        equipos.add(new Ediciones(getResources().getString(R.string.id2),getResources().getString(R.string.titulo2)));
        equipos.add(new Ediciones(getResources().getString(R.string.id3), getResources().getString(R.string.titulo3)));
        equipos.add(new Ediciones(getResources().getString(R.string.id4), getResources().getString(R.string.titulo4)));
        equipos.add(new Ediciones(getResources().getString(R.string.id5), getResources().getString(R.string.titulo5)));
        equipos.add(new Ediciones(getResources().getString(R.string.id6), getResources().getString(R.string.titulo6)));
        equipos.add(new Ediciones(getResources().getString(R.string.id7), getResources().getString(R.string.titulo7)));
        equipos.add(new Ediciones(getResources().getString(R.string.id8),getResources().getString(R.string.titulo8)));
        equipos.add(new Ediciones(getResources().getString(R.string.id9), getResources().getString(R.string.titulo9)));
        equipos.add(new Ediciones(getResources().getString(R.string.id10), getResources().getString(R.string.titulo10)));
        equipos.add(new Ediciones(getResources().getString(R.string.id11), getResources().getString(R.string.titulo11)));
        equipos.add(new Ediciones(getResources().getString(R.string.id12), getResources().getString(R.string.titulo12)));
        equipos.add(new Ediciones(getResources().getString(R.string.id13), getResources().getString(R.string.titulo13)));
        equipos.add(new Ediciones(getResources().getString(R.string.id14),getResources().getString(R.string.titulo14)));

        listado.setLayoutManager(new LinearLayoutManager(myContext,LinearLayoutManager.VERTICAL,false));
        listado.addItemDecoration(new DividerItemDecoration(myContext,DividerItemDecoration.VERTICAL));

        listado.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        listado.setLayoutManager(layoutManager);
        DataAdapterEdicionesImpresas adapter = new DataAdapterEdicionesImpresas(equipos,myContext);
        listado.setAdapter(adapter);
        return view;
    }


}
