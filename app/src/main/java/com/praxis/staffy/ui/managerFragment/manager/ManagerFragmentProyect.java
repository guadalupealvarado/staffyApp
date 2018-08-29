package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.proyect.ContainerProyect;
import com.praxis.staffy.ui.proyect.newProyect.NewProyectView;
import com.praxis.staffy.ui.proyect.editProyect.EditProyectView;
import com.praxis.staffy.ui.proyect.detailsProyect.DetailsProyectView;
import com.praxis.staffy.ui.proyect.viewProyect.ViewListProyect;
import com.praxis.staffy.ui.purse.showPurse.modifyConsult.ModifyConsultantView;
import com.praxis.staffy.ui.purse.showPurse.newConsult.NewConsultantView;

public enum     ManagerFragmentProyect {

    NEWPROYECT {
        @Override
        public Fragment execute(ContainerProyect activity)
        { return setFragment(activity, R.id.fragmentConteinerProyect, NewProyectView.class); }
    },
    BORRARSOLOESEJEMPLO{
        @Override
        public Fragment execute(ContainerProyect activity)
        { return setFragment(activity, R.id.fragmentConteinerProyect, ModifyConsultantView.class); }
    },

    INFOPROYECT {
        @Override
        public Fragment execute(ContainerProyect activity) {
            return setFragment(activity, R.id.fragmentConteinerProyect, DetailsProyectView.class);
        }
    },
    EDITPORYECT {
        @Override
        public Fragment execute(ContainerProyect activity) {
            return setFragment(activity, R.id.fragmentConteinerProyect, EditProyectView.class);
        }
    },
    MAINPROYECT {
        @Override
        public Fragment execute(ContainerProyect activity) {
            return setFragment(activity, R.id.fragmentConteinerProyect, ViewListProyect.class);
        }
    },NEWCONTACT
            {
                @Override
                public Fragment execute(ContainerProyect activity) {
                    return  setFragment(activity, R.id.fragmentConteinerProyect, NewConsultantView.class);
                }
            };

    public abstract Fragment execute(ContainerProyect activity);
    //Variables
    public Bundle bundle;

    public Fragment setFragment(ContainerProyect activity, int id, Class<? extends Fragment> fragmentclass){
        try {
            Fragment newFragment = fragmentclass.newInstance();
            if(bundle != null){
                newFragment.setArguments(bundle);
            }
            FragmentManager manager = activity.getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(id, newFragment, fragmentclass.getCanonicalName());
            transaction.commit();
            return newFragment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static ManagerFragmentProyect setState(ManagerFragmentProyect newState){
        ManagerFragmentProyect state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentProyect setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
}