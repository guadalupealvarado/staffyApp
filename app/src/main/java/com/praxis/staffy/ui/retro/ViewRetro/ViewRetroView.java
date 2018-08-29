package com.praxis.staffy.ui.retro.ViewRetro;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.retro;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.retro.adapterRetro.AdapterRetro;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRetroView extends BaseView
{

    @Nullable
    @BindView(R.id.recyclerview_retro)
    RecyclerView recyclerview_retr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_list_retros, container, false);
        showToolbar(rootView);





        //en este apartado se llama el adaptador del recyclerview
        setHasOptionsMenu(true);
        RecyclerView recyclerView =(RecyclerView)rootView.findViewById(R.id.recyclerview_retro);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterRetro retro =  new AdapterRetro
                (arrayretro(),R.layout.cardview_retro, getActivity());
        recyclerView.setAdapter(retro);

        return rootView;
    }
    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.search);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Retro");
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


    // es un estrin para llenar el cardview
    private ArrayList<retro> arrayretro(){
        ArrayList<retro> retrolist = new ArrayList<>();
        retrolist.add(new retro("Miguel Betancourt Cravioto"));
        retrolist.add(new retro("Retro"));
        retrolist.add(new retro("01/05/2018"));
        retrolist.add(new retro("Promedio"));
        retrolist.add(new retro("Periodo"));
        retrolist.add(new retro("abr - sep 2018"));
        retrolist.add(new retro("SO"));

        return retrolist;
    }
}
