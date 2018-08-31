package com.praxis.staffy.ui.activities;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.model.pojo.ActivityP;

import java.util.ArrayList;

public interface ActivitiesMvp {
    interface view
    {
        void showLoading();
        void hiddenLoading();
        void showMessage(String msj);
        void cardDataCardView(ArrayList<ActivityP> list);
    }

    interface presenter
    {
        void restLoadActivities();
        void oncreate();
        void ondestroy();
        void onEventMainThread(GeneralEvent event);
    }
    interface  model{
        void loadAllActivities();
    }
}
