package com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2;

import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSONJornadas;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 5/03/2018.
 */

public interface ApiJornadas {
    @GET("/webservice/jornadas/obtener_jornadas.php")
    Call<JSONJornadas> getJSON();
}
