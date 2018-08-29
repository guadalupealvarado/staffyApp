package com.praxis.staffy.ui.candidate.newCandidate;


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
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewCandidateView extends BaseView {


    Button newcandidate;

public  ManagerFragmentPurse states;


    @Nullable
    @BindView(R.id.txt_nombre_fracment_newcandidate)
    EditText txtnombrenewcandidate;

    @Nullable
    @BindView(R.id.txt_appaterno_fracment_newcandidate)
    EditText txtappaternonewcandidate;

    @Nullable
    @BindView(R.id.txt_apmaterno_fracment_newcandidate)
    EditText txtapmaternonewcandidate;


    @Nullable
    @BindView(R.id.txt_fechanacimiento_fracment_newcandidate)
    EditText txtfechanacimientonewcandidate;

    @Nullable
    @BindView(R.id.txt_numtelefonico_fracment_newcandidate)
    EditText txtnumerotelefoniconewcandidate;

    @Nullable
    @BindView(R.id.txt_correo_fracment_newcandidate)
    EditText txtcorreo_newcandidate;

    @Nullable
    @BindView(R.id.txt_numerotele_fracment_newcandidate)
    EditText txtnumerotelefonico_newcandidate;

    @Nullable
    @BindView(R.id.txt_fecha_fracment_newcandidate)
    EditText txtfechanewcandidate;

    @Nullable
    @BindView(R.id.txt_hora_fracment_newcandidate)
    EditText txthora_newcandidate;

    @Nullable
    @BindView(R.id.txt_nombrereclutado_fracment_newcandidate)
    EditText txtnombrereclutado_newcandidate;

    @Nullable
    @BindView(R.id.txt_numerotelefo_fracment_newcandidate)
    EditText txtnumerotelef_newcandidate;



    public NewCandidateView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_new__candidate, container, false);
        //llamar butterknife para la validacion
        ButterKnife.bind(this,rootView);
        showToolbar(rootView);
        newcandidate=rootView.findViewById(R.id.btn_cancelar_newcandidate);
        newcandidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCancel();
            }
        });
        return rootView;
    }


    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_fracment_newcandidato);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Nuevo Candidato");
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


    //validacion del formulario new_candidate



    public void showMSG(String msg) {
        showToastMsj(msg);
    }

    @Optional
    @OnClick(R.id.btn_guardar_newcandidate)
    public void modify_candidate(){
        String error="";

        String nombrecandidatot=txtnombrenewcandidate.getText().toString().toLowerCase().trim();
        if (nombrecandidatot.isEmpty())
        {
            String appaternocandidate = txtappaternonewcandidate.getText().toString().toLowerCase().trim();
            if(appaternocandidate.isEmpty())
            {

            String apmaternocandidate = txtapmaternonewcandidate.getText().toString().toLowerCase().trim();
                if (apmaternocandidate.isEmpty()){

            String fechanaci = txtfechanacimientonewcandidate.getText().toString().toLowerCase().trim();
                    if (fechanaci.isEmpty()){

            String numertelefo = txtnumerotelefoniconewcandidate.getText().toString().toLowerCase().trim();
                        if (numertelefo.isEmpty()) {

            String corrreo = txtcorreo_newcandidate.getText().toString().toLowerCase().trim();
                            if (corrreo.isEmpty())
                            {

            String numbtele = txtnumerotelefonico_newcandidate.getText().toString().toLowerCase().trim();
                                if (numbtele.isEmpty()){

            String fecha = txtfechanewcandidate.getText().toString().toLowerCase().trim();
                                    if (fecha.isEmpty()){

            String hora = txthora_newcandidate.getText().toString().toLowerCase().trim();
                                        if (hora.isEmpty()){

            String numerotelefono = txtnumerotelef_newcandidate.getText().toString().toLowerCase().trim();
                                            if (numerotelefono.isEmpty()){


        }else
          error="Ingresar numero telefonico";
        }else
          error="Ingresar una hora";

        } else
            error="Ingresar una fecha";

        }else
             error="Ingresa el numero telefonico del candidato";
        }else
            error="Ingresar el correo del candidato";

        }else
             error="Ingresar el numero telefonico del candidato";
        }else
            error="Ingresar la fehca de nacimiento del candidato";

        }else
             error="Ingresar el apellido materno del candidato";
        }else
             error="Ingresar apellido paterno del candidato";
        }else
            error="Ingresar el nombre del candidato";


        }
    private void changeFragment(ManagerFragmentPurse states) {
        this.states = ManagerFragmentPurse.setState(states);
        this.states.execute((MainActivityPurse) getContext());
    }

        @Optional
        @OnClick(R.id.btn_perfil)
    public void assign(){
        changeFragment(ManagerFragmentPurse.ASSIGNKNOWLEDGE);
        }


    }


