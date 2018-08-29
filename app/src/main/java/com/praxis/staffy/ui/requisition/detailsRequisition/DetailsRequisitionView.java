package com.praxis.staffy.ui.requisition.detailsRequisition;


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
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class DetailsRequisitionView extends BaseView {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_show_details_requi, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar(rootView);
        setHasOptionsMenu(true);
        return rootView;
    }

    @Optional
    @OnClick(R.id.btn_see_postulados_details_requi)
    protected void goToPostulant()
    {
        MainActivityPurse.state= ManagerFragmentPurse.POSTULANT_RESOURCE;
        Intent intent=new Intent(getActivity(), MainActivityPurse.class);
        startActivity(intent);
    }

    @Optional
    @OnClick(R.id.btn_postular_details_requi)
    protected void goToPostulantResource()
    {
        MainActivityPurse.state= ManagerFragmentPurse.SHOWPOSTULANTS;
        // MainActivityPurse.nameToolBar="Postulados";
        Intent intent=new Intent(getActivity(), MainActivityPurse.class);
        startActivity(intent);
    }

    public void showToolbar(View view) {
        //Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Evaluaciones");
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
                Toast.makeText(getContext(), "se elemino", Toast.LENGTH_SHORT)
                        .show();
                return false;

        }
        return super.onOptionsItemSelected(item);
    }


}
