package com.praxis.staffy.service.Project.SelectAllProject;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiAllProject {
    public ServicesSelectAllProject servicesSelectAllProject;

    public void init()
    {
        Retrofit.Builder builder=new Retrofit.Builder().
                baseUrl(ManagementUrlWebServices.getUrl_web_services()).
                addConverterFactory(GsonConverterFactory.create());
     //Puente
        servicesSelectAllProject=builder.build().create(ServicesSelectAllProject.class);
    }
}
