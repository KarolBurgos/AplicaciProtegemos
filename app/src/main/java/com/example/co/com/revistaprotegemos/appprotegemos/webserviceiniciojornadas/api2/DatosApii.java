package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.api2;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciojornadas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */

public interface DatosApii {
    @GET("/webservice_inicio/obtener_metass.php")
    Call<JSONResponsee> getJSON();
}
