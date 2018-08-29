package com.praxis.staffy.event.general.Example;

import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.ListPurse;

public class PurseEventGeneral
{
    public PurseGeneralEvent purseGeneralEvent;
    public EventbusHelperImp eventBus;
    public PurseEventGeneral()
    {
        this.eventBus = EventbusHelperImp.getInstance();
        this.purseGeneralEvent = new PurseGeneralEvent();
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
}
