package com.praxis.staffy.ui.purse.showPurse.detailsPurse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.praxis.staffy.event.general.Example.PurseEventGeneral;
import com.praxis.staffy.event.general.PurseInfoGeneralEvent;
import com.praxis.staffy.model.DAO.purse.PurseDAO;
import com.praxis.staffy.model.DTO.listInfoPurse;
import com.praxis.staffy.model.pojo.Purse.purseInfoGeneral;
import com.praxis.staffy.model.setPojoServices.setInfoPurse;
import com.praxis.staffy.service.serviceInfoPurse.ApiServiceInfoPurse;

import java.util.List;

public class detailsPurseModel extends PurseEventGeneral implements detailsPurseMVP.modelInfoPurse {
    private  final ApiServiceInfoPurse apiServiceInfoPurse;
    private DetailsPurseView view;
    public detailsPurseModel() {
        this.apiServiceInfoPurse = new ApiServiceInfoPurse();
        apiServiceInfoPurse.initApiServices();
    }

    @Override
    public void initShowAllPurse() {
        Call <listInfoPurse> response = apiServiceInfoPurse.serviceInfoPurse.showInfoPurse(new setInfoPurse(
                "3"
        ));

        response.enqueue(new Callback<listInfoPurse>() {
            @Override
            public void onResponse(Call<listInfoPurse> call, Response<listInfoPurse> response) {
                if (!response.isSuccessful()){
                    String error="";
                    if(response.errorBody().
                            contentType().
                            subtype().equals("application/json"))
                    {

                    }else
                    {
                        error=response.message();
                    }
                    postEvent(purseGeneralEvent.onErrorEvent,error);
                    return;
                }else{
                    listInfoPurse listInfoPurse=response.body();


                    if(listInfoPurse.getData().size()!=0)
                    {
                        postEvent(PurseInfoGeneralEvent.onSuccesEvent, listInfoPurse);
                        PurseDAO.getInstance().setInfoResourcePurse(listInfoPurse.getData());

                    }else
                    {
                        postEvent(purseGeneralEvent.onErrorEvent,"Lista vacia");
                    }
                    return;
                }
            }

            @Override
            public void onFailure(Call<listInfoPurse> call, Throwable t) {
                postEvent(purseGeneralEvent.onErrorEvent,t.getMessage());
            }
        });

    }

    @Override
    public void saveInDAO(List<purseInfoGeneral> infoPurses) {
        PurseDAO.getInstance().setInfoResourcePurse(infoPurses);

    }


}
