package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.co.com.revistaprotegemos.appprotegemos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuscritosFragment extends Fragment {

    Spinner spinner;
    String[] items;
    private boolean isFirstTime=true;
    public SuscritosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_suscritos, container, false);

        spinner = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.opciones,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

       /* items=getResources().getStringArray(R.array.opciones);
        //String[] valores = {"uno","dos","tres","cuatro","cinco","seis", "siete", "ocho"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (isFirstTime)
                {
                    isFirstTime=false;
                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(),items[i],Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        return view;

    }

}
