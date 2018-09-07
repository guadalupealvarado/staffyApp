package com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse;

import android.text.TextUtils;

import com.praxis.staffy.event.general.Example.PurseGeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DTO.ListPurse;

import org.greenrobot.eventbus.Subscribe;

public class ViewPostulanPursePresenter implements ViewPostulanPurseMVP.ViewPostulanPursePresenter {

    ViewPostulanPurseMVP.ViewPostulanPurseRepository viewPostulanPurseRepository;
    ViewPostulanPurseMVP.ViewPostulanPurseView viewPostulanPurseView;
    private EventbusInterface  eventbusHelperImp;

    public ViewPostulanPursePresenter(ViewPostulanPurseMVP.ViewPostulanPurseView viewPostulanPurseView) {
        this.viewPostulanPurseView = viewPostulanPurseView;
        this.eventbusHelperImp=EventbusHelperImp.getInstance();
        this.viewPostulanPurseRepository=new ViewPostulanPurseRepository();
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
    public void onEventMainThread(PurseGeneralEvent event)
    {
            if(event!=null)
            {
                switch (event.getEventType()) {
                    case PurseGeneralEvent.onSuccesEvent:
                        viewPostulanPurseView.hiddenLoading();
                        ListPurse listPurse =event.getListPurse();
                        viewPostulanPurseRepository.saveInDAO(listPurse.getData());
                        viewPostulanPurseView.viewResource();
                        break;
                    case PurseGeneralEvent.onErrorEvent:
                        if (!TextUtils.isEmpty(event.getShowMessage()))
                        {
                            viewPostulanPurseView.showMessage(event.getShowMessage());
                        }
                        break;
                }
            }
    }

    @Override
    public void showAllPuse() {
        viewPostulanPurseView.showLoading();
        viewPostulanPurseRepository.initShowAllPurse();
    }
}
