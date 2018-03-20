package com.example.co.com.revistaprotegemos.appprotegemos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Home extends Fragment {


    public Fragment_Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment__home, container, false);

        String url="http://www.uniagustiniana.edu.co/";
        WebView view2=(WebView) view.findViewById(R.id.wv_home);
        view2.getSettings().setJavaScriptEnabled(true);
        view2.setWebViewClient(new WebViewClient());// Agregamos un WebViewCliente, esto permite que se sigan ejecutando los links dentro de este WebView
        view2.loadUrl(url);
        return view2;
    }

}
