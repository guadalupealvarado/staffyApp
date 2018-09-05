package com.praxis.staffy.ui.proyect.editProyect;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentProyect;

import com.praxis.staffy.ui.proyect.ContainerProyect;

public class EditProyectView extends BaseView
{
    public static ManagerFragmentProyect states;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_edit_proyect, container, false);
        showToolbar(rootView);
        backButton();
        return rootView;
    }

    private void backButton()
    {
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    return true;
                }
                return false;
            }
        });
    }

    private void showToolbar(final View rootView)
    {
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_editproyect));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goInfoProyect();

                }
            });
        }
    }

    private void goInfoProyect()
    {
        changeFragment(ManagerFragmentProyect.INFOPROYECT);

    }

    private void changeFragment(ManagerFragmentProyect states) {
        this.states = ManagerFragmentProyect.setState(states);
        this.states.execute((ContainerProyect) getContext());
    }
}
