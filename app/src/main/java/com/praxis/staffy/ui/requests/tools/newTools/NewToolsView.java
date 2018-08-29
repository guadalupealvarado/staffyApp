package com.praxis.staffy.ui.requests.tools.newTools;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;
import com.praxis.staffy.ui.requests.ContainerRequest;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewToolsView extends BaseView
{
    public static ManagerFragmentRequest states;
    EditText etTextMail, etDescriptionTool;
    ImageView addMail;
    Button submit;
    Spinner spinnerTools;
    protected ArrayAdapter<CharSequence> adapterTools;


    public NewToolsView()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView =inflater.inflate(R.layout.fragment_tool_view, container, false);
        fillSpiner();
        submitRequest();
        mailAdd();
        backButton();
        showToolbar(rootView);

        return rootView;

    }

    private void backButton()
    {
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                return false;
            }
        });
    }

    private void showToolbar(View view)
    {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.tools));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goInfoProyect();
                }
            });
        }

    }

    public void changeFragment(ManagerFragmentRequest states){
        this.states=ManagerFragmentRequest.setState(states);
        this.states.execute((ContainerRequest) getContext());
    }

    private void goInfoProyect()
    {
        changeFragment(ManagerFragmentRequest.VIEWREQUEST);
    }

    private void mailAdd()
    {
        addMail= rootView.findViewById(R.id.btn_add_mail);
        etTextMail = rootView.findViewById(R.id.txt_mail_format);
        addMail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0) {
                eventAddMail();
            }
        });
    }

    private void eventAddMail()
    {
        Toast.makeText(getContext(), "Mostrara la alerta de agregar Correo",
                Toast.LENGTH_SHORT).show();

    }

    private void submitRequest()
    {
        submit= rootView.findViewById(R.id.btn_submit_request_edit);

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                eventoSubmit();

            }
        });
    }

    private void fillSpiner()
    {
        spinnerTools=rootView.findViewById(R.id.spi_tools_edit);
        adapterTools =ArrayAdapter.createFromResource( getContext(), R.array.tools,
                android.R.layout.simple_spinner_dropdown_item);
        adapterTools.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTools.setAdapter(adapterTools);
    }

    private void eventoSubmit()
    {
        validarText();
    }

    private void validarText()
    {
        etDescriptionTool = rootView.findViewById(R.id.txt_finish_date_format);
        etTextMail= rootView.findViewById(R.id.txt_mail_format);

        if (etDescriptionTool.getText().length()==0){
            etDescriptionTool.setError(getString(R.string.fill));
        }

        else  if (etTextMail.getText().length()==0){
            etTextMail.setError(getString(R.string.fill));

        }

        else {
            saveTools();
        }
    }

    private void saveTools()
    {
        {
            new android.app.AlertDialog.Builder(getContext())
                    .setTitle(getString(R.string.title_addproyec))
                    .setMessage("¿Estas seguro de guardar?")
                    .setIcon(R.drawable.img_pregunta)
                    .setPositiveButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                }
                            })
                    .setNegativeButton("Cancelar",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            }).show();
        }
    }


}
