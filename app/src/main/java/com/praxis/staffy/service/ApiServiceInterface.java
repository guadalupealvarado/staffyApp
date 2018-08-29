package com.praxis.staffy.service;

import com.praxis.staffy.model.BodyLogin;
import com.praxis.staffy.model.Session;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface ApiServiceInterface {
    @Headers({"Content-Type: application/json", "charset: UTF-8"})
    //Tipo de datos
    // Post envio
    //Get consulta

    @POST("security/newClient")
    Call<Session> login(@Body BodyLogin requestBody);
}
