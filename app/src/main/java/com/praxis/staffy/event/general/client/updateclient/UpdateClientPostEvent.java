package com.praxis.staffy.event.general.client.updateclient;

import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.generigGetResponse.GetGeneriResponse;

public class UpdateClientPostEvent {

    public UpdateClientEvent updateClientEvent;
    public EventbusHelperImp eventBus;

    public UpdateClientPostEvent() {
        updateClientEvent=new UpdateClientEvent();
        eventBus=EventbusHelperImp.getInstance();
    }

    public void postEvent(int type, String errorMessage) {
        updateClientEvent.setEventType(type);
        if(errorMessage!=null)
        {
            updateClientEvent.setShowMessage(errorMessage);
        }
        eventBus.post(updateClientEvent);
    }

    public void postEvent(int type, GetGeneriResponse getGeneriResponse) {
        updateClientEvent.setEventType(type);
        if(getGeneriResponse!=null)
        {
            updateClientEvent.setGetGeneriResponse(getGeneriResponse);
        }
        eventBus.post(updateClientEvent);
    }
}
