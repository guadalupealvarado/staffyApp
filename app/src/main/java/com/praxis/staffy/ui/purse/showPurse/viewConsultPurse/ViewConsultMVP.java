package com.praxis.staffy.ui.purse.showPurse.viewConsultPurse;

import com.praxis.staffy.event.general.Example.PurseGeneralEvent;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;

import java.util.List;

public interface ViewConsultMVP {
    interface ViewConsultPurseView
    {
        void showLoading();
        void hiddenLoading();
        void showMessage(String msj);
        void viewResource();
    }
    interface ViewConsultPursePresenter
    {
        void oncreate();
        void ondestroy();
        void onEventMainThread(PurseGeneralEvent purseGeneralEvent);
        void showAllPuse();
    }
    interface ViewConsultPurseModel
    {
        void initShowAllPurse();
        void saveInDAO(List<InfoRecursoPurse> infoRecursoPurseList);
    }
}
