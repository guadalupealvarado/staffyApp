package com.praxis.staffy.event.general;


import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.pojo.CustomerDetails;
import android.support.v7.widget.Toolbar;
import com.praxis.staffy.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.requests.editRequest.EditRequestView;
import com.praxis.staffy.ui.requests.ContainerRequest;


public class DetailsClientGeneral {
    public DetailsClientEvent detailsClientEvent;
    public EventbusHelperImp eventBus;
    @android.support.annotation.Nullable

    @butterknife.BindView(R.id.toolbar)
    Toolbar toolbar;
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
