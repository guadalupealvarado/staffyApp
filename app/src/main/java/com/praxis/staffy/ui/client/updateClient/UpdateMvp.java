package com.praxis.staffy.ui.client.updateClient;


import android.view.View;
import com.praxis.staffy.event.general.client.updateclient.UpdateClientEvent;
import com.praxis.staffy.model.pojo.CustomerDetails;
import com.praxis.staffy.model.setPojoServices.updateClient.setClientsUpdate;

public interface UpdateMvp {
    interface view {
        void showToolbar(View view);
        void showMessage(String msj);
        void setDataUpdate(CustomerDetails dataUpdate);
        void showLoading();
        void hiddenLoading();
        void sendDataUpdate(int id_client);
    }

    interface presenter {
        void getDetailsClient(int id_client);
        void loadClient();
        void onEventMainThread(UpdateClientEvent generalEvent);
        void oncreate();
        void ondestroy();
        void setDateUpdate(setClientsUpdate dateUpdate, int id_client);
    }

    interface model {
        CustomerDetails getDetailsClient(int id_client);
        void loadClient();
        void updateClient(setClientsUpdate customerDetails, int id_client);
    }
}
