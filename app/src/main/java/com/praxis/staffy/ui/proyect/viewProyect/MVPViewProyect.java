package com.praxis.staffy.ui.proyect.viewProyect;

import com.praxis.staffy.event.general.ProyectEvent;

public interface MVPViewProyect {
    public interface ViewAllProyect
    {
        void showLoading();
        void hiddenLoading();
        void showMessage(String msj);
        void addPorIniciar(String iniciar);
        void addIniciado(String iniciado);
        void addFinalizado(String finalizado);
        void listProyect();
    }
    public interface PresenterAllProyect
    {
        void onCreate();
        void onDestroy();
        void onEventMainThread(ProyectEvent proyectPostEvent);
        void consultAllProyecy();

    }
    public interface RepositoryAllProyect
    {
        void consultAllProyecy();
    }
}
