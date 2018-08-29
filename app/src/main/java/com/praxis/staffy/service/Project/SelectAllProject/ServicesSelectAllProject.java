package com.praxis.staffy.service.Project.SelectAllProject;

import com.praxis.staffy.model.DTO.ListAllProject;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ServicesSelectAllProject {
    @POST("proyecto/obtenerTodos")
    Call<ListAllProject> getAllProject();
}
