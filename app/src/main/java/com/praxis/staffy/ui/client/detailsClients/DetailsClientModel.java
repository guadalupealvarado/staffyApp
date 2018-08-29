
package com.praxis.staffy.ui.client.detailsClients;

import com.praxis.staffy.event.general.DetailsClientEvent;
import com.praxis.staffy.event.general.DetailsClientGeneral;
import com.praxis.staffy.model.DTO.ListGetDetailsClients;
import com.praxis.staffy.model.setPojoServices.SetDetailsClient;
import com.praxis.staffy.service.servicesClient.getDetailsClients.AppiGetDetailsClients;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsClientModel extends DetailsClientGeneral implements DetailsClientMvp.ClientModelInterface {
    public final static  String STATUSDETAILSCLIENT="Bienzn";
    private final AppiGetDetailsClients appiGetDetailsClients;

    public DetailsClientModel()
        {
        appiGetDetailsClients=new AppiGetDetailsClients();
        appiGetDetailsClients.initDetailsClient();
    }


    public void getDetailsClient(int id_client)
    {
        Call<ListGetDetailsClients> response=appiGetDetailsClients.servicesGetDetailsClient.
                getDetailsClients(new SetDetailsClient(String.valueOf(id_client)));
        response.enqueue(new Callback<ListGetDetailsClients>() {
            @Override
            public void onResponse(Call<ListGetDetailsClients> call, Response<ListGetDetailsClients> response) {
                if(!response.isSuccessful())
                {
                    String error = "";
                    //Se busca el error.
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json"))
                    {
                    }
                    else {
                        error = response.message();
                    }
                  postEvent(DetailsClientEvent.onErrorEvent,error);
                    return;
                }
                else
                {
                    ListGetDetailsClients listGetDetailsClients=response.body();
                    if (listGetDetailsClients!=null) {
                        postEvent(DetailsClientEvent.onSuccesEvent,listGetDetailsClients.getObjCustomerDetails());
                    }else
                    {
                        postEvent(DetailsClientEvent.onErrorEvent,"Lista vacia");
                    }
                    return;
                }
            }
            @Override
            public void onFailure(Call<ListGetDetailsClients> call, Throwable t) {
                postEvent(DetailsClientEvent.onErrorEvent,t.getLocalizedMessage());
            }
        });
    }



}
