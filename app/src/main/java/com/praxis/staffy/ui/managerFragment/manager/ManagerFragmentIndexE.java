package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.activities.ActivitiesView;
import com.praxis.staffy.ui.client.consultClients.ConsultClienteView;
import com.praxis.staffy.ui.configuration.ConfigurationView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.IndexView;
import com.praxis.staffy.ui.notification.NotificationView;
import com.praxis.staffy.ui.postulate.PostulanteView;
import com.praxis.staffy.ui.purse.showPurse.modifyConsult.ModifyConsultantView;

public enum ManagerFragmentIndexE {

    NOTIFICACION {
        @Override

        public Fragment execute(IndexView activity)
        {
            //Envio de fragmento, El main activity, el id donde se remplaza y el objeto del fragmento que se pondrá.
            return setFragment(activity, R.id.fragmentConteinerIndex, NotificationView.class);
        }
    },ACTIVITIES{
        @Override
        public Fragment execute(IndexView activity)

        {
            return setFragment(activity, R.id.fragmentConteinerIndex, ActivitiesView.class);
        }
    },
    CALENDAR{
        @Override
        public Fragment execute(IndexView activity)
        {
            return setFragment(activity, R.id.fragmentConteinerIndex, ModifyConsultantView.class);
        }
    },CLIENTS {
                @Override
                public Fragment execute(IndexView activity) {
                    return setFragment(activity,R.id.fragmentConteinerIndex, ConsultClienteView.class);
    }
    },CONFIGURATION
            {
                @Override
                public Fragment execute(IndexView activity) {
                    return setFragment(activity,R.id.fragmentConteinerIndex, ConfigurationView.class);

                }
            };

    public abstract Fragment execute(IndexView activity);

    //Bundle para mandar parametros
    public Bundle bundle;

    public Fragment setFragment(IndexView activity, int id, Class<? extends Fragment> fragmentclass){
        // Con Class<? extends Fragment> fragmentclass se dice que recibe de una clase que
        // debe extender de Fragment.
        try {

            // Se guarda una objeto
            //Se ponde Fragment porque debe extender de fragmento.

            //Se castea para ser un Fragmento.

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

    //?????????????????????????????????
    //Es necesario este metodo?
    public static ManagerFragmentIndexE setState(ManagerFragmentIndexE newState){
        ManagerFragmentIndexE state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }



    public ManagerFragmentIndexE setBundle(Bundle bundle)
    {
        this.bundle = bundle;
        return this;
    }
}

