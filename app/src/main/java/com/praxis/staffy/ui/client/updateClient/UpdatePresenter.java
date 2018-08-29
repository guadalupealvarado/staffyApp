package com.praxis.staffy.ui.client.updateClient;

import android.text.TextUtils;

import com.praxis.staffy.event.general.client.updateclient.UpdateClientEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.model.DTO.generigGetResponse.GetGeneriResponse;
import com.praxis.staffy.model.setPojoServices.updateClient.setClientsUpdate;

import org.greenrobot.eventbus.Subscribe;


public class UpdatePresenter implements UpdateMvp.presenter{

    private EventbusHelperImp eventbus;
    private UpdateClientView view;
    private UpdateModel model;

    public UpdatePresenter(UpdateClientView view) {
        this.view = view;
        this.model = new UpdateModel();
        this.eventbus=EventbusHelperImp.getInstance();
    }

    @Override
    public void getDetailsClient(int id_client) {
     if(model.getDetailsClient(id_client)==null)
     {
         view.showToastMsj("No hemos encontrado nada.");
     }else
        {
            view.sendDataClient(model.getDetailsClient(id_client));
        }
    }

    @Override
    public void loadClient() {

    }

    @Subscribe
    @Override
    public void onEventMainThread(UpdateClientEvent updateClientEvent)
    {
        if(updateClientEvent!=null)
        {
            view.hiddenLoading();
            switch (updateClientEvent.getEventType())
            {
                case UpdateClientEvent.onSuccesEvent:
                    GetGeneriResponse getGeneriResponse=updateClientEvent.getGetGeneriResponse();
                    if(getGeneriResponse.getData()!=0)
                    {
                        view.showToastMsj("bien");
                    }else
                    {
                        view.showToastMsj("Mal...");
                    }
                    break;
                case UpdateClientEvent.onErrorEvent:
                    if(!TextUtils.isEmpty(updateClientEvent.getShowMessage()))
                    {
                        view.showToastMsj(updateClientEvent.getShowMessage());
                    }
                    break;
            }
        }
    }

    @Override
    public void oncreate() {
        eventbus.register(this);
    }

    @Override
    public void ondestroy() {
        eventbus.unregister(this);
    }

    @Override
    public void setDateUpdate(setClientsUpdate dateUpdate,int id_client) {
        model.updateClient(dateUpdate,id_client);
    }
}
