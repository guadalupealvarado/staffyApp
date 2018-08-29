package com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.adapterRecyclerView.AdapteRecyclerPostulantResouse;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class ViewPostulanPurseView extends BaseView implements ViewPostulanPurseMVP.ViewPostulanPurseView {

    ViewPostulanPurseMVP.ViewPostulanPursePresenter viewPostulanPursePresenter;

    @Nullable
    @BindView(R.id.rv_view_list_posulant_purse_view)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_view_postulan_purse_view, container, false);
        ButterKnife.bind(this,rootView);
        viewPostulanPursePresenter = new ViewPostulanPursePresenter(this);
        viewPostulanPursePresenter.oncreate();
        viewPostulanPursePresenter.showAllPuse();
        viewResource();
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
        ArrayList<InfoRecursoPurse> infoRecursoPurses = (ArrayList<InfoRecursoPurse>)
                PurseDAO.getInstance().getAllResourcePurse();
        AdapteRecyclerPostulantResouse resourceAdapterRecyclerView = new AdapteRecyclerPostulantResouse
                (infoRecursoPurses, R.layout.card_view_purse, this);
        recyclerView.setAdapter(resourceAdapterRecyclerView);
    }

    public void goDetilsResource(int id_position) {
        Bundle bundle = new Bundle();
        bundle.putInt(DetailsPurseView.POSICIONRESOURCE, id_position);
        MainActivityPurse.state = ManagerFragmentPurse.SHOWDETAILSPURSE.setBundle(bundle);
        Intent intent = new Intent(rootView.getContext(), MainActivityPurse.class);
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
}
