package com.praxis.staffy.event.general.client.updateclient;

import com.praxis.staffy.model.DTO.generigGetResponse.GetGeneriResponse;

public class UpdateClientEvent {
    public final static int onErrorEvent = 0;
    public final static int onSuccesEvent = 1;
    private int eventType;
    private String showMessage;
    private GetGeneriResponse getGeneriResponse;

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

    public GetGeneriResponse getGetGeneriResponse() {
        return getGeneriResponse;
    }

    public void setGetGeneriResponse(GetGeneriResponse getGeneriResponse) {
        this.getGeneriResponse = getGeneriResponse;
    }
}
