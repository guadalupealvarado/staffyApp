package com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.purse.PurseDAO;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.DetailsPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.adapterRecyclerView.AdapteRecyclerPostulantResouse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ViewPostulanPurseView extends BaseView implements ViewPostulanPurseMVP.ViewPostulanPurseView {

    ViewPostulanPursePresenter viewPostulanPursePresenter;
    SharedPreferences prefs;
    @Nullable
    @BindView(R.id.rv_view_list_posulant_purse_view)
    RecyclerView recyclerView;
    //Se almacena el id del cardview seleccionado
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_view_postulan_purse_view, container, false);
        ButterKnife.bind(this,rootView);
        viewPostulanPursePresenter = new ViewPostulanPursePresenter(this);
        viewPostulanPursePresenter.oncreate();
        viewPostulanPursePresenter.showAllPuse();
        viewResource();
        showToolConfiguration(rootView);
        return rootView;
    }

    @Override
    public void onDestroy() {
        viewPostulanPursePresenter.ondestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        viewPostulanPursePresenter.ondestroy();
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
    public void viewResource() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        ArrayList<InfoRecursoPurse> postulantes = new ArrayList<>();
        ArrayList<InfoRecursoPurse> infoRecursoPurses = (ArrayList<InfoRecursoPurse>)
                PurseDAO.getInstance().getAllResourcePurse();

        for (int i=0;i<infoRecursoPurses.size();i++){
            if (infoRecursoPurses.get(i).getIdTpRecurso()==1){
                postulantes.add(infoRecursoPurses.get(i));
            }
        }
        PurseDAO.getInstance().setAllResourcePurse(postulantes);
        AdapteRecyclerPostulantResouse resourceAdapterRecyclerView = new AdapteRecyclerPostulantResouse
                (postulantes, R.layout.card_view_purse, this);
        recyclerView.setAdapter(resourceAdapterRecyclerView);
    }

    public void goDetilsResource(int id_position,int card_position) {
        Bundle bundle = new Bundle();
        bundle.putInt(DetailsPurseView.POSICIONRESOURCE, id_position);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(DetailsPurseView.POSICIONRESOURCE,id_position);
        editor.putInt("cardPosition",card_position);
        editor.commit();
        MainActivityPurse.state = ManagerFragmentPurse.SHOWDETAILSPURSE.setBundle(bundle);
        Intent intent = new Intent(rootView.getContext(), MainActivityPurse.class);
        intent.putExtra(DetailsPurseView.POSICIONRESOURCE,id_position);
        startActivity(intent);
    }

    @Optional
    @OnClick(R.id.btn_floating_add_posulant_purse_view)
    protected void goNewResource()
    {
        MainActivityPurse.state= ManagerFragmentPurse.ADDPOSTULADO;
        Intent intent=new Intent(getActivity(), MainActivityPurse.class);
        startActivity(intent);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        prefs =context.getSharedPreferences("FileLog", Context.MODE_PRIVATE);


    }
    private void showToolConfiguration(View view) {
        Toolbar toolbar=view.findViewById(R.id.toolbarPostul);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Cartera");
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
}
