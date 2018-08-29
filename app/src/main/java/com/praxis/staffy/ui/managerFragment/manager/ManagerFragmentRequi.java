package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainRequiActivity;
import com.praxis.staffy.ui.requisition.detailsRequisition.DetailsRequisitionView;
import com.praxis.staffy.ui.requisition.showRequi.ShowRequiView;
import com.praxis.staffy.ui.requisition.modifyRequisition.ModifyRequisitionView;
import com.praxis.staffy.ui.requisition.newRequisicion.NewRequisicionView;

public enum  ManagerFragmentRequi {

    SHOWREQUI {
        @Override
        public Fragment excute(MainRequiActivity mainRequiActivity)
        {   return setFragment(mainRequiActivity, R.id.fragment_container_requi,ShowRequiView.class); }
        },
    DETAILSREQUI {
        @Override
        public Fragment excute(MainRequiActivity mainRequiActivity) {
            return setFragment(mainRequiActivity,R.id.fragment_container_requi,DetailsRequisitionView.class);
        }
    },NEWREQUI {
        @Override
        public Fragment excute(MainRequiActivity mainRequiActivity) {
            return setFragment(mainRequiActivity, R.id.fragment_container_requi, NewRequisicionView.class);
        }
    },
    MODIFYREQUI{
        @Override
        public Fragment excute(MainRequiActivity mainRequiActivity) {
            return setFragment(mainRequiActivity, R.id.fragment_container_requi, ModifyRequisitionView.class);
        }
    };

    public abstract Fragment excute(MainRequiActivity mainRequiActivity);
    public Bundle bundle;

    public Fragment setFragment(MainRequiActivity mainRequiActivity, int id, Class<? extends Fragment> fragmentClass)
    {
        try
        {
            Fragment fragment=fragmentClass.newInstance();
            if(bundle!=null)
            {
                fragment.setArguments(bundle);
            }
            FragmentManager manager=mainRequiActivity.getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(id,fragment,fragmentClass.getCanonicalName());
            transaction.commit();
            return fragment;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return  null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ManagerFragmentRequi setState(ManagerFragmentRequi newState)
    {
        ManagerFragmentRequi state=newState;
        return state;
    }

    public Bundle getBundle()
    {
        return bundle;
    }

    public ManagerFragmentRequi setBundle(Bundle bundle)
    {
        this.bundle=bundle;
        return this;
    }
}
