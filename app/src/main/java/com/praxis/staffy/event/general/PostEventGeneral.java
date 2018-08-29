package com.praxis.staffy.event.general;

import com.praxis.staffy.helper.EventbusHelperImp;

public class PostEventGeneral
{
    public GeneralEvent generalEvent;
    public EventbusHelperImp eventBus;

    public PostEventGeneral()
    {
        this.eventBus = EventbusHelperImp.getInstance();
        this.generalEvent = new GeneralEvent();
    }

    public void postEvent(int type, String errorMessage) {
        generalEvent.setEventType(type);
        if (errorMessage != null) {
            generalEvent.setShowMessage(errorMessage);
        }
        eventBus.post(generalEvent);
    }

    public void postEvent(int type, Object listUser)
    {
        generalEvent.setObject(null);
        generalEvent.setEventType(type);
        if (listUser != null) {
            generalEvent.setObject(listUser);
        }
        eventBus.post(generalEvent);
    }
}
