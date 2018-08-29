package com.praxis.staffy.event.general;

import com.praxis.staffy.model.DTO.ListAllProject;

public class ProyectEvent {

    public final static int onErrorEvent = 0;
    public final static int onSuccesEvent = 1;

    private int eventType;
    private String showMessage;
    private ListAllProject object;

    public ProyectEvent()
    {
        object =null;
    }
    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getShowMessage() {
        return showMessage;
    }

    public void setShowMessage(String showMessage) {
        this.showMessage = showMessage;
    }

    public ListAllProject getObject() {
        return object;
    }

    public void setObject(ListAllProject object) {
        this.object = object;
    }
}
