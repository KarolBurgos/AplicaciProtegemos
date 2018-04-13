package com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.api;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceserviciosventajas.models.JSONResponseServicios;
import com.example.co.com.revistaprotegemos.appprotegemos.werbserviceventajas.models.JSONResponseVentajas;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASPIRE VX15 on 13/04/2018.
 */

public interface DatosVentajas {
    @GET("/aplicacionprotegemos/webservice/servicios/ventajaswebservice.php?id_planes=")
    Call<JSONResponseVentajas> getJSON(@Query("id_planes") int limit);
}
