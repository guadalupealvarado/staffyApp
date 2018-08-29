package com.praxis.staffy.ui.login;

import com.praxis.staffy.event.general.GeneralEvent;


public interface LoginMvp
{

    public interface LoginViewInterface {
        void showLoading();
        void hiddenLoading();
        void succesLogin();
        void showMessage(String msj);
        void goRecoverPasswordI();
    }

    public interface LoginPresenterInterface {
        void oncreate();
        void ondestroy();
        void onEventMainThread(GeneralEvent event);
        //void initLogin(String user, String password, String deviceId, String version);
        void login(String user, String password);

    }

    public interface LoginRepositoryInterface {
      //  void initLogin(String user, String password, String deviceId, String version);
        boolean login(String user, String password);
    }

}
