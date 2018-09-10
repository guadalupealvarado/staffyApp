package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.permission.modifyPermission.ModifyPermissionView;
import com.praxis.staffy.ui.permission.newPermission.NewPermissionView;
import com.praxis.staffy.ui.permission.showPermits.ShowPermissionView;
import com.praxis.staffy.ui.proyect.editProyect.EditProyectView;
import com.praxis.staffy.ui.requests.ContainerRequest;
import com.praxis.staffy.ui.requests.viewRequest.ViewRequestView;
import com.praxis.staffy.ui.requests.format.newFormat.NewFormatView;
import com.praxis.staffy.ui.requests.tools.newTools.NewToolsView;

public enum ManagerFragmentRequest {



        TOOL {
            @Override
            public Fragment execute(ContainerRequest activity)
            { return setFragment(activity, R.id.fragmentConteinerRequest, NewToolsView.class); }
        },
        FORMAT {
            @Override
            public Fragment execute(ContainerRequest activity) {
                return setFragment(activity, R.id.fragmentConteinerRequest, NewFormatView.class);
            }
        },
        EDITPORYECT {
            @Override
            public Fragment execute(ContainerRequest activity) {
                return setFragment(activity, R.id.fragmentConteinerRequest, EditProyectView.class);
            }
        },
    NEWPERMIST {
        @Override
        public Fragment execute(ContainerRequest activity) {
            return setFragment(activity, R.id.fragmentConteinerRequest, NewPermissionView.class);
        }
    },
    SHOWPERMIST {
        @Override
        public Fragment execute(ContainerRequest activity) {
            return setFragment(activity, R.id.fragmentConteinerRequest, ShowPermissionView.class);
        }
    },
    MODIFYPERMIST {
        @Override
        public Fragment execute(ContainerRequest activity) {
            return setFragment(activity, R.id.fragmentConteinerRequest,ModifyPermissionView.class);
        }
        },


        VIEWREQUEST {
            @Override
            public Fragment execute(ContainerRequest activity) {
                return setFragment(activity, R.id.fragmentConteinerRequest, ViewRequestView.class);

            }
        };

        public abstract Fragment execute(ContainerRequest activity);
        //Variables
        public Bundle bundle;

        public Fragment setFragment(ContainerRequest activity, int id, Class<? extends Fragment> fragmentclass)
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
        public static ManagerFragmentRequest setState(ManagerFragmentRequest newState){
            ManagerFragmentRequest state = newState;
            return state;
        }

        public Bundle getBundle() {
            return bundle;
        }

        public ManagerFragmentRequest setBundle(Bundle bundle) {
            this.bundle = bundle;
            return this;
        }
    }

