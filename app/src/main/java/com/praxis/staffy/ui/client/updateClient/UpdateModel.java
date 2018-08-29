package com.praxis.staffy.ui.client.updateClient;

import android.util.Log;

import com.praxis.staffy.event.general.client.updateclient.UpdateClientEvent;
import com.praxis.staffy.event.general.client.updateclient.UpdateClientPostEvent;
import com.praxis.staffy.model.DAO.client.CustomerDetailDAO;
import com.praxis.staffy.model.DTO.generigGetResponse.GetGeneriResponse;
import com.praxis.staffy.model.pojo.AddressCustomerDetails;
import com.praxis.staffy.model.pojo.CustomerDetails;
import com.praxis.staffy.model.setPojoServices.updateClient.setClientsUpdate;
import com.praxis.staffy.service.servicesClient.updateDetailsClient.AppiUpdateClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateModel extends UpdateClientPostEvent implements UpdateMvp.model {

    private UpdatePresenter presenter;
    private final AppiUpdateClient appiUpdateClient;

    public  UpdateModel()
    {
        appiUpdateClient=new AppiUpdateClient();
        appiUpdateClient.initUpdateClient();
    }
    @Override
    public CustomerDetails getDetailsClient(int id_client)
    {
        CustomerDetails customerDetails= CustomerDetailDAO.getInstance().searchCustomerDetails(id_client);
        return customerDetails;
    }

    @Override
    public void loadClient() {

    }

    @Override
    public void updateClient(final setClientsUpdate customerDetails, final int id_client) {
        Call<GetGeneriResponse> response=appiUpdateClient.servicesUpdateClient
                .updateClient(String.valueOf(id_client),customerDetails);
        response.enqueue(new Callback<GetGeneriResponse>() {
            @Override
            public void onResponse(Call<GetGeneriResponse> call, Response<GetGeneriResponse> response) {
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
                    //Se obtiene el error.
                    else {
                        error = response.message();
                    }
                    postEvent(UpdateClientEvent.onErrorEvent, error);
                    return;
                }else
                {
                    GetGeneriResponse obRes = response.body();
                    if (obRes.getData() != null)
                    {

                        if(CustomerDetailDAO.getInstance().getPosicion(id_client)!=-1)
                        {
                            CustomerDetailDAO.getInstance().updateCustomer(CustomerDetailDAO.getInstance().getPosicion(id_client),parseSetCustomerToCustomerDetails(id_client,customerDetails));
                            postEvent(UpdateClientEvent.onSuccesEvent,obRes);
                        }
                    }else
                    {
                        postEvent(UpdateClientEvent.onErrorEvent,"El usuario no existe. ");
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<GetGeneriResponse> call, Throwable t) {
                postEvent(UpdateClientEvent.onErrorEvent,t.getMessage());
            }
        });


    }


    private CustomerDetails parseSetCustomerToCustomerDetails(int id_client,setClientsUpdate setClientsUpdate)
    {
       CustomerDetails customerDetails=CustomerDetailDAO.getInstance().searchCustomerDetails(id_client);
       if(customerDetails!=null)
       {
           customerDetails.setNombreCliente(setClientsUpdate.getNbCliente());
           customerDetails.setLogo(setClientsUpdate.getLogo());
           customerDetails.setIdActualizacion(setClientsUpdate.getIdUsuario());

           ArrayList<AddressCustomerDetails> addressCustomerDetails=new ArrayList<>();
           AddressCustomerDetails address=new AddressCustomerDetails();

           address.setCalle(setClientsUpdate.getDirecciones().get(0).getCalle());
           address.setCodigoPostal(setClientsUpdate.getDirecciones().get(0).getCodigoPostal());
           address.setColonia(setClientsUpdate.getDirecciones().get(0).getColonia());
           address.setDelegacionMunicipio(setClientsUpdate.getDirecciones().get(0).getDelegacionMunicipio());
           address.setDirLatitud(setClientsUpdate.getDirecciones().get(0).getDirLatitud());
           address.setDirLongitud(setClientsUpdate.getDirecciones().get(0).getDirLongitud());
           address.setEstado(setClientsUpdate.getDirecciones().get(0).getEstado());
           address.setReferencia(setClientsUpdate.getDirecciones().get(0).getReferencia());
           address.setId(setClientsUpdate.getDirecciones().get(0).getId());
           address.setNumero(setClientsUpdate.getDirecciones().get(0).getNumero());

           addressCustomerDetails.add(address);
           customerDetails.setDirecciones(addressCustomerDetails);
           return customerDetails;
       }else
       {
           return null;
       }
    }


}

