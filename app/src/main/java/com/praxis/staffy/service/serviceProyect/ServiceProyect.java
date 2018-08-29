package com.praxis.staffy.service.serviceProyect;

import com.praxis.staffy.model.DTO.ListProyect;

import retrofit2.Call;

public interface ServiceProyect {
    Call<ListProyect> getAllProyect();

}
