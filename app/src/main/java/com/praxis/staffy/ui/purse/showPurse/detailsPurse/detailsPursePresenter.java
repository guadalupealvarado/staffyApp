package com.praxis.staffy.ui.purse.showPurse.detailsPurse;

import android.text.TextUtils;
import android.util.Log;


import com.praxis.staffy.event.general.Example.PurseEventGeneral;
import com.praxis.staffy.event.general.Example.PurseGeneralEvent;
import com.praxis.staffy.event.general.PurseInfoGeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.ListPurse;
import com.praxis.staffy.model.DTO.listInfoPurse;
import com.praxis.staffy.helper.EventbusInterface;

import org.greenrobot.eventbus.Subscribe;

public class detailsPursePresenter  implements  detailsPurseMVP.presenterInfoPurse{

    detailsPurseMVP.modelInfoPurse model;
    detailsPurseMVP.viewInfoPurse view;

    private EventbusInterface eventbusHelperImp;

    public detailsPursePresenter( detailsPurseMVP.viewInfoPurse view) {
        this.model = new detailsPurseModel();
        this.view = view;
        this.eventbusHelperImp = EventbusHelperImp.getInstance();
    }

    @Override
    public void oncreate() {
        eventbusHelperImp.register(this);
    }

    @Override
    public void ondestroy() {
        eventbusHelperImp.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(PurseInfoGeneralEvent event) {
        if(event!=null)
        {
            switch (event.getEventType()) {
                case PurseGeneralEvent.onSuccesEvent:

                    listInfoPurse listPurse =event.getListPurse();
                    model.saveInDAO(listPurse.getData());
                    view.viewResource();
                    break;
                case PurseGeneralEvent.onErrorEvent:
                    if (!TextUtils.isEmpty(event.getShowMessage()))
                    {
                        //viewPostulanPurseView.showMessage(event.getShowMessage());
                        Log.e("ERROR EN PRESENTER",event.getShowMessage());
                    }
                    break;
            }
        }
    }



    @Override
    public void showAllPuse() {
        model.initShowAllPurse();
    }
}
