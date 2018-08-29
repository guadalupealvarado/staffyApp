package com.praxis.staffy.event.general;

import com.praxis.staffy.model.pojo.CustomerDetails;

public class DetailsClientEvent {
    public final static int onErrorEvent = 0;
    public final static int onSuccesEvent = 1;

    private int eventType;
    private String showMessage;
    private CustomerDetails detailsClientEvent;

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

    public CustomerDetails getDetailsClientEvent() {
        return detailsClientEvent;
    }

    public void setDetailsClientEvent(CustomerDetails detailsClientEvent) {
        this.detailsClientEvent = detailsClientEvent;
    }
}
