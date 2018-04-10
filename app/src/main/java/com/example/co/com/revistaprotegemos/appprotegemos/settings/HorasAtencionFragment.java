package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorasAtencionFragment extends Fragment {

    private Typeface Ofaly,Color;
    TextView sedes,horario;
    public HorasAtencionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_horas_atencion, container, false);
        String fuente3 ="fuentes/Abril.otf";
        this.Ofaly =Typeface.createFromAsset(getContext().getAssets(),fuente3);

        sedes=(TextView)view.findViewById(R.id.textView23);
        sedes.setTypeface(Ofaly);

        horario=(TextView)view.findViewById(R.id.textView33);
        horario.setTypeface(Ofaly);
        return view;
    }

}