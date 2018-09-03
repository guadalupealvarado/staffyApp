package com.praxis.staffy.ui.activities;

import android.util.Log;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.event.general.PostEventGeneral;
import com.praxis.staffy.model.DAO.Activities.ActivitiesDAO;

import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.model.DTO.ListActivities;

import com.praxis.staffy.model.User;
import com.praxis.staffy.model.setPojoServices.SetObjectActivitiesAll;

import com.praxis.staffy.service.serviceActivities.AppiActivities;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivitiesModel extends PostEventGeneral implements ActivitiesMvp.model {
    public static String POJOACTIVITIES = "POJOACTIVITIES";
    public static boolean UPDATE = true;
    private final AppiActivities appiActivities;

    public ActivitiesModel() {
        // Required empty public constructor
        appiActivities = new AppiActivities();
        appiActivities.initActivities();
    }

    @Override
    public void loadAllActivities() {
        if (ActivitiesModel.UPDATE) {
            Call<ListActivities> response = appiActivities.servicesActivities.getAllActivities(
                    new SetObjectActivitiesAll(UserDAO.getInstance().getList().get(0).getId().toString()));
            Log.e("ID user...", String.valueOf(UserDAO.getInstance().getList().get(0).getId()));
            response.enqueue(new Callback<ListActivities>() {
                @Override
                public void onResponse(Call<ListActivities> call, Response<ListActivities> response) {
                    if (!response.isSuccessful()) {
                        Log.d("ESTATUS", "CARGADO");
                        String error = "";
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("application/json")) {
                        } else {
                            error = response.message();
                        }
                        postEvent(GeneralEvent.onErrorEvent, error);
                        return;

                    } else {
                        Log.d("ESTATUS", "CARGADO");
                        ListActivities listActivities = response.body();
                        //ArrayList<Notification> list=listNotification.getObject();
                        //  NotificationView.list=list;
                        if (listActivities.getList().size() != 0) {
                            ActivitiesDAO.getInstance().setList(listActivities.getList());
                            postEvent(GeneralEvent.onSuccesEvent, listActivities);
                            ActivitiesModel.UPDATE = false;
                            //NotificationModel.UPDATENOTIFICATION=false;
                        } else {
                            postEvent(GeneralEvent.onErrorEvent, "Lista vacia");
                        }
                    }
                }

                @Override
                public void onFailure(Call<ListActivities> call, Throwable t) {
                    postEvent(GeneralEvent.onErrorEvent, t.getMessage());
                }
            });
            GeneralEvent.POJO = ActivitiesModel.POJOACTIVITIES;

        } else //else de update
        {
            Log.i("Estado", "Ya se cargo.");
        }


    }
}

