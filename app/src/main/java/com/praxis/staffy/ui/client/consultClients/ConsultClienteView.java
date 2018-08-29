package com.praxis.staffy.ui.client.consultClients;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.support.v7.widget.SearchView;
import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.client.ClientDAO;
import com.praxis.staffy.model.pojo.Client;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.client.newClient.adapter.ClienteAdapterRecyclerView;
import com.praxis.staffy.ui.client.updateClient.UpdateClientView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainClientActivity;

import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentClient;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public  class ConsultClienteView extends BaseView implements ClienteMVP.view,SearchView.OnQueryTextListener {

    private ConsultClientePresenterImp presenterImp;
    private ClienteAdapterRecyclerView clienteAdapterRecyclerView;

    @Nullable
    @BindView(R.id.clienteRecylcer)
    RecyclerView clienteRecycler;

    @Nullable
    @BindView(R.id.search)
    Toolbar toolbar_consult_client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState)
    {
        rootView = inflater.inflate(R.layout.
                        fragment_recyclerview_clients, container,
                false);
        presenterImp = new ConsultClientePresenterImp(this);
        presenterImp.onCreate();
        ButterKnife.bind(this, rootView);
        presenterImp.getAllClient();
        showToolbar(rootView);
        setHasOptionsMenu(true);
        setLinerLayouManager(clienteRecycler);
        return rootView;
    }

    private void goNewClient(ManagerFragmentClient state)
    {
        MainClientActivity.states=state;
        Intent myIntent = new Intent(rootView.getContext(), MainClientActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void setDataCardView(ArrayList<Client> list)
    {
        ClienteAdapterRecyclerView clienteAdapterRecyclerView=
                new ClienteAdapterRecyclerView(list, R.layout.cardview_clients,getActivity(),
                        this);
       clienteRecycler.setAdapter(clienteAdapterRecyclerView);
    }

    private void setLinerLayouManager(RecyclerView notificationRecycler)
    {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.scrollToPosition(LinearLayout.SCROLLBAR_POSITION_DEFAULT);
        notificationRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void showToolbar( View view)
    {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar_consult_client);

        final ActionBar actionBar=((AppCompatActivity) getActivity()).getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setTitle(getString(R.string.customers_item));
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        }
        toolbar_consult_client.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.finish();
            }
        });
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbart_client, menu);
        final MenuItem item=menu.findItem(R.id.search_ico);
        final SearchView searchView=(SearchView)MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
        item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {

                return true;
            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        ArrayList<Client> newList = new ArrayList<>();
        for (Client client: ClientDAO.getInstance().getAllClient()){
            String name = client.getNombreCliente().toLowerCase();
            if (name.contains(newText))
                newList.add(client);
        }
        if(newList!=null)
        {
            if(newList.size()!=0)
            {
                clienteAdapterRecyclerView=new ClienteAdapterRecyclerView(newList, R.layout.cardview_clients,getActivity(),
                        this);
              clienteAdapterRecyclerView.setFilter(newList);
               clienteRecycler.setAdapter(clienteAdapterRecyclerView);
            }
        }

        return true;
    }

    @Override
    public void showMsg(String msg) {
        showToastMsj(msg);
    }

    @Override
    public void showLoading() {
        showMsg(rootView.getResources().getString(R.string.loading));
    }

    @Override
    public void hiddenLoading() {
    }

    public void goEditClient(int id_client)
    {
        Bundle bundle=new Bundle();
        bundle.putString(UpdateClientView.ID_CLIENT_KY,String.valueOf(id_client));
        goNewClient(ManagerFragmentClient.DETAILSCLIENTS.setBundle(bundle));
    }

    /*--------------*/
    @Optional
    @OnClick(R.id.btn_floating_add_clients)
    public void onClick()
    {
        goNewClient(ManagerFragmentClient.NEWCLIENTS);
        //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    @Override
    public void onDestroy() {
        presenterImp.OnDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        presenterImp.OnDestroy();
        super.onDestroyView();
    }


}
