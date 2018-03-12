package com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.api;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONResponseServicios;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 10/03/2018.
 */

public interface DatossApii {
    @GET("/serviciosventajasf.php")
    Call<JSONResponseServicios> getJSON();
}
