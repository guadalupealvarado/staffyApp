package com.praxis.staffy.event.general;

import com.praxis.staffy.model.DTO.listInfoPurse;

public class PurseInfoGeneralEvent {

    public final static int onErrorEvent = 0;
    public final static int onSuccesEvent = 1;
    public static  String POJO="";

    private int eventType;
    private String showMessage;
    private listInfoPurse listPurse;

    public PurseInfoGeneralEvent()
    {
        listPurse =null;
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

    public listInfoPurse getListPurse() {
        return listPurse;
    }

    public void setListPurse(listInfoPurse object) {
        this.listPurse = object;
    }
}
