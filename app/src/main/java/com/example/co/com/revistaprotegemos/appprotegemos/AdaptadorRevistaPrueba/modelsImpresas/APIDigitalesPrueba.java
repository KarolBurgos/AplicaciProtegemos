package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsImpresas;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONPlanes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 20/05/2018.
 */

public interface APIDigitalesPrueba {
    @GET("/webservice/edicionesDigitales/webser.php")
    Call<JSONDigitalesPrueba> getJSON();
}
