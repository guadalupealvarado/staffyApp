package com.praxis.staffy.ui.client.updateClient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.model.pojo.CustomerDetails;
import com.praxis.staffy.model.setPojoServices.updateClient.SetAddressClientUpdate;
import com.praxis.staffy.model.setPojoServices.updateClient.setClientsUpdate;
import com.praxis.staffy.ui.BaseView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class UpdateClientView extends BaseView implements UpdateMvp.view {

    public static final String ID_CLIENT_KY = "id_client";
    private UpdateMvp.presenter presenter;


    private String  id_cliente;
    private int id_addressClient;
    @Nullable
    @BindView(R.id.updateClientTXTName)
    EditText etNameClient;
    @Nullable
    @BindView(R.id.txcalle)
    EditText calleEditText;
    @Nullable
    @BindView(R.id.txnumero)
    EditText numeroEditText;
    @Nullable
    @BindView(R.id.txcolonia)
    EditText coloniaEditText;
    @Nullable
    @BindView(R.id.txcp)
    EditText cpEditText;
    @Nullable
    @BindView(R.id.txdelegacionmunicipio)
    EditText delegacionMunicipioEditText;
    @Nullable
    @BindView(R.id.txestado)
    EditText estadoEditText;
    @BindView(R.id.txreferencia)
    EditText referenciaEditText;

    @Optional
    @OnClick (R.id.btn_update_client)
    public void onUpdateBTN()
    {
        if(id_cliente!=null)
        {
           // Client client = ClientDAO.getInstance().getClient(Integer.parseInt(id_cliente));
           // if (client != null)
           // {
                sendDataUpdate(Integer.parseInt(id_cliente));
           // }else
        }else {
            showToastMsj("El identificador del cliente no existe. ");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_update_client, container, false);
        ButterKnife.bind(this, rootView);
        Bundle bundle = this.getArguments();
        presenter = new UpdatePresenter(this);
        presenter.oncreate();
        showToolbar(rootView);
        id_cliente = bundle.getString(UpdateClientView.ID_CLIENT_KY);
        if (id_cliente != null) {
            loadClient(Integer.parseInt(id_cliente));
        }
        return rootView;
    }

    public void loadClient(int id_client)
    {
        //Client client = ClientDAO.getInstance().getClient(id_client);
        if (id_client != 0) {
            presenter.getDetailsClient(id_client);
        }
    }

    @Override
    public void showToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Actualizar cliente");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }


    public void sendDataClient(CustomerDetails customerDetails) {

        id_addressClient=customerDetails.getDirecciones().get(0).getId();
        etNameClient.setText(customerDetails.getNombreCliente());
        calleEditText.setText(customerDetails.getDirecciones().get(0).getCalle());
        numeroEditText.setText(customerDetails.getDirecciones().get(0).getNumero());
        coloniaEditText.setText(customerDetails.getDirecciones().get(0).getColonia());
        cpEditText.setText(customerDetails.getDirecciones().get(0).getCodigoPostal());
        delegacionMunicipioEditText.setText(customerDetails.getDirecciones().get(0).getDelegacionMunicipio());
        estadoEditText.setText(customerDetails.getDirecciones().get(0).getEstado());
        referenciaEditText.setText(customerDetails.getDirecciones().get(0).getReferencia());
        if (customerDetails.getDirecciones().size() > 1) {
            showToastMsj("Tienes más de una dirección para el cliente.");
        }
    }


    @Override
    public void showMessage(String msj) {
        showToastMsj(msj);
    }

    @Override
    public void setDataUpdate(CustomerDetails dataUpdate) {

    }

    @Override
    public void showLoading()
    {   showToastMsj("Actualizando...."); }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void sendDataUpdate(int id_client)
    {
        setClientsUpdate customerDetails=new setClientsUpdate();
        List<SetAddressClientUpdate> addressCustomerDetails=new ArrayList<>();
        SetAddressClientUpdate addressCustomerDetails1=new SetAddressClientUpdate();

        customerDetails.setIdUsuario(UserDAO.getInstance().getUser(0).getId());
        customerDetails.setNbCliente(etNameClient.getText().toString().trim());
        customerDetails.setLogo("This the img of logo");

        addressCustomerDetails1.setNumero(numeroEditText.getText().toString().trim());
        addressCustomerDetails1.setReferencia(referenciaEditText.getText().toString().trim());
        addressCustomerDetails1.setCalle(calleEditText.getText().toString().trim());
        addressCustomerDetails1.setCodigoPostal(cpEditText.getText().toString());
        addressCustomerDetails1.setColonia(coloniaEditText.getText().toString());
        addressCustomerDetails1.setDelegacionMunicipio(delegacionMunicipioEditText.getText().toString().trim());
        addressCustomerDetails1.setEstado(estadoEditText.getText().toString().trim());
        addressCustomerDetails1.setId(id_addressClient);
        addressCustomerDetails1.setDirLatitud(342332.33);
        addressCustomerDetails1.setDirLongitud(33323.423);
        addressCustomerDetails.add(addressCustomerDetails1);

        customerDetails.setDirecciones(addressCustomerDetails);

        presenter.setDateUpdate(customerDetails,id_client);
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



    @Optional
    @OnClick(R.id.btn_cancel_update_cliente)
    protected void exitUpdate()
    {
        activity.finish();
    }

}
