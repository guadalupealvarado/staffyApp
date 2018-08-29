package com.praxis.staffy.service.serviceLogin;

import com.praxis.staffy.model.DTO.ListUser;
import com.praxis.staffy.model.setPojoServices.SetUserModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ServicesLoginI {
    @POST("Login/ingresar")
    Call<ListUser> getPostUser(@Body SetUserModel setDUser);
}
