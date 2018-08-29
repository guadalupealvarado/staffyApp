package com.praxis.staffy.service.perfil.getAllPerfil;

import com.praxis.staffy.model.DTO.ListAllProfile;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicesGetAllPerfil
{
    @GET("Profile/obtenerTodos")
    Call<ListAllProfile> getAllProfile();
}
