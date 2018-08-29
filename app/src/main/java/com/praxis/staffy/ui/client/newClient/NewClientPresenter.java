package com.praxis.staffy.ui.client.newClient;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.pojo.Address;
import com.praxis.staffy.model.pojo.Client;
import org.greenrobot.eventbus.Subscribe;
import java.util.ArrayList;

public class NewClientPresenter implements NewClientMVP.presenter {
    private EventbusInterface eventbus;
    private NewClientsView view;
    private NewClientModel model;

    public NewClientPresenter(NewClientsView view) {
        this.eventbus = EventbusHelperImp.getInstance();
        this.view = view;
        this.model = new NewClientModel();
    }

    @Override
    public void sendDataNewClient(Client client, ArrayList<Address> addressArrayList) {


    }

    @Override
    public void oncreate() {
        eventbus.register(this);


    }

    @Override
    public void ondestroy() {
        eventbus.unregister(this);

    }

    @Subscribe
    @Override
    public void onEventMainThread(GeneralEvent event) {

            if (event != null){
                switch (event.getEventType()){
                    case GeneralEvent.onSuccesEvent:
                   //Log.e("si","Se Guardo"+PurseGeneralEvent.onSuccesEvent);
                        view.showMSG("Se ha guardado");
                        view.cleanAllTXT();
                }

            }else {
                switch (event.getEventType()){
                    case GeneralEvent.onErrorEvent:
                        view.showMSG("Ocurrio un error");
                        view.cleanAllTXT();
                }

            }
        }





    @Override
    public void newClient(Client client,ArrayList<Address>addressArrayList) {
        model.newClient(client,addressArrayList);
    }




}