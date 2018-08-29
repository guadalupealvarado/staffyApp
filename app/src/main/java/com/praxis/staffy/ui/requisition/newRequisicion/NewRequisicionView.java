package com.praxis.staffy.ui.requisition.newRequisicion;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.perfil_requerido;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.requisition.newRequisicion.newRequisitionRecyclerView.AdapterRequisition;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewRequisicionView extends BaseView {

    @Nullable
    @BindView(R.id.perfilRecycle)
    RecyclerView perfilRecycler;
    Spinner spinner;
    protected ArrayAdapter<CharSequence> adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.fragment_new_requisition, container, false);

        ButterKnife.bind(this, rootView);

        RecyclerView perfilRecycler= (RecyclerView)rootView.findViewById(R.id.perfilRecycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        perfilRecycler.setLayoutManager(linearLayoutManager);
        AdapterRequisition adapterRequisition =  new AdapterRequisition(buidCliente(),R.layout.cardview_perfil, getActivity());
        perfilRecycler.setAdapter(adapterRequisition);
        showToolbartReq(rootView);
        return rootView;
    }

    private void showToolbartReq(View view) {
        Toolbar toolbar=view.findViewById(R.id.toolRequicition);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Nueva requisicion");
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

    private ArrayList<perfil_requerido> buidCliente() {
        ArrayList<perfil_requerido> perfil = new ArrayList<>();
        perfil.add(new perfil_requerido("Java"));
        perfil.add(new perfil_requerido("C++"));
        perfil.add(new perfil_requerido("Python"));
        perfil.add(new perfil_requerido("C"));
        perfil.add(new perfil_requerido("Ruby"));
        perfil.add(new perfil_requerido("Php"));
        perfil.add(new perfil_requerido("Html"));
        perfil.add(new perfil_requerido("Kotlin"));
        perfil.add(new perfil_requerido("Perl"));

        return perfil;
    }







    public void showLoading() {
        showMessage("Cargando notificaciones");
    }


    public void hiddenLoading() {
        showMessage("Listo notificaciones");
    }


    public void showMessage(String msj) {
        showToastMsj(msj);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
