package com.praxis.staffy.ui.proyect.newProyect;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainViewProfileActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentProyect;
import com.praxis.staffy.ui.proyect.ContainerProyect;
import com.praxis.staffy.ui.proyect.GestionarAdapter2;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

import static android.app.Activity.RESULT_OK;


public class NewProyectView extends BaseView implements AdapterView.OnItemSelectedListener
{
    public static ManagerFragmentProyect states;
    /**Declaración de los objetos*/
    EditText name_proyect, description, date_start, date_finish, observation;
    Button btn_accept, btn_cancel;
    Spinner spinnerstatus, spinnerLevel, spinnerContact;
    ImageView imageViewLogo, imageViewContac, imageViewAddress;
    ListView lista;

    /**Lista de Array encargador */
    protected ArrayAdapter<CharSequence> adapterEstatus;
    protected ArrayAdapter<CharSequence> adapterLevel;
    protected ArrayAdapter<CharSequence> adapterContac;
    private int position;
    private String selection;

    public static String [] progNombreLista=
            {
                    "Dirección 1","Direccion2","Direccion3","Direccion4",
            };

    public NewProyectView()
    {
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            Uri path=data.getData();
            imageViewLogo.setImageURI(path);
        }
        else {

        }
        //

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        rootView = inflater.inflate(R.layout.fragment_add_proyect, container, false);
        showToolbar(rootView);

        ButterKnife.bind(this,rootView);
        lista=rootView.findViewById(R.id.listview_direction);
        lista.setAdapter(new GestionarAdapter2(getContext(), progNombreLista));

        imageViewLogo = rootView.findViewById(R.id.img_default);
        imageViewContac = rootView.findViewById(R.id.btn_add_contact);
        imageViewAddress= rootView.findViewById(R.id.btn_add_address);
        btn_accept = rootView.findViewById(R.id.btn_submit_request_edit);
        btn_cancel=rootView.findViewById(R.id.btn_cancel);
        name_proyect= rootView.findViewById(R.id.name_proyect);
        description = rootView.findViewById(R.id.txt_add_description);
        date_start= rootView.findViewById(R.id.date_start);
        date_finish = rootView.findViewById(R.id.date_finish);
        observation = rootView.findViewById(R.id.txt_observation);

        /**Instaciar el Spinner con su respectivo ID*/
        spinnerstatus=rootView.findViewById(R.id.spi_status);
        spinnerLevel=rootView.findViewById(R.id.spi_level);
        spinnerContact=rootView.findViewById(R.id.spi_contac);

        /**Llamar el array Spinner*/
        adapterEstatus = ArrayAdapter.createFromResource( getContext(), R.array.status,
                android.R.layout.simple_spinner_dropdown_item);
        adapterLevel = ArrayAdapter.createFromResource( getContext(), R.array.level,
                android.R.layout.simple_spinner_dropdown_item);
        adapterContac= ArrayAdapter.createFromResource(getContext(), R.array.contact,
                android.R.layout.simple_spinner_dropdown_item);

        /**Estilo del contenedor del Spinner*/
        adapterEstatus.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterLevel.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        adapterContac.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        /**Se le acomoda el array al Spinner*/
        spinnerstatus.setAdapter(adapterEstatus);
        spinnerLevel.setAdapter(adapterLevel);
        spinnerContact.setAdapter(adapterContac);

        /**Se le acomoda el array al Spinner*/
        spinnerstatus.setOnItemSelectedListener(this);
        spinnerLevel.setOnItemSelectedListener(this);
        spinnerContact.setOnItemSelectedListener(this);

        imageViewLogo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                loadimage();

            }
        });

        imageViewContac.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                eventContac();
            }
        });

        imageViewAddress.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                eventAddress();
            }
        });

        btn_accept.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                validationText();
            }

            //
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                alerCancel();
            }
        });

        backButton();


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
        actionBar.setTitle(getString(R.string.title_addproyec));
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

    private void changeFragment(ManagerFragmentProyect states) {
        this.states = ManagerFragmentProyect.setState(states);
        this.states.execute((ContainerProyect) getContext());
    }

    private void goInfoProyect() {
        activity.finish();
    }

    private void validationText()
    {
        if (name_proyect.getText().length()==0){
            name_proyect.setError(getString(R.string.fill));
        }
        else if (description.getText().length()==0){
            description.setError(getString(R.string.fill));
        }

        else if(date_start.getText().length()==0){
            date_start.setError(getString(R.string.fill));

        }
        else if(date_finish.getText().length()==0){
            date_finish.setError(getString(R.string.fill));
        }
        else if (observation.getText().length()==0){
            observation.setError(getString(R.string.fill));
        }
        else {
            saveConfirmation();
        }
    }

    private void eventAddress()
    {
        Toast.makeText(getContext(), "Este es el evento para agregar una dirección", Toast.LENGTH_SHORT)
                .show();
    }

    private void loadimage()
    {
        Intent intent= new Intent(Intent.ACTION_PICK, MediaStore.
                    Images.Media.EXTERNAL_CONTENT_URI);

            intent.setType("image/");
            startActivityForResult(intent.createChooser(
                    intent,getString(R.string.accept)), 10);
    }

    private void eventContac()
    {
       // ((ActivityProyect) getActivity()).changeFragment(ManagerFragmentProyect.NEWCONTACT);
    }


    private void saveConfirmation()
    {
        {
            new AlertDialog.Builder(getContext())
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

    private void alerCancel()
    {
        new AlertDialog.Builder(getContext())
                .setTitle(getString(R.string.title_addproyec))
                .setMessage(getString(R.string.alertCancel))
                .setIcon(R.drawable.img_pregunta)
                .setPositiveButton(getString(R.string.aceptbtn),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id)
                            {
                                getActivity().onBackPressed();
                            }
                        })
                .setNegativeButton(getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        this.position = position;
        selection = parent.getItemAtPosition(position).toString();
        if (position == 0)
        {

        }
        else if(position==position)
        {
            Toast.makeText(getContext(),"" + selection  ,Toast.LENGTH_SHORT)
                    .show();
        }
        else
            {

            }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
    }

    @Optional
    @OnClick(R.id.btn_add_contact)
    protected void goAddContact()
    {
       // ((ActivityProyect) getActivity()).changeFragment(ManagerFragmentProyect.NEWCONTACT);
    }

}
