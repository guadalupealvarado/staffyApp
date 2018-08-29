package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainVisitsActivity;
import com.praxis.staffy.ui.visits.detailsVisit.DetailsVisitView;
import com.praxis.staffy.ui.visits.newVisit.NeewVisitView;
import com.praxis.staffy.ui.visits.editVisit.EditVisitView;

public enum  ManagerFragmentVisit {

    //
    SEEVISIT
            {
                @Override
                public Fragment execute(MainVisitsActivity activity) {
                    return setFragment(activity,R.id.fragment_container_visit,DetailsVisitView.class);
                }
            },
    NEWVISIT
            {
                @Override
                public Fragment execute(MainVisitsActivity activity) {
                    return setFragment(activity,R.id.fragment_container_visit,NeewVisitView.class);
                }
            }
            ,EDITVISIT
            {
                @Override
                public Fragment execute(MainVisitsActivity activity) {
                    return setFragment(activity,R.id.fragment_container_visit,EditVisitView.class);
                }
            };

    public abstract Fragment execute(MainVisitsActivity activity);
    private Bundle bundle;

    public  Fragment setFragment(MainVisitsActivity activity, int id, Class<? extends Fragment> fClass)
    {
        try
        {
           Fragment newFragment=fClass.newInstance();
           if(bundle!=null)
           {
               newFragment.setArguments(bundle);
           }
            FragmentManager manager=activity.getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(id,newFragment,fClass.getCanonicalName());
            transaction.commit();
            return newFragment;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static ManagerFragmentVisit setState(ManagerFragmentVisit state)
    {
        ManagerFragmentVisit newState=state;
        return newState;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentVisit setBundle(Bundle bundle)
    {
        this.bundle =bundle;
        return this;
    }
}
