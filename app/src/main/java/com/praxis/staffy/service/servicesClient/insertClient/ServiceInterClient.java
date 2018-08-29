package com.praxis.staffy.service.servicesClient.insertClient;

import com.praxis.staffy.model.setPojoServices.SetClient;
import com.praxis.staffy.model.setPojoServices.SetUserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceInterClient {

    @POST("cliente/agregar")
    Call<GetPojoInsertClient> insertClientServices(@Body SetClient setUserModel);

}
