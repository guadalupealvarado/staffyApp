package com.praxis.staffy.ui.client.consultClients;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DAO.client.ClientDAO;
import com.praxis.staffy.model.DTO.ListClient;
import org.greenrobot.eventbus.Subscribe;

public class ConsultClientePresenterImp implements ClienteMVP.presenter {
    private ClienteMVP.view view;
    private ConsultClientModel model;
    private EventbusInterface eventbus;

    public ConsultClientePresenterImp(ClienteMVP.view view){
        this.eventbus = EventbusHelperImp.getInstance();
        this.view = view;
        model =new ConsultClientModel();
    }

    @Subscribe
    public void onEventMainThread(GeneralEvent event) {
    if(GeneralEvent.POJO.equalsIgnoreCase(ConsultClientModel.POJOSHOWCLIENT))
    {
        if(event != null){
            switch (event.getEventType()) {
                case GeneralEvent.onSuccesEvent:
                    view.showLoading();
                    ListClient listClient= ((ListClient)event.getObject());
                    if(listClient.getList().size()!=0)
                    {
                        ClientDAO.getInstance().setAllClient(listClient.getList());
                        view.setDataCardView(listClient.getList());
                    }
                    break;
                case GeneralEvent.onErrorEvent:
                    if (!event.getShowMessage().isEmpty())
                    {
                        view.showMsg(event.getShowMessage());
                    }
                    break;
            }
        }
    }
    }


    @Override
    public void getAllClient() {
        model.getAllClient();
    }

    @Override
    public void onCreate()
    {
        eventbus.register(this);
    }

    @Override
    public void OnDestroy()
    {
        eventbus.unregister(this);
    }
}
