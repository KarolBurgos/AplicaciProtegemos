package com.example.co.com.revistaprotegemos.appprotegemos.settings;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co.com.revistaprotegemos.appprotegemos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NuestraEmpresaFragment extends Fragment {


    public NuestraEmpresaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuestra_empresa, container, false);
    }

}
