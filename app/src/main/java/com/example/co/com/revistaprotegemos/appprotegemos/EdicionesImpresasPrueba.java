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

import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.models.Impresas;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.models.ImpresasAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.modelsDigitales.Digitales;
import com.example.co.com.revistaprotegemos.appprotegemos.AdaptadoresRevistas.modelsDigitales.DigitalesAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EdicionesImpresasPrueba extends Fragment {

    private FragmentActivity myContext;
    private RecyclerView listadoedimpresas,listadoeddigitales;
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

        listadoedimpresas = (RecyclerView)view.findViewById(R.id.recyediimpre);
        listadoeddigitales = (RecyclerView)view.findViewById(R.id.recydigitales);
        List<Impresas> impr = new ArrayList<Impresas>();

        //LISTADO DE REVISTAS IMPRESAS
        impr.add(new Impresas(getResources().getString(R.string.id15), getResources().getString(R.string.titulo15)));
        impr.add(new Impresas(getResources().getString(R.string.id14),getResources().getString(R.string.titulo14)));
        impr.add(new Impresas(getResources().getString(R.string.id13), getResources().getString(R.string.titulo13)));
        impr.add(new Impresas(getResources().getString(R.string.id12), getResources().getString(R.string.titulo12)));
        impr.add(new Impresas(getResources().getString(R.string.id11), getResources().getString(R.string.titulo11)));
        impr.add(new Impresas(getResources().getString(R.string.id10), getResources().getString(R.string.titulo10)));
        impr.add(new Impresas(getResources().getString(R.string.id8),getResources().getString(R.string.titulo8)));
        impr.add(new Impresas(getResources().getString(R.string.id7), getResources().getString(R.string.titulo7)));
        impr.add(new Impresas(getResources().getString(R.string.id6), getResources().getString(R.string.titulo6)));
        impr.add(new Impresas(getResources().getString(R.string.id5), getResources().getString(R.string.titulo5)));
        impr.add(new Impresas(getResources().getString(R.string.id4), getResources().getString(R.string.titulo4)));
        impr.add(new Impresas(getResources().getString(R.string.id3),getResources().getString(R.string.titulo3)));
        impr.add(new Impresas(getResources().getString(R.string.id2),getResources().getString(R.string.titulo2)));
        impr.add(new Impresas(getResources().getString(R.string.id1), getResources().getString(R.string.titulo1)));

        listadoedimpresas.setLayoutManager(new LinearLayoutManager(myContext,LinearLayoutManager.VERTICAL,false));
        listadoedimpresas.addItemDecoration(new DividerItemDecoration(myContext,DividerItemDecoration.VERTICAL));

        listadoedimpresas.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        listadoedimpresas.setLayoutManager(layoutManager);
        ImpresasAdapter adapter = new ImpresasAdapter(impr,myContext);
        listadoedimpresas.setAdapter(adapter);



        List<Digitales> lista2 = new ArrayList<Digitales>();

        //LISTADO DE REVISTAS DIGITALES
        lista2.add(new Digitales(getResources().getString(R.string.d7), getResources().getString(R.string.titu7)));
        lista2.add(new Digitales(getResources().getString(R.string.d6), getResources().getString(R.string.titu6)));
        lista2.add(new Digitales(getResources().getString(R.string.d5), getResources().getString(R.string.titu5)));
        lista2.add(new Digitales(getResources().getString(R.string.d4), getResources().getString(R.string.titu4)));
        lista2.add(new Digitales(getResources().getString(R.string.d3), getResources().getString(R.string.titu3)));
        lista2.add(new Digitales(getResources().getString(R.string.d2),getResources().getString(R.string.titu2)));
        lista2.add(new Digitales(getResources().getString(R.string.d1), getResources().getString(R.string.titu1)));

        listadoeddigitales.setLayoutManager(new LinearLayoutManager(myContext,LinearLayoutManager.VERTICAL,false));
        listadoeddigitales.addItemDecoration(new DividerItemDecoration(myContext,DividerItemDecoration.VERTICAL));

        listadoeddigitales.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        listadoeddigitales.setLayoutManager(layoutManager2);
        DigitalesAdapter adapter2 = new DigitalesAdapter(lista2,myContext);
        listadoeddigitales.setAdapter(adapter2);
        return view;
    }


}
