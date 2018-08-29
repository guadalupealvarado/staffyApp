package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.user.showProfileUser.ShowUserProfileView;
import com.praxis.staffy.ui.user.listUser.ListUserView;
import com.praxis.staffy.ui.user.modifyUser.ModifyUserView;
import com.praxis.staffy.ui.user.newUser.NewUserView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainViewProfileActivity;

public enum ManagerFragmentViewUser {

    SEEALLUSER
            {
                @Override
                public Fragment execute(MainViewProfileActivity activity) {
                    return setFragment(activity, R.id.fragment_container_view_profile,ListUserView.class);

                }
            },MODIFYUSER
            {
                @Override
                public Fragment execute(MainViewProfileActivity activity) {
                    return setFragment(activity, R.id.fragment_container_view_profile,ModifyUserView.class);

                }
            },NEWUSER
            {
                @Override
                public Fragment execute(MainViewProfileActivity activity) {
                    return setFragment(activity, R.id.fragment_container_view_profile,NewUserView.class);

                }
            },
    VIEWPROFILE{
        @Override
        public Fragment execute(MainViewProfileActivity activity) {
            return setFragment(activity, R.id.fragment_container_view_profile,ShowUserProfileView.class);
        }
    };

    public abstract Fragment execute(MainViewProfileActivity activity);
    public Bundle bundle;

    public Fragment setFragment(MainViewProfileActivity activity,
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

    public static ManagerFragmentViewUser setState(ManagerFragmentViewUser newState){
        ManagerFragmentViewUser state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }


    public ManagerFragmentViewUser setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
}
