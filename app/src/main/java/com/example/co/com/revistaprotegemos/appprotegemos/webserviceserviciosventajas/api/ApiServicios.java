package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.api;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONServicios;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public interface ApiServicios {

    @GET("/webservice/servicios/serviciosventajasf.php?id_planes=")
    Call<JSONServicios> getJSON(@Query("id_planes") int limit);
}
