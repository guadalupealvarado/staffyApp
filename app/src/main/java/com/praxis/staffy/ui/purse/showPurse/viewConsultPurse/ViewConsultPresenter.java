package com.praxis.staffy.ui.purse.showPurse.viewConsultPurse;

import android.text.TextUtils;

import com.praxis.staffy.event.general.Example.PurseGeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DTO.ListPurse;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.ViewPostulanPurseMVP;

import org.greenrobot.eventbus.Subscribe;

public class ViewConsultPresenter  implements ViewConsultMVP.ViewConsultPursePresenter {
    ViewConsultMVP.ViewConsultPurseModel viewConsultPurseModel;
    ViewConsultMVP.ViewConsultPurseView viewConsultPurseView;
    private EventbusInterface eventbusHelperImp;

    public ViewConsultPresenter(ViewConsultMVP.ViewConsultPurseView viewConsultPurseView) {
        this.viewConsultPurseView = viewConsultPurseView;
        this.eventbusHelperImp = EventbusHelperImp.getInstance();
        this.viewConsultPurseModel = new ViewConsultModel();
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
    public void onEventMainThread(PurseGeneralEvent event) {
        if (event != null) {
            switch (event.getEventType()) {
                case PurseGeneralEvent.onSuccesEvent:
                    viewConsultPurseView.hiddenLoading();
                    ListPurse listPurse = event.getListPurse();
                    viewConsultPurseModel.saveInDAO(listPurse.getData());
                    viewConsultPurseView.viewResource();
                    break;
                case PurseGeneralEvent.onErrorEvent:
                    if (!TextUtils.isEmpty(event.getShowMessage())) {
                        viewConsultPurseView.showMessage(event.getShowMessage());
                    }
                    break;
            }
        }
    }

    @Override
    public void showAllPuse() {
        viewConsultPurseView.showLoading();
        viewConsultPurseModel.initShowAllPurse();
    }
}
