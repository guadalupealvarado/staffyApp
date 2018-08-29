package com.praxis.staffy.ui.purse.showPurse.detailsPurse;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;
import com.praxis.staffy.ui.requests.editRequest.EditRequestView;
import com.praxis.staffy.ui.requests.ContainerRequest;

import butterknife.BindView;

public class DetailsPurseView extends BaseView {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    final CharSequence[] items = {"Agregar solicitud", "Modificar solicitud",
            "Ver herramientas", "Ver Formatos"};
    ImageView request;

    public static final String POSICIONRESOURCE="id_posicion";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getBundleView(getArguments());
        rootView= inflater.inflate(R.layout.fragment_details_purse, container, false);
        request=rootView.findViewById(R.id.btn_request);
        request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                gorequest();
            }
        });
        showToolbar();
        return rootView;
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



    private void getBundleView(Bundle bundle)
    {
        if(bundle!=null)
        {
            showToastMsj(bundle.getString(DetailsPurseView.POSICIONRESOURCE));

        }
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