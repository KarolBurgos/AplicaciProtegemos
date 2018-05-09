package com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 27/02/2018.
 */

public interface DatosApii {
    @GET("/webservice/pautas/obtener_metass.php")
    Call<JSONResponsee> getJSON();
}
