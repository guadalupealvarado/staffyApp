package com.praxis.staffy.ui.client.consultClients;

import android.view.View;

import com.praxis.staffy.model.pojo.Client;
import java.util.ArrayList;

public interface ClienteMVP {
            interface view{
                    void showToolbar(View view);
                    void showMsg(String msg);
                    void showLoading();
                    void hiddenLoading();
                    void setDataCardView(ArrayList<Client> list);
            }
            interface presenter{
                void getAllClient();
                void onCreate();
                void OnDestroy();
            }interface model
            {
                void getAllClient();
            }
}
