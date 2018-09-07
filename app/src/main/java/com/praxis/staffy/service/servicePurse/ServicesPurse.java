package com.praxis.staffy.service.servicePurse;

import com.praxis.staffy.model.DTO.ListPurse;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ServicesPurse {

    @POST("recurso/obtenerTodos")
    Call<ListPurse> showPostPurse();
}
