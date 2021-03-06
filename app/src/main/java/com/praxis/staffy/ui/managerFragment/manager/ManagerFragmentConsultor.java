package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainConsultorActivity;
import com.praxis.staffy.ui.purse.showPurse.ShowPurseView;
import com.praxis.staffy.ui.purse.showPurse.newConsult.NewConsultantView;
import com.praxis.staffy.ui.purse.showPurse.viewConsultPurse.ViewConsultPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewConsultPurse.showConsultor;

import butterknife.ButterKnife;

public enum ManagerFragmentConsultor {

    SHOWMAIN() {
        @Override
        public Fragment execute(MainConsultorActivity activity) {
            return setFragment(activity, R.id.fragmentConteinerConsultor, ViewConsultPurseView.class);
        }
    },
    SHOWADDCONSULTER() {
        @Override
        public Fragment execute(MainConsultorActivity activity) {

            return setFragment(activity, R.id.fragmentConteinerConsultor, NewConsultantView.class);
        }

    };

    public abstract Fragment execute(MainConsultorActivity activity);

    public Bundle bundle;

    public Fragment setFragment(MainConsultorActivity activity, int id, Class<? extends Fragment> fragmentclass) {
        try {
            Fragment newFragment = fragmentclass.newInstance();
            if (bundle != null) {
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

    public static ManagerFragmentConsultor setState(ManagerFragmentConsultor newState) {
        ManagerFragmentConsultor state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentConsultor setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }


}
