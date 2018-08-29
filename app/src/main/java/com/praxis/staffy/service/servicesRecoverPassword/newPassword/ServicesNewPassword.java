package com.praxis.staffy.service.servicesRecoverPassword.newPassword;

import com.praxis.staffy.model.DTO.restorePassword.ObjectRestorePassword;
import com.praxis.staffy.model.setPojoServices.RecoverPassword.SetObjectNewPassword;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServicesNewPassword
{
    @POST("login/reestablecerPassword")
    Call<ObjectRestorePassword> newPassword(@Body SetObjectNewPassword setObjectNewPassword);
}
