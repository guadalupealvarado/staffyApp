package com.praxis.staffy.ui.purse.showPurse.toosResource;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.activityViewXML.MainActivityPurse;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentPurse;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToosResourceView extends BaseView
{
    public static ManagerFragmentPurse states;

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_view_toos_resource, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar();
       /* editResourse = rootView.findViewById(R.id.btn_editResouse);
        editResourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(ManagerFragmentPurse.EDITTOOLS);

            }
        });*/
        return rootView;
    }



    public void showToolbar() {
        //Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Herramientas");
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.finish();
                }
            });
        }
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.toolbar_modify,menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ic_edit:
                Toast.makeText(getContext(), "EDITAR", Toast.LENGTH_SHORT)
                        .show();
                return false;

        }
        return super.onOptionsItemSelected(item);
    }

    private void changeFragment(ManagerFragmentPurse states)
    {
        this.states=ManagerFragmentPurse.setState(states);
        this.states.execute((MainActivityPurse) getContext());


    }


}
