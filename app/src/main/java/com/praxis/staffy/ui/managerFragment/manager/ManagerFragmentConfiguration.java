package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.About;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.configuration.ConfigurationView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.ActivityConfiguration;

public enum  ManagerFragmentConfiguration {
    VIEWCONFIGURATION()
            {
                @Override
                public Fragment execute(ActivityConfiguration activity) {
                    return setFragment(activity, R.id.id_container_fragment_configuration,ConfigurationView.class);
                }
            },ABOUT()
            {
                @Override
                public Fragment execute(ActivityConfiguration activity) {
                    return setFragment(activity, R.id.id_container_fragment_configuration,
                            About.class);

                }
            };

    public abstract Fragment execute(ActivityConfiguration activity);
    public Bundle bundle;

    public Fragment setFragment(ActivityConfiguration activity,
                                int id, Class<? extends Fragment> fragmentclass){
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

    public static ManagerFragmentConfiguration setState(ManagerFragmentConfiguration newState){
        ManagerFragmentConfiguration state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentConfiguration setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
}

