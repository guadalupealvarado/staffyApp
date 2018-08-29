package com.praxis.staffy.service.servicesClient.getDetailsClients;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiGetDetailsClients {
    public ServicesGetDetailsClient servicesGetDetailsClient;
    public  void initDetailsClient()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        servicesGetDetailsClient=builder.build().create(ServicesGetDetailsClient.class);

    }
}
