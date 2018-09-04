package com.praxis.staffy.ui.purse.showPurse.viewConsultPurse;

import com.praxis.staffy.event.general.Example.PurseEventGeneral;
import com.praxis.staffy.model.DAO.purse.PurseDAO;
import com.praxis.staffy.model.DTO.ListPurse;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.service.servicePurse.AppiServicePurse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewConsultModel extends PurseEventGeneral implements ViewConsultMVP.ViewConsultPurseModel {
    public final static String STATEEVENTBUSPURSE="PURSESHOW";
    private final AppiServicePurse appiServicePurse;

    public ViewConsultModel() {
        appiServicePurse=new AppiServicePurse();
        appiServicePurse.initApiServices();
    }

    @Override
    public void initShowAllPurse() {
        Call<ListPurse> response=appiServicePurse.servicesPurse.showPostPurse();
        response.enqueue(new Callback<ListPurse>() {
            @Override
            public void onResponse(Call<ListPurse> call, Response<ListPurse> response) {
                if(!response.isSuccessful())
                {
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
                }else
                {
                    ListPurse listPurse=response.body();
                    if(listPurse.getData().size()!=0)
                    {
                        postEvent(purseGeneralEvent.onSuccesEvent,listPurse);
                    }else
                    {
                        postEvent(purseGeneralEvent.onErrorEvent,"Lista vacia");
                    }
                    return;
                }
            }
            @Override
            public void onFailure(Call<ListPurse> call, Throwable t) {
                postEvent(purseGeneralEvent.onErrorEvent,t.getMessage());
            }
        });
    }

    @Override
    public void saveInDAO(List<InfoRecursoPurse> infoRecursoPurseList) {
        PurseDAO.getInstance().setAllResourcePurse(infoRecursoPurseList);
    }
}
