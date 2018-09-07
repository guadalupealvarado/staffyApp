package com.praxis.staffy.service.serviceInfoPurse;

import android.app.Service;

import com.praxis.staffy.service.servicePurse.ServicesPurse;
import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceInfoPurse {
    public ServiceInfoPurse serviceInfoPurse;
    public void initApiServices()
    {
        Retrofit.Builder builder=
                new Retrofit.Builder()
                        .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                        .addConverterFactory(GsonConverterFactory.create());

        serviceInfoPurse =builder.build().create(ServiceInfoPurse.class);
    }
}
