package com.praxis.staffy.ui.requisition.showRequi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainRequiActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequi;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ShowRequiView extends BaseView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       rootView= inflater.inflate(R.layout.fragment_show_requi, container, false);
        showToobar("Sistema detallista",rootView);
        ButterKnife.bind(this,rootView);
       return rootView;
    }

    @Optional
    @OnClick(R.id.btn_one_requi)
    protected void goDetailsClient()
    {
        ((MainRequiActivity) activity).changeFragment(ManagerFragmentRequi.DETAILSREQUI);
    }


    private void showToobar(String nameProyect,View view)
    {
        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar ab =((AppCompatActivity) getActivity()).getSupportActionBar();
        ab.setTitle(nameProyect);
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }


    @Optional
    @OnClick(R.id.btn_floating_add_requi)
    protected void newRequi()
    {
        ((MainRequiActivity) getActivity()).changeFragment(ManagerFragmentRequi.NEWREQUI);
    }

}
