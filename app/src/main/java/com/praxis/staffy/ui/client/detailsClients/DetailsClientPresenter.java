package com.praxis.staffy.ui.client.detailsClients;

import com.praxis.staffy.event.general.DetailsClientEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DAO.client.CustomerDetailDAO;
import com.praxis.staffy.model.pojo.CustomerDetails;
import org.greenrobot.eventbus.Subscribe;

public class DetailsClientPresenter implements DetailsClientMvp.ClientPresenterInterface {

    private DetailsClientMvp.view view;
    private DetailsClientModel model;
    private EventbusInterface eventbus;


    public DetailsClientPresenter(DetailsClientMvp.view view) {
        this.eventbus = EventbusHelperImp.getInstance();
        this.view = view;
        this.model = new DetailsClientModel();
    }


    @Override
    public void getDetailsClient(int id_client) {
        CustomerDetails customerDetails=CustomerDetailDAO.getInstance().searchCustomerDetails(id_client);
        if(customerDetails==null)
        {
            view.showLoading();
            model.getDetailsClient(id_client);
        }else
        {
            view.sendDataClient(customerDetails);
        }

    }

    @Override
    public void onCreate() {
       eventbus.register(this);
    }

    @Override
    public void OnDestroy() {
        eventbus.unregister(this);
    }

    @Subscribe
    public void onEventMainThread(DetailsClientEvent event)
    {
        if (event != null)
            {
                switch (event.getEventType())
                {
                    case DetailsClientEvent.onSuccesEvent:
                        view.hiddenLoading();
                        saveClientDetails(event.getDetailsClientEvent());
                        return;
                    case DetailsClientEvent.onErrorEvent:
                            view.hiddenLoading();
                            if (!event.getShowMessage().isEmpty())
                            { view.showMessage(event.getShowMessage()); }
                            return;
                    }
            }
    }


    private void saveClientDetails(CustomerDetails customerDetails)
    {
        if (customerDetails != null)
        {
            CustomerDetailDAO.getInstance().addCustomerDetail(customerDetails);
            view.sendDataClient(customerDetails);
        }
        else { view.showMessage("detalles vacio"); }
    }
}
