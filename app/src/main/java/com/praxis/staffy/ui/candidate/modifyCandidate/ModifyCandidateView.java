package com.praxis.staffy.ui.candidate.modifyCandidate;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

public class ModifyCandidateView extends BaseView {

    Button modifycandidate;

    @Nullable
    @BindView(R.id.txt_nombre_fracment_modifycandidate)
    EditText txtnombremodifycandidate;

    @Nullable
    @BindView(R.id.txt_appaterno_fracment_modifycandidate)
    EditText txtappaternomodifycandidate;

    @Nullable
    @BindView(R.id.txt_apmaterno_fracment_modifycandidate)
    EditText txtapmaternomodifycandidate;

    @Nullable
    @BindView(R.id.txt_correo_fracment_modifycandidate)
    EditText txtcorreomodifycandidate;



    public ModifyCandidateView() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_modify__candidate, container, false);
        showToolbar(rootView);
        modifycandidate=rootView.findViewById(R.id.btncancelar_fracment_modifycandidate);
        modifycandidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCancel();
            }
        });
        return rootView;


    }
    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_modifycandidate);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Modificar candidato");
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

    public void showMSG(String msg) {
        showToastMsj(msg);
    }
    @Optional
    @OnClick(R.id.btnguardar_fracment_modifycandidate4)

    public void seadDataNew_contact() {
        String error = "";
        String nombre = txtnombremodifycandidate.getText().toString().toLowerCase().trim();
        if (!nombre.isEmpty()) {

        } else {
            error = "Ingresa el nombre del candidato";
        }
        String appaterno = txtappaternomodifycandidate.getText().toString().toLowerCase().trim();
        if (!appaterno.isEmpty()) {

        } else {
            error = "Ingresa el apellido paterno del candidato";
        }
        String apmaterno = txtapmaternomodifycandidate.getText().toString().toLowerCase().trim();
        if (!apmaterno.isEmpty()) {

        } else {
            error = "Ingresa el apellido materno del candidato";
        }
        String correo=txtcorreomodifycandidate.getText().toString().toLowerCase().trim();
        if (!correo.isEmpty()){

        }else {
            error="Ingresa el correo";
        }

        if (!error.equalsIgnoreCase(""))
        {
            showMSG(error);
        }
    }
}
