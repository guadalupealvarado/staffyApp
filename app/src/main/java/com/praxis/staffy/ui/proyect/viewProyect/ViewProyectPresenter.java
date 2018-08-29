package com.praxis.staffy.ui.proyect.viewProyect;

import com.praxis.staffy.event.general.GeneralEvent;
import com.praxis.staffy.event.general.ProyectEvent;
import com.praxis.staffy.helper.EventbusHelperImp;
import com.praxis.staffy.helper.EventbusInterface;
import com.praxis.staffy.model.DAO.Proyect.ProyectDAO;
import com.praxis.staffy.model.DTO.ListAllProject;
import org.greenrobot.eventbus.Subscribe;

public class ViewProyectPresenter implements MVPViewProyect.PresenterAllProyect{

    private EventbusInterface eventbus;
    private MVPViewProyect.ViewAllProyect viewAllProyect;
    public ViewProyectRepository repositoryAllProyect;


    public ViewProyectPresenter(MVPViewProyect.ViewAllProyect viewAllProyect)
    {
        this.eventbus = EventbusHelperImp.getInstance();
        this.viewAllProyect=viewAllProyect;
        repositoryAllProyect=new ViewProyectRepository();
    }

    @Override
    public void onCreate() {
        eventbus.register(this);
    }

    @Override
    public void onDestroy() {
        eventbus.unregister(this);
    }

    @Subscribe
    @Override
    public void onEventMainThread(ProyectEvent proyectPostEvent) {

        if(proyectPostEvent != null){
            switch (proyectPostEvent.getEventType()) {

                case GeneralEvent.onSuccesEvent:
                    ListAllProject listAllProject=proyectPostEvent.getObject();
                    ProyectDAO.getInstance().setProjectArrayList(listAllProject.getProjectArrayList());
                    for(int a=0;a<listAllProject.getProjectArrayList().size()
                            ;a++)
                    {
                        if(listAllProject.getProjectArrayList()
                                .get(a).getEstatusProyecto().equalsIgnoreCase("Por iniciar"))
                        {
                            viewAllProyect.addPorIniciar(listAllProject.getProjectArrayList().get(a).getNbProyecto());
                        }else if(listAllProject.getProjectArrayList()
                                .get(a).getEstatusProyecto().equalsIgnoreCase("Iniciado"))
                        {
                            viewAllProyect.addIniciado(listAllProject.getProjectArrayList().get(a).getNbProyecto());
                        }else if(listAllProject.getProjectArrayList()
                                .get(a).getEstatusProyecto().equalsIgnoreCase("Finalizado"))
                        {
                            viewAllProyect.addFinalizado(listAllProject.getProjectArrayList().get(a).getNbProyecto());
                        }else
                        {
                            viewAllProyect.showMessage("No pertenece a ninguna sección.");
                        }
                    }
                    viewAllProyect.listProyect();
                    break;

                    case GeneralEvent.onErrorEvent:
                        viewAllProyect.showMessage(proyectPostEvent.getShowMessage());
                        break;
            }
        }


    }

    @Override
    public void consultAllProyecy() {
        repositoryAllProyect.consultAllProyecy();
        viewAllProyect.showLoading();
    }
}
