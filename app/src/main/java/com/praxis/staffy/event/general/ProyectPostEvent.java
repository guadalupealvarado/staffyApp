package com.praxis.staffy.event.general;

import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.ListAllProject;

public class ProyectPostEvent {

    public ProyectEvent generalEvent;
    public EventbusHelperImp eventBus;
    public ProyectPostEvent()
    {
        this.eventBus = EventbusHelperImp.getInstance();
        this.generalEvent = new ProyectEvent();
    }

    public void postEvent(int type, String errorMessage) {
        generalEvent.setEventType(type);
        if (errorMessage != null) {
            generalEvent.setShowMessage(errorMessage);
        }
        eventBus.post(generalEvent);
    }

    public void postEvent(int type, ListAllProject objProyect)
    {
        generalEvent.setObject(null);
        generalEvent.setEventType(type);
        if (objProyect != null) {
            generalEvent.setObject(objProyect);
        }
        eventBus.post(generalEvent);
    }
}
