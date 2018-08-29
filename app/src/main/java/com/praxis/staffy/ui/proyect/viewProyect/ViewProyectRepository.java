package com.praxis.staffy.ui.proyect.viewProyect;

import com.praxis.staffy.event.general.ProyectEvent;
import com.praxis.staffy.event.general.ProyectPostEvent;
import com.praxis.staffy.model.DTO.ListAllProject;
import com.praxis.staffy.service.Project.SelectAllProject.AppiAllProject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewProyectRepository extends ProyectPostEvent implements MVPViewProyect.RepositoryAllProyect {

    AppiAllProject appiAllProject;

    public ViewProyectRepository() {
        appiAllProject=new AppiAllProject();
        appiAllProject.init();
    }

    @Override
    public void consultAllProyecy()
    {
        Call<ListAllProject> response=appiAllProject.servicesSelectAllProject.getAllProject();
        response.enqueue(new Callback<ListAllProject>() {
            @Override
            public void onResponse(Call<ListAllProject> call, Response<ListAllProject> response) {
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
                    postEvent(ProyectEvent.onErrorEvent,error);

                    return;
                }else
                {
                    ListAllProject listAllProject=response.body();
                    if(listAllProject!=null)
                    {
                        postEvent(ProyectEvent.onSuccesEvent,listAllProject);
                    }else
                    {
                        postEvent(ProyectEvent.onErrorEvent,"No existen datos...");
                    }

                }
            }
            @Override
            public void onFailure(Call<ListAllProject> call, Throwable t) {
                postEvent(ProyectEvent.onErrorEvent,t.getMessage());
            }
        });
    }
}
