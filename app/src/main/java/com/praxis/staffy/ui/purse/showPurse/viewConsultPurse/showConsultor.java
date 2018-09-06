package com.praxis.staffy.ui.purse.showPurse.viewConsultPurse;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.DetailsPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.ViewPostulanPurseView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class showConsultor extends BaseView {
    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_view_consult_purse_view, container, false);
        ButterKnife.bind(this, rootView);
        changeFragment(ViewConsultPurseView.class);
        showToolbar();

        return rootView;
    }

    public void goDetilsResource(int id_position) {
        Bundle bundle = new Bundle();
        bundle.putInt(DetailsPurseView.POSICIONRESOURCE, id_position);
        MainActivityPurse.state = ManagerFragmentPurse.SHOWDETAILSPURSE.setBundle(bundle);
        Intent intent = new Intent(rootView.getContext(), MainActivityPurse.class);
        startActivity(intent);
    }

    public void showToolbar()
    {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Consultor");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }


    public void changeFragment(Class<? extends Fragment> fragmentclass)
    {
        Fragment newFragment = null;
        try {
            newFragment = fragmentclass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragmentConteinerViewConsultor,
                newFragment, fragmentclass.getCanonicalName());
        transaction.commit();
    }

}
