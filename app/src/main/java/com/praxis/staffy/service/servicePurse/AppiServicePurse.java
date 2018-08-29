package com.praxis.staffy.service.servicePurse;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiServicePurse {
    public ServicesPurse servicesPurse;

    public void initApiServices()
    {
        Retrofit.Builder builder=
                new Retrofit.Builder()
                .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());

        servicesPurse=builder.build().create(ServicesPurse.class);
    }
}
