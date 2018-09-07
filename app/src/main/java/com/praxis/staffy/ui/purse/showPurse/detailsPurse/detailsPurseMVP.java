package com.praxis.staffy.ui.purse.showPurse.detailsPurse;

import com.praxis.staffy.event.general.Example.PurseEventGeneral;
import com.praxis.staffy.event.general.PurseInfoGeneralEvent;
import com.praxis.staffy.model.DTO.listInfoPurse;
import com.praxis.staffy.model.pojo.Purse.purseInfoGeneral;

import java.util.List;

public interface detailsPurseMVP {
    interface viewInfoPurse{
        void viewResource();
    }
    interface presenterInfoPurse{
        void oncreate();
        void ondestroy();
        void onEventMainThread(PurseInfoGeneralEvent purseEventGeneral);
        void showAllPuse();
    }
    interface modelInfoPurse{
        void initShowAllPurse();
        void saveInDAO(List<purseInfoGeneral> infoPurses);
    }
}
