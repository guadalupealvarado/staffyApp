package com.praxis.staffy.service.servicesClient.updateDetailsClient;

import com.praxis.staffy.model.DTO.generigGetResponse.GetGeneriResponse;
import com.praxis.staffy.model.setPojoServices.updateClient.setClientsUpdate;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ServicesUpdateClient
{
    @PUT("cliente/modificar/{id_client}")
    Call<GetGeneriResponse> updateClient(@Path(value = "id_client", encoded = true) String url, @Body setClientsUpdate setClientsUpdate);
}
