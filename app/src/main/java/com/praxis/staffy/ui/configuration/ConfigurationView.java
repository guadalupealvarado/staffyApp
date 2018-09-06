package com.praxis.staffy.ui.configuration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.praxis.staffy.About;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.ActivityConfiguration;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainViewProfileActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentConfiguration;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ConfigurationView extends BaseView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState)
    {
        rootView = inflater.inflate(R.layout.
                        fragment_configuration, container,
                false);
        ButterKnife.bind(this,rootView);
        showToolConfiguration(rootView);
        return rootView;
    }

    private void showToolConfiguration(View view) {
        Toolbar toolbar=view.findViewById(R.id.toolbart_configuration);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Configuración");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    @Optional

   // @OnClick(R.id.btn_user_configuration)
    protected void goUser()
    {
        Intent intent=new Intent(rootView.getContext(),MainViewProfileActivity.class);
        startActivity(intent);
    }

    @Optional
    @OnClick(R.id.btn_container_about)
    protected void onClick()
    {
        goAbout(ManagerFragmentConfiguration.ABOUT);
    }

    private void goAbout(ManagerFragmentConfiguration about) {
        ActivityConfiguration.state=about;
        Intent myIntent=new Intent(rootView.getContext(), ActivityConfiguration.class);
        startActivity(myIntent);
    }


}
