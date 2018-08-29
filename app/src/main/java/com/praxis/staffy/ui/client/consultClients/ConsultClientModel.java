package com.praxis.staffy.ui.client.consultClients;


import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.event.general.PostEventGeneral;
import com.praxis.staffy.model.DAO.client.ClientDAO;
import com.praxis.staffy.model.DTO.ListClient;
import com.praxis.staffy.service.servicesClient.AppiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsultClientModel extends PostEventGeneral implements ClienteMVP.model
{
    public static String POJOSHOWCLIENT="CONSULTCLIENT22";
    private final AppiClient appiClient;

    public ConsultClientModel()
    {
        appiClient=new AppiClient();
        appiClient.initClient();
    }

    @Override
    public void getAllClient()
    {
        GeneralEvent.POJO=ConsultClientModel.POJOSHOWCLIENT;
        Call<ListClient> response=appiClient.servicesClient.getAllClient();
        response.enqueue(new Callback<ListClient>()
        {
            @Override
            public void onResponse(Call<ListClient> call, Response<ListClient> response) {
                if(!response.isSuccessful())
                {
                    String error = "";
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json"))
                    {
                    }
                    else {
                        error = response.message();
                    }
                    postEvent(GeneralEvent.onErrorEvent, error);
                    return;
                }else
                {
                    ListClient listClient=response.body();
                    if(listClient.getList().size()!=0) {
                        if (!listClient.getList().get(0).getNombreCliente().isEmpty()) {
                            ClientDAO.getInstance().setAllClient(listClient.getList());
                            postEvent(GeneralEvent.onSuccesEvent, listClient);
                        } else {
                            postEvent(GeneralEvent.onErrorEvent,"Lista vacia.");
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<ListClient> call, Throwable t) {
            postEvent(GeneralEvent.onErrorEvent,t.getLocalizedMessage()); }
        });
    }
}
