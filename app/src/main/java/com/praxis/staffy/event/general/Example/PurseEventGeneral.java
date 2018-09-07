package com.praxis.staffy.event.general.Example;

import com.praxis.staffy.event.general.PurseInfoGeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.ListPurse;
import com.praxis.staffy.model.DTO.listInfoPurse;

public class PurseEventGeneral
{
    public PurseGeneralEvent purseGeneralEvent;
    public EventbusHelperImp eventBus;
    public PurseInfoGeneralEvent purseInfoGeneralEvent;
    public PurseEventGeneral()
    {
        this.eventBus = EventbusHelperImp.getInstance();
        this.purseGeneralEvent = new PurseGeneralEvent();
        this.purseInfoGeneralEvent = new PurseInfoGeneralEvent();
    }

    public void postEvent(int type, String errorMessage) {
        purseGeneralEvent.setEventType(type);
        if (errorMessage != null) {
            purseGeneralEvent.setShowMessage(errorMessage);
        }
        eventBus.post(purseGeneralEvent);
    }

    public void postEvent(int type, ListPurse listUser)
    {
        purseGeneralEvent.setListPurse(null);
        purseGeneralEvent.setEventType(type);
        if (listUser != null) {
            purseGeneralEvent.setListPurse(listUser);
        }
        eventBus.post(purseGeneralEvent);
    }

    public void postEvent(int type, listInfoPurse listUser)
    {
        purseInfoGeneralEvent.setListPurse(null);
        purseInfoGeneralEvent.setEventType(type);
        if (listUser != null) {
            purseInfoGeneralEvent.setListPurse(listUser);
        }
        eventBus.post(purseGeneralEvent);
    }

}
