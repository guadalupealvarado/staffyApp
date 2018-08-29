package com.praxis.staffy.ui.client.newClient;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.model.pojo.Client;
import com.praxis.staffy.model.pojo.Address;
import com.praxis.staffy.service.servicesClient.insertClient.AppiInsertClient;
import com.praxis.staffy.ui.BaseView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public  class NewClientsView extends BaseView implements NewClientMVP.view{


    @Nullable
    @BindView(R.id.txtNombreNewClient)
    EditText txtNombreNewClient;

    @Nullable
    @BindView(R.id.txcalle)
    EditText  calleEditText;
    @Nullable
    @BindView(R.id.txnumero)
    EditText  numeroEditText;
    @Nullable
    @BindView(R.id.txcolonia)
    EditText  coloniaEditText;
    @Nullable
    @BindView(R.id.txcp)
    EditText  cpEditText;
    @Nullable
    @BindView(R.id.txdelegacionmunicipio)
    EditText  delegacionMunicipioEditText;
    @Nullable
    @BindView(R.id.txestado)
    EditText  estadoEditText;
    @BindView(R.id.txreferencia)
    EditText  referenciaEditText;

    public static String STATUS="success";
    private NewClientPresenter presenter;
    String text;

    private final AppiInsertClient appiInsertClient;


    public NewClientsView() {
        // Required empty public constructor+
        appiInsertClient=new AppiInsertClient();
        appiInsertClient.initClient();

    }

    @Optional
    @OnClick(R.id.btnCancelNewClient)
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_new_clients, container, false);
        LayoutInflater layoutInflater=getLayoutInflater();
        ButterKnife.bind(this, rootView);
        showToolbar(rootView);
        presenter = new NewClientPresenter(this);
        presenter.oncreate();
        return rootView;
    }


    @Override
    public void showMSG(String msg) {
        showToastMsj(msg);
    }


    @Override
    public void cleanAllTXT() {
        txtNombreNewClient.setText("");
        calleEditText.setText("");
        numeroEditText.setText("");
        coloniaEditText.setText("");
        cpEditText.setText("");
        delegacionMunicipioEditText.setText("");
        estadoEditText.setText("");
        referenciaEditText.setText("");
    }

    @OnClick(R.id.aceptarNewClient)
    public void sendDataNewClient()
    {
        String error="";
        String nombreCliente=txtNombreNewClient.getText().toString().toLowerCase().trim();
        if(!nombreCliente.isEmpty())
        {
            String calle=calleEditText.getText().toString().toLowerCase().trim();
            if(!calle.isEmpty())
            {
                String numero=numeroEditText.getText().toString().toLowerCase().trim();
                if (!numero.isEmpty())
                {
                    String colonia=coloniaEditText.getText().toString().toLowerCase().trim();
                    if (!colonia.isEmpty())
                    {
                        String cp=cpEditText.getText().toString().toLowerCase().trim();
                        if (!cp.isEmpty())
                        {
                            String delegacion=delegacionMunicipioEditText.getText().toString().toLowerCase().trim();
                            if (!delegacion.isEmpty())
                            {
                                String estado=estadoEditText.getText().toString().toLowerCase().trim();
                                if (!estado.isEmpty())
                                {
                                    String referencia=referenciaEditText.getText().toString().toLowerCase().trim();
                                    if (!referencia.isEmpty())
                                    {
                                        Client client=new Client();
                                        client.setIdActualizacion(UserDAO.getInstance().getList().get(0).getId());
                                        client.setIdCreacion(UserDAO.getInstance().getList().get(0).getId());
                                        client.setNombreCliente(txtNombreNewClient.getText().toString());
                                        client.setLogo("Aqui va el logo.");
                                        ArrayList<Address> addressArrayList=new ArrayList<>();
                                        Address address=new Address();
                                        address.setReferencia(referencia);
                                        address.setCalle(calle);
                                        address.setNumero(numero);
                                        address.setColonia(colonia);
                                        address.setDelegacionMunicipio(delegacion);
                                        address.setEstado(estado);
                                        address.setCodigoPostal(cp);
                                        address.setDirLatitud(19.427809);
                                        address.setDirLongitud(99.15656);
                                        addressArrayList.add(address);
                                        Log.e("Data client",address.getCalle());
                                        Log.e("Client",client.getNombreCliente());
                                        presenter.newClient(client,addressArrayList);



                                    }else
                                    {
                                        error="Ingresa un referencia";
                                    }
                                }else
                                {
                                    error="Ingresa el estado";
                                }
                            }else {
                                error="Ingresa la delegacion o municipio";
                            }
                        }else{
                            error="Ingresa el codigo postal";
                        }

                    }else{
                        error="Ingresa la colonia";
                    }
                }else{
                    error="Ingresa el numero";
                }
            }else{
                error="Ingresa la calle";
            }
        }else{
            error="Ingresa un nombre de cliente";
        }

        if (!error.equalsIgnoreCase(""))
        {
            showMSG(error);
        }
    }





    public void showToolbar(View view)
    {
        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar=((AppCompatActivity) getActivity()).getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setTitle("Nuevo cliente");
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.ondestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        presenter.ondestroy();
        super.onDestroyView();
    }
}
