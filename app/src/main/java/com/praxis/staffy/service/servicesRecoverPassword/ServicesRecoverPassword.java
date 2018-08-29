package com.praxis.staffy.service.servicesRecoverPassword;

import com.praxis.staffy.model.DTO.ObjectRecoverPassword;
import com.praxis.staffy.model.setPojoServices.RecoverPassword.SetObjetMailRecoverPassword;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServicesRecoverPassword
{
    @POST("login/recuperarPassword")
    Call<ObjectRecoverPassword> recoverPassword(@Body SetObjetMailRecoverPassword setObjetMailRecoverPassword);

}
