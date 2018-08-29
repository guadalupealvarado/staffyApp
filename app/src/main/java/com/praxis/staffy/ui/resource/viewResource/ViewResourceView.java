package com.praxis.staffy.ui.resource.viewResource;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityFilter;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityInterview;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainVisitsActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragment;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentFilter;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentInterview;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentVisit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewResourceView extends BaseView {


    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;



    public ViewResourceView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_view_resource, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar(rootView);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Optional
    @OnClick(R.id.btn_see_more_view_resource)
    protected void goDetailsResorce()
    {
        ((MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.SHOWDETAILSPURSE);
    }

    @Optional
    @OnClick(R.id.btn_evaluations_view_resource)
    protected void goEvaluation()
    {
        ((MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.VIEWEVALUATION);
    }

    @Optional
    @OnClick(R.id.btn_see_interview_view_resource)
    protected void goSeeVisit()
    {
        MainActivityInterview.state= ManagerFragmentInterview.SHOWITERVIEW;
        Intent intent=new Intent(rootView.getContext(), MainActivityInterview.class);
        startActivity(intent);
    }


    @Optional
    @OnClick(R.id.btn_schedule_interview_view_resource)
    protected void goNewVisit()
    {
        MainActivityInterview.state= ManagerFragmentInterview.NEWINTERVIEW;
        Intent intent=new Intent(rootView.getContext(), MainActivityInterview.class);
        startActivity(intent);
    }
    @Optional
    @OnClick(R.id.btn_new_filter_view_resource)
    protected void goShowFilter()
    {
        MainActivityFilter.state= ManagerFragmentFilter.NEWFILTER;
        Intent intent=new Intent(rootView.getContext(), MainActivityFilter.class);
        startActivity(intent);
    }



    public void showToolbar(View view) {
        //Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detalle postulado");
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


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.toolbar_modify,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_edit:
//                MainActivityPurse.state= ManagerFragmentPurse.EDITPOSTULANT;
                Intent intent=new Intent(getActivity(), MainActivityPurse.class);
                startActivity(intent);
                return false;

        }
        return super.onOptionsItemSelected(item);
    }
}
