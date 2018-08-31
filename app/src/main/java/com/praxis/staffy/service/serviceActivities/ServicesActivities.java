package com.praxis.staffy.service.serviceActivities;

import com.praxis.staffy.model.DTO.ListActivities;

import com.praxis.staffy.model.setPojoServices.SetObjectActivitiesAll;
import com.praxis.staffy.model.setPojoServices.SetObjectNotificationGetAll;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServicesActivities {
    @Headers({"Content-Type: application/json", "charset: UTF-8"})
    @POST("actividades/obtenerPorFechaUsuario/")
    Call<ListActivities> getAllActivities(@Body SetObjectActivitiesAll setObjectActivitiesAll);
}
