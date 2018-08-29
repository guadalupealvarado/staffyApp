package com.praxis.staffy.ui.login;

import android.text.TextUtils;
import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.model.DTO.ListUser;
import com.praxis.staffy.model.pojo.User;
import org.greenrobot.eventbus.Subscribe;
import java.util.ArrayList;


public class LoginPresenterImp implements LoginMvp.LoginPresenterInterface {

    private EventbusInterface eventbus;
    private LoginMvp.LoginViewInterface loginView;
    private LoginRepositoryImp loginRepository;

    public LoginPresenterImp(LoginMvp.LoginViewInterface loginViewInt) {
        this.eventbus = EventbusHelperImp.getInstance();
        this.loginView = loginViewInt;
        this.loginRepository = new LoginRepositoryImp();
    }

    @Override
    public void oncreate() {
        //registra la actividad para el evento
        eventbus.register(this);
    }

    @Override
    public void ondestroy() {
        eventbus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(GeneralEvent event)
    {
       if(GeneralEvent.POJO.equals(LoginRepositoryImp.POJOLOGIN))
        {
            if(event != null){
                switch (event.getEventType()) {
                    case GeneralEvent.onSuccesEvent:
                        loginView.hiddenLoading();
                        ListUser listUser=(ListUser) event.getObject();
                        ArrayList<User> userArrayList=listUser.getList();
                        User userObj =userArrayList.get(0);
                        //User userObj=((ListUser) event.getCustomerDetails()).getCustomerDetails().get(0);
                        if(!userObj.getCorreoElectronico().isEmpty())
                        {
                            if(userObj.getApMaterno()==null)
                            {
                                userObj.setApMaterno("");
                            }
                            UserDAO.getInstance().setList(userArrayList);
                            loginView.succesLogin();
                        }
                        break;
                    case GeneralEvent.onErrorEvent:
                        loginView.hiddenLoading();
                        if(!TextUtils.isEmpty(event.getShowMessage()))
                        {   loginView.showMessage(event.getShowMessage()); }
                        break;
                }
            }
        }
    }

    @Override
    public void login(String user, String password) {
        loginView.showLoading();
        loginRepository.login(user,password);
    }


}
