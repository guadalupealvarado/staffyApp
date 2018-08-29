package com.praxis.staffy.event.general;

import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.pojo.CustomerDetails;

public class DetailsClientGeneral {
    public DetailsClientEvent detailsClientEvent;
    public EventbusHelperImp eventBus;

    public DetailsClientGeneral() {
        this.eventBus = EventbusHelperImp.getInstance();
        this.detailsClientEvent = new DetailsClientEvent();
    }

    public void postEvent(int type, String errorMessage)
    {
        detailsClientEvent.setEventType(type);
        if(errorMessage!=null)
        {
            detailsClientEvent.setShowMessage(errorMessage);
        }
        eventBus.post(detailsClientEvent);
    }

    public void postEvent(int type,CustomerDetails details)
    {
        detailsClientEvent.setDetailsClientEvent(details);
        detailsClientEvent.setEventType(type);
        if(detailsClientEvent!=null)
        {
            detailsClientEvent.setDetailsClientEvent(details);
        }
    eventBus.post(detailsClientEvent);
    }

}
