package com.praxis.staffy.ui.notification;

import com.praxis.staffy.event.general.GeneralEvent;

public interface NotificacionMvp {
    interface view
    {
        void showLoading();
        void hiddenLoading();
        void showMessage(String msj);
    }
    interface presenter
    {
        void restLoadNotification();
        void oncreate();
        void ondestroy();
        void onEventMainThread(GeneralEvent event);
    }

    interface  model
    {
        void loadAllNotification();
    }
}
