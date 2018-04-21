package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PautasFragment extends Fragment {

    public static final String id_imagen="id_imagen";
    public static final String imagen="imagen";
    public static final String lugar="lugar";
    ImageView im1;
    public PautasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pautas, container, false);
        im1=(ImageView)view.findViewById(R.id.imageView4);
        String usuario=getActivity().getIntent().getStringExtra("id_imagen");
        String image=getActivity().getIntent().getStringExtra("imagen");
        String usuario2=getActivity().getIntent().getStringExtra("lugar");

        //t1.setText(""+usuario+usuario2+"");
        Glide.with(this)
                .load(image)
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(im1);
        return view;
    }

}
