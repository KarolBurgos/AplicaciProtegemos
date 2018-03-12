package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.api;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 20/02/2018.
 */

public interface DatosApi {
    @GET("/webser.php")
    Call<JSONResponse> getJSON();
}
