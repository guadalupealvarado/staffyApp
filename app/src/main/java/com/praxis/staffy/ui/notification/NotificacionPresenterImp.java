package com.praxis.staffy.ui.notification;


import android.text.TextUtils;
import android.util.Log;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DAO.notification.NotificationDAO;
import com.praxis.staffy.model.DTO.ListNotification;
import com.praxis.staffy.model.pojo.Notification;
import org.greenrobot.eventbus.Subscribe;


public class NotificacionPresenterImp implements NotificacionMvp.presenter {
    private EventbusInterface eventbus;
    private NotificationView view;
    private NotificacionMvp.model model;
    public NotificacionPresenterImp(NotificationView view) {
        this.eventbus = EventbusHelperImp.getInstance();
        this.view = view;
        model=new NotificationModel();

    }

    @Override
    public void oncreate() {
        eventbus.register(this);
    }

    @Override
    public void ondestroy() {
        eventbus.unregister(this);
    }
    @Subscribe
    @Override
    public void onEventMainThread(GeneralEvent event) {

        if(GeneralEvent.POJO.equalsIgnoreCase(NotificationModel.POJONOTIFICATION))
        {
            view.hiddenLoading();
            Log.e("Event","Se registro.");
            if(event != null){
                switch (event.getEventType()) {
                    case GeneralEvent.onSuccesEvent:
                        ListNotification listNotification=((ListNotification) event.getObject());
                        Notification notification=listNotification.getList().get(0);
                        //User userObj=((ListUser) event.getCustomerDetails()).getCustomerDetails().get(0);
                        if(!notification.getDescripcion().isEmpty())
                        {
                            NotificationDAO.getInstance().setList(listNotification.getList());
                            view.cardDataCardView(listNotification.getList());
                        }
                        break;
                    case GeneralEvent.onErrorEvent:
                        if(!TextUtils.isEmpty(event.getShowMessage())){
                            view.showMessage(event.getShowMessage());
                        }
                        break;
                }
            }
        }

    }

    @Override
    public void restLoadNotification()
    {
        NotificationModel.UPDATE=true;
        view.showLoading();
        model.loadAllNotification();
    }

    public void loadList()
    {
        view.showLoading();
        model.loadAllNotification();
    }
}
