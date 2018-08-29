package com.praxis.staffy.service.servicesClient;

import com.praxis.staffy.model.DTO.ListClient;

import retrofit2.Call;
import retrofit2.http.POST;

/**Clase que funciona como puente */
public interface ServicesClient {
    @POST("cliente/obtenerTodos")
    Call<ListClient> getAllClient();
}
