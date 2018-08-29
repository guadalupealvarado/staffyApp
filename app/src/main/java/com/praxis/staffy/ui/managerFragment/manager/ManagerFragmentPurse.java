package com.praxis.staffy.ui.managerFragment.manager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.candidate.newCandidate.NewCandidateView;
import com.praxis.staffy.ui.postulant.PostulantsView;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.DetailsPurseView;
import com.praxis.staffy.ui.purse.showPurse.toosResource.ToosResourceView;
import com.praxis.staffy.ui.purse.showPurse.viewFormatResource.FormatResourceView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.ViewPostulanPurseView;
import com.praxis.staffy.ui.resource.viewResource.ViewResourceView;
import com.praxis.staffy.ui.toAssign.AsigExpertView;
import com.praxis.staffy.ui.evaluations.viewresourceAssessments.ResourceAssessmentsView;
import com.praxis.staffy.ui.evaluations.viewresourceAssessments.deatilsResourceAssesments.DetailsResourceAssessmentsView;
import com.praxis.staffy.ui.evaluations.viewresourceAssessments.editEvaluationResource.EditEvaluationView;
import com.praxis.staffy.ui.evaluations.viewresourceAssessments.registerEvaluation.RegisterEvaluationView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.postulate.PostulanteView;
import com.praxis.staffy.ui.purse.showPurse.ShowPurseView;
import com.praxis.staffy.ui.purse.showPurse.modifyConsult.ModifyConsultantView;
import com.praxis.staffy.ui.requests.format.editFormat.EditFormatView;
import com.praxis.staffy.ui.requests.tools.editTools.EditToolsView;

public enum ManagerFragmentPurse {

    SHOWPURSE() {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, ShowPurseView.class);
        }
    },
    SHOWDETAILSPURSE() {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, DetailsPurseView.class);
        }
    }, SHOWPOSTULANTS {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, PostulantsView.class);
        }
    }, SHOWRESOURCEPOSTULANT {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, ViewResourceView.class);
        }
    }, VIEWEVALUATION {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, ResourceAssessmentsView.class);
        }
    }, DETAILSEVALUATIONRESOURCE {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, DetailsResourceAssessmentsView.class);
        }
    }, NEWEVALUATIONRESOURCE {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, RegisterEvaluationView.class);
        }
    }, EDITEVALUATION {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, EditEvaluationView.class);
        }
    },
    ADDPOSTULADO {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, NewCandidateView.class);
        }
    },

    ASSIGNKNOWLEDGE {
        @Override
        public Fragment execute(MainActivityPurse activity) {
            return setFragment(activity, R.id.fragmentConteinerPurse, AsigExpertView.class);
        }
    },
    EDITPOSTULANT
            {
                @Override
                public Fragment execute(MainActivityPurse activity) {

                    return setFragment(activity,R.id.fragmentConteinerPurse,ModifyConsultantView.class);

                }
            }
    ,POSTULANT_RESOURCE
            {
                @Override
                public Fragment execute(MainActivityPurse activity) {

                    return setFragment(activity,R.id.fragmentConteinerPurse,PostulanteView.class);
                }
            },SHOWTOOLRESOURCE
            {
                @Override
                public Fragment execute(MainActivityPurse activity) {
                    return setFragment(activity,R.id.fragmentConteinerPurse,ToosResourceView.class);
                }
            },SHOWFORMATRESOURCE
            {
                @Override
                public Fragment execute(MainActivityPurse activity) {
                    return setFragment(activity,R.id.fragmentConteinerPurse,FormatResourceView.class);

                }
            },
            EDITFORMAT
            {
                @Override
                public Fragment execute(MainActivityPurse activity) {
                    return setFragment(activity,R.id.fragmentConteinerPurse, EditFormatView.class);
                }
            },
            EDITTOOLS
            {
                @Override
                public Fragment execute(MainActivityPurse activity) {
                    return setFragment(activity,R.id.fragmentConteinerPurse, EditToolsView.class);
                }
            };

    public abstract Fragment execute(MainActivityPurse activity);
    public Bundle bundle;

    public Fragment setFragment(MainActivityPurse activity, int id, Class<? extends Fragment> fragmentclass)
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

    public static ManagerFragmentPurse setState(ManagerFragmentPurse newState)
    {
        ManagerFragmentPurse state = newState;
        return state;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public ManagerFragmentPurse setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }
    }
