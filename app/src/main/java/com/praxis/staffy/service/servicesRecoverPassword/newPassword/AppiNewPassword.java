package com.praxis.staffy.service.servicesRecoverPassword.newPassword;

import com.praxis.staffy.service.servicesRecoverPassword.ServicesRecoverPassword;
import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiNewPassword
{
    public ServicesNewPassword servicesNewPassword;
    public void initAppiNewPassword()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        servicesNewPassword=builder.build().create(ServicesNewPassword.class);
    }
}
