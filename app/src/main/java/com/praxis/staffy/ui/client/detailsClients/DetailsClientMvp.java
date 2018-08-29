package com.praxis.staffy.ui.client.detailsClients;

import android.os.Bundle;
import android.view.View;
import com.praxis.staffy.model.pojo.CustomerDetails;

public interface DetailsClientMvp {
    interface view {
        void loadClient(int id_client);
        void showToolbar(View view);
        void showLoading();
        void hiddenLoading();
        void showMessage(String msj);
        void getBundle(Bundle bundle);
        void sendDataClient(CustomerDetails customerDetails);
    }

    interface ClientPresenterInterface {
        void getDetailsClient(int id_client);
        void onCreate();
        void OnDestroy();
    }

    interface ClientModelInterface {
        void getDetailsClient(int id_client);
    }

}