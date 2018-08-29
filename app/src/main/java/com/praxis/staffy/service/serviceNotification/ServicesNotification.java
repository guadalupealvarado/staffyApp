package com.praxis.staffy.service.serviceNotification;

import com.praxis.staffy.model.DTO.ListNotification;
import com.praxis.staffy.model.setPojoServices.SetObjectNotificationGetAll;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServicesNotification {
    @Headers({"Content-Type: application/json", "charset: UTF-8"})
    @POST("notificacion/obtenerTodas/")
    Call<ListNotification> getAllNotification(@Body SetObjectNotificationGetAll setObjectNotificationGetAll1);


}
