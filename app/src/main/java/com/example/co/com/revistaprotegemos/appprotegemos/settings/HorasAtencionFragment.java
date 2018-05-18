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


    public HorasAtencionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_horas_atencion, container, false);
        return view;
    }

}