package com.praxis.staffy.service.serviceInfoPurse;

import com.praxis.staffy.model.DTO.ListPurse;
import com.praxis.staffy.model.DTO.listInfoPurse;
import com.praxis.staffy.model.setPojoServices.setInfoPurse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceInfoPurse {
    @Headers({"Content-Type: application/json", "charset: UTF-8"})
    @POST("recurso/obtenerUnoPorId")
    Call<listInfoPurse> showInfoPurse(@Body setInfoPurse setInfo);
}
