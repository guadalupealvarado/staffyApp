package com.praxis.staffy.ui.user.listUser;


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
import com.praxis.staffy.model.pojo.User;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.user.adapterUser.AdapterUser;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainViewProfileActivity;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentViewUser;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListUserView extends BaseView {




    @Nullable
    @BindView(R.id.recyclerView)
    RecyclerView recyclerview_user;

    public ListUserView() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_list__user, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar(rootView);







        //en este apartado se llama el adaptador del recyclerview
        setHasOptionsMenu(true);

        RecyclerView recyclerView =(RecyclerView)rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        AdapterUser user =  new AdapterUser(arrayusuario(),R.layout.cardview_user, getActivity());
        recyclerView.setAdapter(user);

        return rootView;
    }

    @Optional
    @OnClick(R.id.floatingActionButton)
    protected void goNewCliente()
    {
        ((MainViewProfileActivity) getActivity()).changeFragment(ManagerFragmentViewUser.NEWUSER);
    }

    public void showToolbar(View view) {
        //llamar toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar2);
        //poner el titulo
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Usuarios");
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
    private ArrayList<User> arrayusuario(){
        ArrayList<User> listUsr = new ArrayList<>();
        listUsr.add(new User("Retro","s","f","f","sd","fd","s","f","d","d","s"));
        listUsr.add(new User("Retro", "Retro", "s", "f", "f", "Retro", "s", "f", "f", "sd", "01/05/2018"));
        listUsr.add(new User("Retro", "Retro", "s", "f", "f", "Retro", "s", "f", "f", "sd", "Promedio"));


        return listUsr;
    }
}
