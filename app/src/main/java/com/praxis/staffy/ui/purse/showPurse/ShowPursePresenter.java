package com.praxis.staffy.ui.purse.showPurse;

import android.text.TextUtils;
import com.praxis.staffy.event.general.Example.PurseGeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.ListPurse;
import org.greenrobot.eventbus.Subscribe;

public class ShowPursePresenter  {
/*
implements ShowPurseMVP.ShowPresenterInterface

    private ShowPurseMVP.ShowRepository showRepository;
    private ShowPurseMVP.ShowPurseInterface showPurseInterface;
    private EventbusHelperImp eventbusHelperImp;

    public ShowPursePresenter(ShowPurseMVP.ShowPurseInterface showPurseInterface)
    {
        this.showPurseInterface=showPurseInterface;
        this.eventbusHelperImp=EventbusHelperImp.getInstance();
        this.showRepository=new ShowPurseRepository();
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
                       showPurseInterface.hiddenLoading();
                       ListPurse listPurse =event.getListPurse();
                       showRepository.saveInDAO(listPurse.getData());
                       showPurseInterface.viewResource();
                       break;
                   case PurseGeneralEvent.onErrorEvent:
                       if (!TextUtils.isEmpty(event.getShowMessage()))
                       {
                           showPurseInterface.showMessage(event.getShowMessage());
                       }
                       break;
               }
           }
    }

    @Override
    public void showAllPuse() {
        showPurseInterface.showLoading();
        showRepository.initShowAllPurse();
    }
*/

}

