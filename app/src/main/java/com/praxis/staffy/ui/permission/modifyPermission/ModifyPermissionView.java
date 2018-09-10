package com.praxis.staffy.ui.permission.modifyPermission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;
import com.praxis.staffy.ui.requests.ContainerRequest;

public class ModifyPermissionView extends BaseView {
public ManagerFragmentRequest states;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.
                        fragment_modify_permiso, container,
                false);
       showToolbar(rootView);
        return rootView;
    }
    public void showToolbar( View view)
    {//
        Toolbar toolbar=view.findViewById(R.id.permitsModifyTool);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Modificar Permiso");
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goPermiss();
            }
        });
    }
    public void changeFragment(ManagerFragmentRequest states){
        this.states=ManagerFragmentRequest.setState(states);
        this.states.execute((ContainerRequest) getContext());

    }
    private void goPermiss() {
        changeFragment(ManagerFragmentRequest.SHOWPERMIST);
    }
}
