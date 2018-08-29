package com.praxis.staffy.service.servicesClient;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiClient {

    public  ServicesClient servicesClient;
    public void  initClient()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        servicesClient=builder.build().create(ServicesClient.class);

    }


}
