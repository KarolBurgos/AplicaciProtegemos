package com.example.co.com.revistaprotegemos.appprotegemos.MapaProtegemos;

import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ASPIRE VX15 on 17/05/2018.
 */

public interface RutaGoogleMaps {
    @GET("json")
    Call<ResponseBody> obtenerRegistro(@Query("origin") String origin,
                                         @Query("destination") String destination,
                                         @Query("language") String language,
                                         @Query("units") String units,
                                         @Query("key") String key);
}
