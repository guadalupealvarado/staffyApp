package com.praxis.staffy.ui.visits.viewVisits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.Visits;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainClientActivity;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainVisitsActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentClient;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentVisit;
import com.praxis.staffy.ui.visits.AdapterVisits;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ListVisitView extends BaseView {

    @Nullable
    @BindView(R.id.recyclerVisits)
    RecyclerView recyclerVisits;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedIntanceState) {
        rootView = inflater.inflate(R.layout.fragment_show_visits, container, false);

        ButterKnife.bind(this, rootView);


        setHasOptionsMenu(true);
        RecyclerView recyclerVisits = (RecyclerView) rootView.findViewById(R.id.recyclerVisits);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerVisits.setLayoutManager(linearLayoutManager);
        AdapterVisits adapterVisits = new AdapterVisits(buidListVisits(), R.layout.cardview_visits,getActivity());
        recyclerVisits.setAdapter(adapterVisits);

            showTol(rootView);
        return rootView;
    }

    private void showTol(View view) {
        Toolbar toolbar= view.findViewById(R.id.toolVisits);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Visitas");
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


    private ArrayList<Visits> buidListVisits() {
        ArrayList<Visits> lisvisits= new ArrayList<>();
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("sxdcvbnm,","234567"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));
        lisvisits.add(new Visits("Jose alfrdo hernandez vasques","082532"));




        return lisvisits;
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

    @Optional
    @OnClick(R.id.fb_add_fragment_show_visitis)//Boton para agregar visita
    public void onClick()
    {
        goNewVisit(ManagerFragmentVisit.NEWVISIT);//Mando como parametro que quiero cargar
        //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
    }

    private void goNewVisit(ManagerFragmentVisit state) {

        MainVisitsActivity.state=state;//Recibo mi parametro para cargar el fragment
        Intent myIntent = new Intent(rootView.getContext(), MainVisitsActivity.class);
        startActivity(myIntent);

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
