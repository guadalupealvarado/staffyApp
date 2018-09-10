package com.praxis.staffy.ui.purse.showPurse.newConsult;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewConsultantView extends BaseView {

    public View rootView;


  /*  @Nullable
    @BindView(R.id.txnombr)
    EditText txnombre;



    @Nullable
    @BindView(R.id.txtap)
    EditText txtap;

    @Nullable
    @BindView(R.id.txtma)
    EditText txtma;
    //--//

    @Nullable
    @BindView(R.id.spi_contac)
    Spinner  spi_contac;

    @Nullable
    @BindView(R.id.txtcorreo)
    EditText  txtcorreo;

    @Nullable
    @BindView(R.id.spinnercontac)
    Spinner  spinnercontac;

    @Nullable
    @BindView(R.id.checkBox)
    CheckBox checkbbox;

    @Nullable
    @BindView(R.id.txtnum)
    EditText  checkBox;

    @Nullable
    @BindView(R.id.txtextencion)
    EditText  txtextencion;

    @Nullable
    @BindView(R.id.txt_spin)
    Spinner  txt_spin;*/



    @Optional
    @OnClick(R.id.btn_cancel)
    public void askCancel()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(rootView.getContext());
        builder.setMessage("¿Desea cancelar?")
                .setTitle("Advertencia")
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                activity.finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }



    public NewConsultantView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     rootView = inflater.inflate(R.layout.fragment_new_consultant, container, false);
        ButterKnife.bind(this,rootView);
     showToolConfiguration(rootView);
     return rootView;

    }
    private void showToolConfiguration(View view) {
        Toolbar toolbar=view.findViewById(R.id.toolbar_fracment_newconsult);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Agregar Consultor");
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


}
