package com.praxis.staffy.service.serviceNotification;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiNotification {
    public ServicesNotification servicesNotification;

    public void initNotification()
    {
        Retrofit.Builder builder=new Retrofit.
                Builder().
                baseUrl(ManagementUrlWebServices.getUrl_web_services()).
                addConverterFactory(GsonConverterFactory.create());

        servicesNotification=builder.build().
                create(ServicesNotification.class);


    }
}
