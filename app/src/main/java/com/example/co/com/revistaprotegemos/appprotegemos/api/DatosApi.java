package com.example.co.com.revistaprotegemos.appprotegemos.api;

import com.example.co.com.revistaprotegemos.appprotegemos.models.JSONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.models.Planes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ASPIRE VX15 on 20/02/2018.
 */

public interface DatosApi {
/*    @GET("planes")
    Call<JSONResponse> getData();*/


    @GET("obtener_metas.php")
    Call<JSONResponse> getJSON();
/*Call<ArrayList<Planes>> obtenerListaPlanes();*/
}
