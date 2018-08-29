package com.praxis.staffy.ui.contact.newContact;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class NewContactView extends BaseView {

    Button add_contact;

    //componer relacion del nuevo nombre del ID

    @Nullable
    @BindView(R.id.txtnombre_fracment_newcontact)
    EditText txtnombrenewcontact;

    @Nullable
    @BindView(R.id.txtappeterno_fracment_newcontact)
    EditText txtappaterno;

    @Nullable
    @BindView(R.id.txtapmaterno_fracment_newcontact)
    EditText txtapmaterno;

    @Nullable
    @BindView(R.id.txtcorreo_fracment_newcontact)
    EditText txtcontactarea;

    @Nullable
    @BindView(R.id.txtnumero_fracment_newcontact)
    EditText txtcorreocontact;

    @Nullable
    @BindView(R.id.txtextencion_fracment_newcontact)
    EditText txtobservacioncontact;

    @Nullable
    @BindView(R.id.txtobservacion_fracment_newcontact)
    EditText txt;


    Button cancelarnewcontact;


    public NewContactView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_new_contact, container, false);
        showToolbar(rootView);
        cancelarnewcontact=rootView.findViewById(R.id.btncancelar_fracment_newcontact);
        cancelarnewcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCancel();
            }
        });
        return rootView;

    }
    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_fracment_newcontact);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Nuevo Contacto");
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

    //funciones del boton cancelar


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


    // validacion del formulario de nuevos contactos

    @OnClick(R.id.btnguardar__fracment_newcontact)
    public void seadDataNew_contact(){
        String error="";
        String nombrecontact=txtnombrenewcontact.getText().toString().toLowerCase().trim();
        if (!nombrecontact.isEmpty()){

        }else {
            error="Ingresa el nombre del contacto";
        }

        String appaterno=txtappaterno.getText().toString().toLowerCase().trim();
        if (!appaterno.isEmpty()){

        }else {
            error="Ingresa el apellido paterno";
        }

        String apmaterno=txtapmaterno.getText().toString().toLowerCase().trim();
        if (!apmaterno.isEmpty()){

        }else {
            error="Ingresa el apellido materno";
        }

        String cntarea= txtcontactarea.getText().toString().toLowerCase().trim();
        if (!cntarea.isEmpty()){
            error="Ingresa el area del contacto";
        }

        String correo= txtcorreocontact.getText().toString().toLowerCase().trim();
        if (!correo.isEmpty()){

        }else {
            error="Ingresa un correo electronico";
        }

        String observation= txtobservacioncontact.getText().toString().toLowerCase().trim();
        if (!observation.isEmpty()){

        }else{
            error="Ingresa la observacion del contacto";
        }




    }


    public void showMSG(String msg) {

    }
}
