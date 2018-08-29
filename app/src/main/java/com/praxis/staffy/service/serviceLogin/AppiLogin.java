package com.praxis.staffy.service.serviceLogin;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  AppiLogin {
   public  ServicesLoginI servicesLoginI;

    public  void initApiservices()
    {
        Retrofit.Builder apiLogin=
                new Retrofit.Builder().
                        baseUrl(ManagementUrlWebServices.getUrl_web_services()).
                        addConverterFactory(GsonConverterFactory.create());

        servicesLoginI=apiLogin.build().create(ServicesLoginI.class);
    }
}
