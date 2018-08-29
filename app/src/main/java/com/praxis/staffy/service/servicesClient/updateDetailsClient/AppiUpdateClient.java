package com.praxis.staffy.service.servicesClient.updateDetailsClient;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiUpdateClient {
    public ServicesUpdateClient servicesUpdateClient;
    public void initUpdateClient()
    {
        Retrofit.Builder builder=new Retrofit.Builder().
                baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        servicesUpdateClient=builder.build().create(ServicesUpdateClient.class);
    }
}
