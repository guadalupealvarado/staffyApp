package com.praxis.staffy.ui.purse.showPurse.detailsPurse;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.model.DAO.purse.PurseDAO;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.activities.adapter.ActivitiesAdapterRecyclerView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.purse.showPurse.detailsPurse.adapter.AdapterSkillsRecycler;
import com.praxis.staffy.ui.purse.showPurse.viewPostulantPurse.adapterRecyclerView.AdapteRecyclerPostulantResouse;
import com.praxis.staffy.ui.requests.editRequest.EditRequestView;
import com.praxis.staffy.ui.requests.ContainerRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsPurseView extends BaseView  {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.srollPerfilDetailsPurse)
    RecyclerView rvSkills;
    ArrayList<InfoRecursoPurse> infoRecursoPurses = (ArrayList<InfoRecursoPurse>)
            PurseDAO.getInstance().getAllResourcePurse();
    final CharSequence[] items = {"Agregar solicitud", "Modificar solicitud",
            "Ver herramientas", "Ver Formatos"};
    ImageView request;

    public static final String POSICIONRESOURCE="id_posicion";
    //Se almacena el id del cardview seleccionado
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getBundleView(getArguments());
        rootView= inflater.inflate(R.layout.fragment_details_purse, container, false);
        request=rootView.findViewById(R.id.btn_request);
        ButterKnife.bind(this,rootView);
        request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                gorequest();
            }
        });
        showToolbar();
        int valID=prefs.getInt("cardPosition",0);
        //cardViewSetData();
        //Toast.makeText(context,String.valueOf(prefs.getInt(POSICIONRESOURCE,011)), Toast.LENGTH_SHORT).show();
        Toast.makeText(context, String.valueOf(infoRecursoPurses.get(valID).getRecursoPerfil().get(valID).getPerfil()), Toast.LENGTH_SHORT).show();
        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        prefs =context.getSharedPreferences("FileLog", Context.MODE_PRIVATE);
    }

    private void gorequest() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if (item == 0) {
                    Intent goAddRequest= new Intent(getContext(), ContainerRequest.class);
                    startActivity(goAddRequest);
                } else if(item==2)
                {
                    ( (MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.SHOWTOOLRESOURCE);
                }else if(item==3)
                {
                    ( (MainActivityPurse) getActivity()).changeFragment(ManagerFragmentPurse.SHOWFORMATRESOURCE);
                }else
                    {
                    Intent goEditRequest= new Intent(getContext(), EditRequestView.class);
                    startActivity(goEditRequest);
                    Toast.makeText(getContext(), "Ahora puedes: " + items[item],
                            Toast.LENGTH_SHORT)
                            .show();

                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }


    public void showToolbar()
    {
        //
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Detalles postulado");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }


    public void showMSG(String msg)
    {
        showToastMsj(msg);
    }

}
