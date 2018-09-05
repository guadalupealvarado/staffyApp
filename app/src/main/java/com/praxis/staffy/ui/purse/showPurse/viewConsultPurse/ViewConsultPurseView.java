package com.praxis.staffy.ui.purse.showPurse.viewConsultPurse;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.purse.PurseDAO;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.DetailsPurseView;
import com.praxis.staffy.ui.purse.showPurse.viewConsultPurse.adapter.AdapterConsultRecycler;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.adapterRecyclerView.AdapteRecyclerPostulantResouse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewConsultPurseView extends BaseView implements ViewConsultMVP.ViewConsultPurseView {


    ViewConsultPresenter viewConsultPursePresenter;


    @Nullable
    @BindView(R.id.rv_view_list_consult_purse_view)
    RecyclerView recyclerView;
    SharedPreferences prefs;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_view_consult_purse_view, container, false);
        ButterKnife.bind(this,rootView);
        viewConsultPursePresenter= new ViewConsultPresenter(this);
        viewConsultPursePresenter.oncreate();
        viewConsultPursePresenter.showAllPuse();

        viewResource();
        return rootView;
    }



    @Override
    public void showLoading() {

    }

    @Override
    public void hiddenLoading() {

    }

    @Override
    public void showMessage(String msj) {

    }

    @Override
    public void viewResource() {
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        ArrayList<InfoRecursoPurse> consultores =new ArrayList<>() ;
        ArrayList<InfoRecursoPurse> infoRecursoPurses = (ArrayList<InfoRecursoPurse>)
                PurseDAO.getInstance().getAllResourcePurse();;
        for (int i=0;i<infoRecursoPurses.size();i++){
            if (infoRecursoPurses.get(i).getIdTpRecurso()==4){
                consultores.add(infoRecursoPurses.get(i));
            }
        }
        AdapterConsultRecycler resourceAdapterRecyclerView = new AdapterConsultRecycler
                (consultores, R.layout.card_view_purse, this);
        recyclerView.setAdapter(resourceAdapterRecyclerView);
    }
    public void goDetilsResource(int id_position) {
        Bundle bundle = new Bundle();
        bundle.putInt(DetailsPurseView.POSICIONRESOURCE, id_position);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(DetailsPurseView.POSICIONRESOURCE,id_position);
        editor.commit();
        MainActivityPurse.state = ManagerFragmentPurse.SHOWDETAILSPURSE.setBundle(bundle);
        Intent intent = new Intent(rootView.getContext(), MainActivityPurse.class);
        startActivity(intent);
    }
    @Override
    public void onDestroyView() {
        viewConsultPursePresenter.ondestroy();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        viewConsultPursePresenter.ondestroy();
        super.onDestroy();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        prefs =context.getSharedPreferences("FileLog", Context.MODE_PRIVATE);

    }

}
