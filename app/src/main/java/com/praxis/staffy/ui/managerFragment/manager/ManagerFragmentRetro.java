package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.activityViewXML.ContainerRetro;
import com.praxis.staffy.ui.retro.ViewRetro.ViewRetroView;
import com.praxis.staffy.ui.retro.newRetro.NewRetro;

public enum  ManagerFragmentRetro {

    LISTRETRO
            {
        @Override
        public Fragment execute(ContainerRetro activity)
        { return setFragment(activity, R.id.fragment_container_retro, ViewRetroView.class); }
    }
    ,NEWRETRO
            {
                @Override
                public Fragment execute(ContainerRetro activity) {
                    return  setFragment(activity, R.id.fragment_container_retro, NewRetro.class);
                }
            };

    public abstract Fragment execute(ContainerRetro activity);
    //Variables
    public Bundle bundle;

    public Fragment setFragment(ContainerRetro activity, int id, Class<? extends Fragment> fragmentclass){
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
    public static ManagerFragmentRetro setState(ManagerFragmentRetro newState){
        ManagerFragmentRetro state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentRetro setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
}