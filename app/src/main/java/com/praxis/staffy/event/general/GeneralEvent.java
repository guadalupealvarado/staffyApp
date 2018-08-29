package com.praxis.staffy.event.general;

public class GeneralEvent {

    public final static int onErrorEvent = 0;
    public final static int onSuccesEvent = 1;
    public static  String POJO="";

    private int eventType;
    private String showMessage;
    private Object object;

    public GeneralEvent()
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {

        this.object =null;
        this.object = object;
    }
}
