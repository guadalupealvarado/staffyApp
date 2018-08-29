package com.praxis.staffy.service.perfil.getAllPerfil;

import com.praxis.staffy.utils.ManagementUrlWebServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiGetAllPerfil
{
    public ServicesGetAllPerfil servicesGetAllPerfil;
    public void initGetAllPerfil()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        servicesGetAllPerfil=builder.build().create(ServicesGetAllPerfil.class);
    }
}
