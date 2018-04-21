package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.api;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.ServiciosVentajasFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONResponseServicios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public interface DatossApii {


/*DataAdapter.ViewHolder d=null;
int getH=d.iniciarsesion();
int i=1;*/
ServiciosVentajasFragment s=new ServiciosVentajasFragment();

int n=2;

    @GET("/aplicacionprotegemos/webservice/servicios/serviciosventajasf.php?id_planes=")
    Call<JSONResponseServicios> getJSON(@Query("id_planes") int limit);
}
