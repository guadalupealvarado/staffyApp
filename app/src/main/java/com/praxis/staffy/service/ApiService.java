package com.praxis.staffy.service;

import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiService {

    //obj de la interfaz
    public ApiServiceInterface apiclient;

    public void initApiService() {
        Retrofit.Builder apiClientConfig = new Retrofit.Builder()
                .baseUrl(MyAplication.getContext().getString(R.string.url_rwsa_web))
                .client(TrustOkHttpClient.getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create());
        apiclient = apiClientConfig.build().create(ApiServiceInterface.class);
    }



}
