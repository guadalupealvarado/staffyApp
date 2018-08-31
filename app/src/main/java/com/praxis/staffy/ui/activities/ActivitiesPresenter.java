package com.praxis.staffy.ui.activities;

import android.text.TextUtils;
import android.util.Log;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DAO.Activities.ActivitiesDAO;

import com.praxis.staffy.model.DTO.ListActivities;

import com.praxis.staffy.model.pojo.ActivityP;
import com.praxis.staffy.ui.notification.NotificationModel;

import org.greenrobot.eventbus.Subscribe;


public class ActivitiesPresenter implements ActivitiesMvp.presenter {
    private EventbusInterface eventbus;
    private ActivitiesMvp.view view;
    private ActivitiesMvp.model model;
    public ActivitiesPresenter(ActivitiesMvp.view view) {
        this.eventbus = EventbusHelperImp.getInstance();
        this.view = view;
        model=new ActivitiesModel();
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
        if (GeneralEvent.POJO.equalsIgnoreCase(ActivitiesModel.POJOACTIVITIES)) {
            view.hiddenLoading();
            Log.e("Event", "Se registro.");
            if (event != null) {
                switch (event.getEventType()) {
                    case GeneralEvent.onSuccesEvent:
                        ListActivities listActivities = ((ListActivities) event.getObject());
                        ActivityP activityP = listActivities.getList().get(0);
                        //User userObj=((ListUser) event.getCustomerDetails()).getCustomerDetails().get(0);
                        if (!activityP.getDescripcion().isEmpty()) {
                            ActivitiesDAO.getInstance().setList(listActivities.getList());
                            view.cardDataCardView(listActivities.getList());
                        }
                        break;
                    case GeneralEvent.onErrorEvent:
                        if (!TextUtils.isEmpty(event.getShowMessage())) {
                            view.showMessage(event.getShowMessage());
                        }
                        break;
                }
            }

        }//Fin primer IF
    }

    @Override
    public void restLoadActivities() {
        ActivitiesModel.UPDATE = true;
        view.showLoading();
        model.loadAllActivities();
    }

    public void loadList()
    {
        //view.showLoading();
        model.loadAllActivities();
    }

}
