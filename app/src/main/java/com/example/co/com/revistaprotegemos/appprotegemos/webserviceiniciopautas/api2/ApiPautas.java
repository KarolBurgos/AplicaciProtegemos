package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONPautas;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 18/05/2018.
 */

public interface ApiPautas {
    @GET("/webservice/pautas/obtener_metass.php")
    Call<JSONPautas> getJSON();
}
