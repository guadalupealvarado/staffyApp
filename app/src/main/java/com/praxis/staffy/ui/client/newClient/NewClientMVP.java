package com.praxis.staffy.ui.client.newClient;

import android.view.View;
import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.model.pojo.Address;
import com.praxis.staffy.model.pojo.Client;
import java.util.ArrayList;

public interface NewClientMVP  {
    interface view
    {
        void showMSG(String msg);
        void showToolbar(View view);
        void cleanAllTXT();


    }
    interface presenter
    {
        void sendDataNewClient(Client client, ArrayList<Address> addressArrayList);
        void oncreate();
        void ondestroy();
        void onEventMainThread(GeneralEvent event);
        void newClient(Client client, ArrayList<Address> addressArrayList);
    }
    interface model
    {

        boolean newClient(final Client client, final ArrayList<Address> addressArrayList);
    }

}