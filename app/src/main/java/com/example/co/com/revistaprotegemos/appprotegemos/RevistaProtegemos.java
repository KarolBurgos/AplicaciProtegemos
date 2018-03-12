package com.example.co.com.revistaprotegemos.appprotegemos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class RevistaProtegemos extends Fragment {


    public RevistaProtegemos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_revista_protegemos, container, false);

        Button butonserivicios=(Button)view.findViewById(R.id.button2);
        butonserivicios.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //  Log.e("fdgfdfgfgfgfh--->","SI");

                AlertDialog.Builder uBuilder2 = new AlertDialog.Builder(RevistaProtegemos.super.getContext());
                View aView2 = getLayoutInflater().inflate(R.layout.fragment_servicios_ventajas, null);
                uBuilder2.setView(aView2);
                final AlertDialog dialog2 = uBuilder2.create();
                dialog2.show();
                Button close = (Button) aView2.findViewById(R.id.close);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog2.cancel();
                    }
                });

            }
        });
        return view;
    }

}
