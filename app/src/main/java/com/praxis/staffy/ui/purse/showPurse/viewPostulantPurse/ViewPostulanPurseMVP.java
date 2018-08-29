package com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse;

import com.praxis.staffy.event.general.Example.PurseGeneralEvent;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;

import java.util.List;

public interface ViewPostulanPurseMVP {

    interface ViewPostulanPurseView
    {
        void showLoading();
        void hiddenLoading();
        void showMessage(String msj);
        void viewResource();
    }
    interface ViewPostulanPursePresenter
    {
        void oncreate();
        void ondestroy();
        void onEventMainThread(PurseGeneralEvent purseGeneralEvent);
        void showAllPuse();
    }
    interface ViewPostulanPurseRepository
    {
        void initShowAllPurse();
        void saveInDAO(List<InfoRecursoPurse> infoRecursoPurseList);
    }
}
