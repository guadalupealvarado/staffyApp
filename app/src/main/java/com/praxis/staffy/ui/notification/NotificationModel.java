package com.praxis.staffy.ui.notification;

import android.util.Log;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.event.general.PostEventGeneral;
import com.praxis.staffy.model.DAO.notification.NotificationDAO;
import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.model.DTO.ListNotification;
import com.praxis.staffy.model.setPojoServices.SetObjectNotificationGetAll;
import com.praxis.staffy.service.serviceNotification.AppiNotification;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationModel extends PostEventGeneral implements NotificacionMvp.model {

    //Variables
    private final AppiNotification appiNotification;

    public static String POJONOTIFICATION="POJONOTIFICATION";
    public static boolean UPDATE=true;

  //  public static boolean UPDATENOTIFICATION=true;


    public NotificationModel() {
        // Required empty public constructor
        appiNotification=new AppiNotification();
        appiNotification.initNotification();
    }

    @Override
    public void loadAllNotification()
    {
        if(NotificationModel.UPDATE)
        {
            Call<ListNotification> response=appiNotification.servicesNotification.getAllNotification(
                   new SetObjectNotificationGetAll(String.valueOf(UserDAO.getInstance().getList().get(0).getId())));
            Log.e("ID user...",String.valueOf(UserDAO.getInstance().getList().get(0).getId()));
            response.enqueue(new Callback<ListNotification>() {
                @Override
                public void onResponse(Call<ListNotification> call, Response<ListNotification> response) {
                    if(!response.isSuccessful())
                    {
                        Log.d("ESTATUS","CARGADO");
                        String error = "";
                        if (response.errorBody()
                                .contentType()
                                .subtype()
                                .equals("application/json"))
                        {
                        }
                        else {
                            error = response.message();
                        }
                        postEvent(GeneralEvent.onErrorEvent, error);
                        return;

                    }else
                    {
                        Log.d("ESTATUS","CARGADO");
                        ListNotification listNotification=response.body();
                        //ArrayList<Notification> list=listNotification.getObject();
                        //  NotificationView.list=list;
                        if (listNotification.getList().size()!=0)
                        {
                            NotificationDAO.getInstance().setList(listNotification.getList());
                            postEvent(GeneralEvent.onSuccesEvent,listNotification);
                            NotificationModel.UPDATE=false;
                            //NotificationModel.UPDATENOTIFICATION=false;
                        }else
                        {
                            postEvent(GeneralEvent.onErrorEvent, "Lista vacia");
                        }
                    }
                }
                @Override
                public void onFailure(Call<ListNotification> call, Throwable t) {
                    postEvent(GeneralEvent.onErrorEvent, t.getMessage());
                }
            });
            GeneralEvent.POJO=NotificationModel.POJONOTIFICATION;

        }else //else de update
        {
            Log.i("Estado","Ya se cargo.");
        }


    }

}
