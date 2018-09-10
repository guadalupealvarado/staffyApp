package com.praxis.staffy.ui.permission.newPermission;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.support.v7.widget.Toolbar;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;
import com.praxis.staffy.ui.requests.ContainerRequest;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;


public class NewPermissionView extends BaseView {
    public ManagerFragmentRequest states;
    @Nullable
    @BindView(R.id.ed_initialdate_fragment_new_permits)
    EditText edi_initialdate_fragment_newPermits;
    @Nullable
    @BindView(R.id.ed_finaldate_fragment_new_permits)
    EditText edi_final_new_permits;
    @Nullable
    @BindView(R.id.ed_reason_fragment_new_permits)
    EditText edi_reason_fragment_newpermits;
    @Nullable
    @BindView(R.id.ed_sendemail_fragment_new_permits)
    EditText edi_sendmail_fragment_newpermits;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.
                        fragment_new_permiso, container,
                false);
        shoToolPermits(rootView);
        return rootView;
    }

    private void shoToolPermits(View view) {
        Toolbar toolbar = view.findViewById(R.id.newPermitsTool);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Nuevo Permiso");
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

    @Optional
   @OnClick(R.id.bt_acept_fragment_new_permist)
   public void sendNewPermits(){
        String error="";
        String initialdate= edi_initialdate_fragment_newPermits.getText().toString().toLowerCase().trim();
        Log.e("Mira",initialdate);

        if (initialdate.isEmpty()) {
            error="Ingresa la fecha de inicio";
            Log.e("shshs","www");
        }
        String finaldate= edi_final_new_permits.getText().toString().toLowerCase().trim();
        if (finaldate.isEmpty()) {
            error="Ingresa la fecha final";
        }
        String reason= edi_reason_fragment_newpermits.getText().toString().toLowerCase().trim();
        if (reason.isEmpty()) {
            error="Ingresa el motivo";
        }
        String email= edi_sendmail_fragment_newpermits.getText().toString().toLowerCase().trim();
        if (email.isEmpty()) {
            error="Ingresa el correo";
        }
        if (!error.equalsIgnoreCase(""))
        {
            showMSG(error);
        }
   }

    public void showMSG(String msg) {
        showToastMsj(msg);
    }
}
