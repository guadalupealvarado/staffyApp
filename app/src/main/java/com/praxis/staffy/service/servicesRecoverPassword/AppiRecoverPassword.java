package com.praxis.staffy.service.servicesRecoverPassword;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiRecoverPassword {
    public ServicesRecoverPassword servicesRecoverPassword;
    public void initRecoverPassword()
    {
        Retrofit.Builder builder=new Retrofit.Builder().
                baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        servicesRecoverPassword=builder.build().create(ServicesRecoverPassword.class);
    }
}
