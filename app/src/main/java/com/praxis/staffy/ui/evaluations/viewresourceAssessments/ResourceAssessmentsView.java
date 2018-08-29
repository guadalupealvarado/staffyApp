package com.praxis.staffy.ui.evaluations.viewresourceAssessments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class ResourceAssessmentsView extends BaseView {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_view_resource_assessments, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar();
        return rootView;
        //new
    }

    @Optional
    @OnClick(R.id.contrainer_btn_assessment)
    protected void goDetailsEvaluation()
    {
        ((MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.DETAILSEVALUATIONRESOURCE);
    }

    @Optional
    @OnClick(R.id.btn_floating_add_assessment)
    protected void goNewEvaluation()
    {
        ((MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.NEWEVALUATIONRESOURCE);
    }


    public void showToolbar() {
        //Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detalle requi");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }
}
