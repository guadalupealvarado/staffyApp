package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.praxis.staffy.R;

import com.praxis.staffy.ui.interview.modifyInterview.ModifyInterviewView;
import com.praxis.staffy.ui.interview.newInterview.NewInterviewView;
import com.praxis.staffy.ui.interview.showInterviewView.ShowInterviewView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityInterview;


public enum  ManagerFragmentInterview {
    SHOWITERVIEW {
        @Override
        public Fragment execute(MainActivityInterview activity)
        { return setFragment(activity, R.id.fragmentConteinerInterview, ShowInterviewView.class); }
    },
    NEWINTERVIEW{
        @Override
        public Fragment execute(MainActivityInterview activity) {
            return setFragment(activity, R.id.fragmentConteinerInterview, NewInterviewView.class) ;
        }
    },
    MODIFYINTERVIEW{
        @Override
        public Fragment execute(MainActivityInterview activity) {
            return setFragment(activity, R.id.fragmentConteinerInterview, ModifyInterviewView.class);
        }
    };

    public abstract Fragment execute(MainActivityInterview activity);
    //Variables
    public Bundle bundle;

    public android.support.v4.app.Fragment setFragment(MainActivityInterview activity, int id, Class<? extends Fragment> fragmentclass)
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
    public static ManagerFragmentInterview setState(ManagerFragmentInterview state)
    {
        ManagerFragmentInterview newState=state;
        return newState;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentInterview setBundle(Bundle bundle)
    {
        this.bundle =bundle;
        return this;
    }
}
