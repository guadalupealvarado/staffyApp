package com.praxis.staffy.service.servicesClient.getDetailsClients;

import com.praxis.staffy.model.DTO.ListGetDetailsClients;
import com.praxis.staffy.model.setPojoServices.SetDetailsClient;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServicesGetDetailsClient {
    @POST("cliente/obtenerUno/")
    Call<ListGetDetailsClients> getDetailsClients(@Body SetDetailsClient setDetailsClient);

}
