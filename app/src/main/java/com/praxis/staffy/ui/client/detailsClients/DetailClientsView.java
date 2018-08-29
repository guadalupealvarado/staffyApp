package com.praxis.staffy.ui.client.detailsClients;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.CustomerDetails;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.client.updateClient.UpdateClientView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainClientActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentClient;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class DetailClientsView extends BaseView implements DetailsClientMvp.view
{
    public static ManagerFragmentClient states;


    @Nullable
    @BindView(R.id.idtxtDetailsNameClient)
    TextView idtxtDetailsNameClient;
    @Nullable
    @BindView(R.id.idtxtDetailsDelegacion)
    TextView idtxtDetailsDelegacion;
    @Nullable
    @BindView(R.id.idtxtDetailsEstado)
    TextView idtxtDetailsEstado;
    @Nullable
    @BindView(R.id.idtxtDetailsCalle)
    TextView idtxtDetailsCalle;
    @Nullable
    @BindView(R.id.idtxtDetailsNumero)
    TextView idtxtDetailsNumero;
    @Nullable
    @BindView(R.id.idtxtDetailsColonia)
    TextView idtxtDetailsColonia;
    @Nullable
    @BindView(R.id.idtxtDetailsCP)
    TextView idtxtDetailsCP;

    private DetailsClientPresenter presenter;
    private String id_cliente="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_detail_clients, container, false);
        Bundle bundle = this.getArguments();
        ButterKnife.bind(this, rootView);
        showToolbar(rootView);
        presenter= new DetailsClientPresenter(this);
        presenter.onCreate();
        id_cliente= bundle.getString(UpdateClientView.ID_CLIENT_KY);
        if (id_cliente != null) {
            loadClient(Integer.parseInt(id_cliente));
        }
        return rootView;
    }




    private void goAddProyect()
    {
        changeManger(ManagerFragmentClient.NEWPROYECT);
        Toast.makeText(getContext(), "qqwerfdcsxzXADSFA.SDHBFJADVSF,", Toast.LENGTH_SHORT)
                .show();
    }

    public void changeManger (ManagerFragmentClient states){
        this.states= ManagerFragmentClient.setState(states);
        this.states.execute((MainClientActivity)  getContext());

    }


    public void goEditClient(int id_client) {
        Bundle bundle = new Bundle();
        bundle.putString(UpdateClientView.ID_CLIENT_KY, String.valueOf(id_client));
        goClientEdit(ManagerFragmentClient.UPDATECLIENT.setBundle(bundle));
    }

    private void goClientEdit(ManagerFragmentClient state) {
        MainClientActivity.states = state;
        Intent myIntent = new Intent(rootView.getContext(), MainClientActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void loadClient(int id_client) {
        if (id_client!=0) {
            getDetailsClient(id_client);
        }
    }

    private void getDetailsClient(Integer idCliente)
    {
        presenter.getDetailsClient(idCliente);
    }

    @Override
    public void showToolbar( View view)
    {
        Toolbar toolbar= view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.customers_item));
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }

    @Override
    public void onDestroy() {
        presenter.OnDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        presenter.OnDestroy();
        super.onDestroyView();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void showMessage(String msj) {
        showToastMsj(msj);
    }

    @Override
    public void getBundle(Bundle bundle) {

    }

    @Override
    public void sendDataClient(CustomerDetails customerDetails) {
        showToastMsj(customerDetails.getDirecciones().get(0).getId()+" ");
        idtxtDetailsNameClient.setText(customerDetails.getNombreCliente());
        idtxtDetailsDelegacion.setText(customerDetails.getDirecciones().get(0).getDelegacionMunicipio());
        idtxtDetailsCalle.setText(customerDetails.getDirecciones().get(0).getCalle());
        idtxtDetailsColonia.setText(customerDetails.getDirecciones().get(0).getColonia());
        idtxtDetailsCP.setText(customerDetails.getDirecciones().get(0).getCodigoPostal());
        idtxtDetailsEstado.setText(customerDetails.getDirecciones().get(0).getEstado());
        idtxtDetailsNumero.setText(customerDetails.getDirecciones().get(0).getNumero());
        if(customerDetails.getDirecciones().size()>1)
        {
            showToastMsj("Tienes más de una dirección para el cliente.");
        }
    }

    @Optional
    @OnClick(R.id.btn_add_proyect_details_client)
    protected void goBtnAddProyect()
    {
        goAddProyect();
    }

    @Optional
    @OnClick(R.id.btnModificarClient)
    protected void goEditClient()
    {
        if(id_cliente!=null)
            goEditClient(Integer.parseInt(id_cliente));
    }


}
