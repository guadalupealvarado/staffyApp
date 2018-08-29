package com.praxis.staffy.event.general.Example;

import com.praxis.staffy.model.DTO.ListPurse;

public class PurseGeneralEvent {

    public final static int onErrorEvent = 0;
    public final static int onSuccesEvent = 1;
    public static  String POJO="";

    private int eventType;
    private String showMessage;
    private ListPurse listPurse;

    public PurseGeneralEvent()
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

    public ListPurse getListPurse() {
        return listPurse;
    }

    public void setListPurse(ListPurse object) {
        this.listPurse = object;
    }
}
