package com.praxis.staffy.ui.postulate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
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
import com.praxis.staffy.ui.postulate.postulateRecyclerView.AdapterViewPostulados;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostulanteView extends BaseView {

    @Nullable
    @BindView(R.id.recycler_view_postulante)
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_conteiner_postulados, container, false);
        ButterKnife.bind(this,rootView);
        viewResource();
        return rootView;
    }

    private void viewResource() {

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<InfoRecursoPurse> infoRecursoPurses = (ArrayList<InfoRecursoPurse>) PurseDAO.getInstance().getAllResourcePurse();
        AdapterViewPostulados resourceAdapterRecyclerView=new AdapterViewPostulados
                (infoRecursoPurses,R.layout.cartview_postulados,this);
        recyclerView.setAdapter(resourceAdapterRecyclerView);
    }

    public void goToViewResourcePostulant()
    {
        ((MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.SHOWRESOURCEPOSTULANT);
    }

}