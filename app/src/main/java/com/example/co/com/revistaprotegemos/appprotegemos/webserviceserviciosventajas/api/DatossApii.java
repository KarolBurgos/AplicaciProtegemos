package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.api;

import android.view.View;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.DataAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONResponseServicios;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public interface DatossApii {


DataAdapter.ViewHolder d=null;
int i=d.iniciarsesion();
int getH=1;
    @GET("/serviciosventajasf.php?id_planes="+getH)
    Call<JSONResponseServicios> getJSON();
}
