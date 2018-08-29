package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.filter.modifyFilter.ModifyFilterView;
import com.praxis.staffy.ui.filter.modifyFilter.newFilter.NewFiltterView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityFilter;

public enum  ManagerFragmentFilter {

    NEWFILTER{
        @Override
        public Fragment execute(MainActivityFilter activity) {
            return setFragment(activity, R.id.fragmentConteinerFilter, NewFiltterView.class) ;
        }
    },
    MODIFYFILTER{
        @Override
        public Fragment execute(MainActivityFilter activity) {
            return setFragment(activity, R.id.fragmentConteinerFilter, ModifyFilterView.class);
        }
    };

    public abstract Fragment execute(MainActivityFilter activity);
    //Variables
    public Bundle bundle;

    public android.support.v4.app.Fragment setFragment(MainActivityFilter activity, int id, Class<? extends Fragment> fragmentclass)
    {
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
    public static ManagerFragmentFilter setState(ManagerFragmentFilter state)
    {
        ManagerFragmentFilter newState=state;
        return newState;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentFilter setBundle(Bundle bundle)
    {
        this.bundle =bundle;
        return this;
    }
}
