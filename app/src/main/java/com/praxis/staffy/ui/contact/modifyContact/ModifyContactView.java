package com.praxis.staffy.ui.contact.modifyContact;


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
public class ModifyContactView extends BaseView {

    Button cancelarcontact;


    @Nullable
    @BindView(R.id.txtnombre_fracment_modifycontact)
    EditText txtnombremodifycontact;

    @Nullable
    @BindView(R.id.txtappaterno_fracment_modifycontact)
    EditText txtappaterno_fracment_modifycontact;

    @Nullable
    @BindView(R.id.txtapmaterno_fracment_modifycontact)
    EditText txtapmaterno_fracment_modifycontact;


    @Nullable
    @BindView(R.id.txtcntarea_fracment_modifycontact)
    EditText txtcntarea_fracment_modifycontact;

    @Nullable
    @BindView(R.id.txtcorreo_fracment_modifycontact)
    EditText txtcorreo_fracment_modifycontact;



    @Nullable
    @BindView(R.id.txtobservacion_fracment_modifycontact)
    EditText txtobservacion_fracment_modifycontact;


    @Nullable
    @BindView(R.id.txtnumerotelefonico_fracment_modifycontact)
    EditText txtnumerotelefonico_fracment_modifycontact;


    @Nullable
    @BindView(R.id.txtextencion_fracment_modifycontact)
    EditText txtextencion_fracment_modifycontact;



    public ModifyContactView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     rootView = inflater.inflate(R.layout.fragment_modify_contact, container, false);
     showToolbar(rootView);
     //llamar el id del boton canclar del fracmento modify_contact
        cancelarcontact=rootView.findViewById(R.id.btn_cancelar_fracment_modifycontact);
        cancelarcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCancel();
            }
        });

     return rootView;
    }
    //creacion de componentes del toolbar
    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_modifycontact);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Modificar Contacto");
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



//validacion de formulrio modify_contact


    @OnClick(R.id.btn_guardar_fracment_modifycontact)
    public void modify_contact(){
        String error="";
        String txtnombre=txtnombremodifycontact.getText().toString().toLowerCase().trim();
        if(!txtnombre.isEmpty()){

        }else {

            error="Ingresa nombre del contacto";

        }
        String txtappaterno=txtappaterno_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtappaterno.isEmpty()){

        }else {
            error="Ingresa el apellido paterno del contacto";

        }

        String txtapmaterno=txtapmaterno_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtapmaterno.isEmpty()){

        }else {

            error="Ingresa el apellido materno del contacto";
        }
        String txtctarea=txtcntarea_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtctarea.isEmpty()){

        }else {
            error="Ingresa el area del contacto";
        }
        String txtcorreoo=txtcorreo_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtcorreoo.isEmpty()){

        }else {
            error="Ingresa el correo del contacto";
        }
        String txtobserva=txtobservacion_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtobserva.isEmpty()){

        }else {
            error="Ingresa la observación del contacto";
        }
        String txtnumtelefono=txtnumerotelefonico_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtnumtelefono.isEmpty()){

        }else {
            error="Ingresa el número telefonico del contacto";
        }
        String txtextencion=txtextencion_fracment_modifycontact.getText().toString().toLowerCase().trim();
        if (!txtnumtelefono.isEmpty()){

        }else {
            error="Ingresa la extención del contacto";
        }

    }



    public void showMSG(String msg) {

    }
}
