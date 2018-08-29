package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.client.consultClients.ConsultClienteView;
import com.praxis.staffy.ui.client.detailsClients.DetailClientsView;
import com.praxis.staffy.ui.client.newClient.NewClientsView;
import com.praxis.staffy.ui.client.updateClient.UpdateClientView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainClientActivity;
import com.praxis.staffy.ui.proyect.newProyect.NewProyectView;


public enum     ManagerFragmentClient {

    NEWCLIENTS {
        @Override
        public Fragment execute(MainClientActivity activity)
        { return setFragment(activity, R.id.fragmentConteinerClient,NewClientsView.class); }
    },
    NEWPROYECT {
        @Override
        public Fragment execute(MainClientActivity activity)
        { return setFragment(activity, R.id.fragmentConteinerClient, NewProyectView.class); }
    },
    UPDATECLIENT {
        @Override
        public Fragment execute(MainClientActivity activity) {
            return setFragment(activity, R.id.fragmentConteinerClient, UpdateClientView.class);
        }
    },CONSULTCLIENT{
        @Override
        public Fragment execute(MainClientActivity activity) {
            return setFragment(activity,R.id.fragmentConteinerClient, ConsultClienteView.class);
        }
    },DETAILSCLIENTS
    {
        @Override
        public Fragment execute(MainClientActivity activity) {
            return setFragment(activity,R.id.fragmentConteinerClient,DetailClientsView.class);

     }
    };

    public abstract Fragment execute(MainClientActivity activity);
    //Variables
    public Bundle bundle;

    public Fragment setFragment(MainClientActivity activity, int id, Class<? extends Fragment> fragmentclass){
        try {
            Fragment newFragment = fragmentclass.newInstance();
            //sí el bundle no es nulo
            if(bundle != null){
                //Del nuevo fragmento
                newFragment.setArguments(bundle);
            }
            // se crea un Manager para enviar el soporte.
            FragmentManager manager = activity.getSupportFragmentManager();
            // encarga de la transición.
            FragmentTransaction transaction = manager.beginTransaction();
            //ID de donde se va a remplazar, el nuevo fragmento, el nombre
            //transaction.replace(id, newFragment, fragmentclass.getCanonicalName());
            transaction.replace(id, newFragment, fragmentclass.getCanonicalName());
            transaction.commit();
            return newFragment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ManagerFragmentClient setState(ManagerFragmentClient newState){
        ManagerFragmentClient state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentClient setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
}