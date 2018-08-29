package com.praxis.staffy.ui.client.newClient;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.event.general.PostEventGeneral;
import com.praxis.staffy.model.pojo.Address;
import com.praxis.staffy.model.pojo.Client;
import com.praxis.staffy.model.setPojoServices.SetClient;
import com.praxis.staffy.service.servicesClient.insertClient.AppiInsertClient;
import com.praxis.staffy.service.servicesClient.insertClient.GetPojoInsertClient;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class NewClientModel extends PostEventGeneral implements NewClientMVP.model {

    private final AppiInsertClient appiInsertClient;

    public static String STATUS="success";
    public static String POJONEWCLIENT="POJONEWCLIENT";


    public NewClientModel() {
        appiInsertClient=new AppiInsertClient();
        appiInsertClient.initClient();

    }


    public boolean newClient(final Client client, final ArrayList<Address> addressArrayList ) {
        GeneralEvent.POJO=NewClientModel.POJONEWCLIENT;
        Call<GetPojoInsertClient> response =
                appiInsertClient.serviceInterClient.
                        insertClientServices(new SetClient(client.getNombreCliente(), client.getLogo(), 7, addressArrayList));

        response.enqueue(new Callback<GetPojoInsertClient>() {
            @Override
            public void onResponse(Call<GetPojoInsertClient> call, Response<GetPojoInsertClient> response) {
                if (!response.isSuccessful()) {
                    String error = "";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json")) {
                        error = "no hay jason";

                    } else {
                        error = response.message();
                    }
                    //Log.e("Error ", error);
                    postEvent(GeneralEvent.onErrorEvent, error);
                    return;
                } else {
                    GetPojoInsertClient obRes = response.body();
                    if (obRes.getStatus().equalsIgnoreCase(NewClientsView.STATUS)) {
                        //Log.e("Eror", obRes.getMessage());
                        postEvent(GeneralEvent.onSuccesEvent, obRes.getMessage());
                    } else {
                        // Log.e
                        postEvent(GeneralEvent.onErrorEvent, "No hay respueta");
                    }
                }
            }

            @Override
            public void onFailure(Call<GetPojoInsertClient> call, Throwable t) {

            }
        });
    return true;
    }


}

