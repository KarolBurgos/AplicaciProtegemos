package com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSOONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 5/03/2018.
 */

public interface DatosApiii {
    @GET("/webservice/jornadas/obtener_jornadas.php")
    Call<JSOONResponse> getJSON();
}
