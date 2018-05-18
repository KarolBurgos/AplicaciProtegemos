package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.api;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONPlanes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 20/02/2018.
 */

public interface ApiPlanes {
    @GET("/webservice/planes/webser.php")
    Call<JSONPlanes> getJSON();
}
