package com.praxis.staffy.ui.visits.detailsVisit;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainVisitsActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentVisit;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailsVisitView extends BaseView {


    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_view_see_visit, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar(rootView);
        setHasOptionsMenu(true);
        return rootView;
    }



    public void showToolbar(View view) {
        //Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Ver visita");
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
                MainVisitsActivity.state= ManagerFragmentVisit.EDITVISIT;
                Intent intent=new Intent(rootView.getContext(), MainVisitsActivity.class);
                startActivity(intent);
                return false;

        }
        return super.onOptionsItemSelected(item);
    }

}
