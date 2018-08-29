package com.praxis.staffy.service.servicesClient.insertClient;
import com.praxis.staffy.utils.ManagementUrlWebServices;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppiInsertClient
{
    public  ServiceInterClient serviceInterClient;

    public void initClient()
    {
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl(ManagementUrlWebServices.getUrl_web_services())
                .addConverterFactory(GsonConverterFactory.create());
        serviceInterClient=builder.build().create(ServiceInterClient.class);
    }
}
