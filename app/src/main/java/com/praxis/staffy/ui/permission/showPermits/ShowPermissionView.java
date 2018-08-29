package com.praxis.staffy.ui.permission.showPermits;

import android.os.Bundle;
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
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;
import com.praxis.staffy.ui.requests.ContainerRequest;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ShowPermissionView extends BaseView {


    public static ManagerFragmentRequest states;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.
                        fragment_permisos, container,
                false);
        showToolbar(rootView);
        ButterKnife.bind(this,rootView);
        setHasOptionsMenu(true);
        return rootView;
    }
    public void showToolbar( View view)
    {//
        Toolbar toolbar=view.findViewById(R.id.permitsTool);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Permisos");
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
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.toolbart_permits,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editarPermits:
                changeFragment(ManagerFragmentRequest.MODIFYPERMIST);
                // Not implemented here
                return false;

        }

        return super.onOptionsItemSelected(item);
    }


    private void changeFragment(ManagerFragmentRequest states) {
        this.states = ManagerFragmentRequest.setState(states);
        this.states.execute((ContainerRequest) getContext());
    }



   @Optional
    @OnClick(R.id.fd_addpermits_fragment_permits)
    protected void goNewPermist() {
       changeFragment(ManagerFragmentRequest.NEWPERMIST);
   }
}
