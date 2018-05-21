package com.example.co.com.revistaprotegemos.appprotegemos.AdaptadorRevistaPrueba.modelsDigitales;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONPlanes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 20/05/2018.
 */

public interface APIImpresasPrueba {
    @GET("/webservice/edicionesImpresas/webser.php")
    Call<JSOnImpresasPrueba> getJSON();
}
