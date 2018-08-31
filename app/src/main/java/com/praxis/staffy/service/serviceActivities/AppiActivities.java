package com.praxis.staffy.service.serviceActivities;


import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiActivities {
    public ServicesActivities servicesActivities;

    public void initActivities()
    {
        Retrofit.Builder builder=new Retrofit.
                Builder().
                baseUrl(ManagementUrlWebServices.getUrl_web_services()).
                addConverterFactory(GsonConverterFactory.create());

        servicesActivities=builder.build().
                create(ServicesActivities.class);


    }
}
