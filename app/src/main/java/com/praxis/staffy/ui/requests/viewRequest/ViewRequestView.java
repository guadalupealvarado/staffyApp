package com.praxis.staffy.ui.requests.viewRequest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import com.praxis.staffy.ui.managerFragment.manager.ManagerFragmentRequest;
import com.praxis.staffy.ui.requests.ContainerRequest;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewRequestView extends BaseView {
    public ManagerFragmentRequest states;
    ImageView tool, format, permission;


    public ViewRequestView()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_view_request, container, false);
        ButterKnife.bind(this,rootView);
        showToolbar(rootView);
        //backButton();


        return rootView;
    }
/*
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
    }*/

    private void changeFragment(ManagerFragmentRequest states) {
        this.states = ManagerFragmentRequest.setState(states);
        this.states.execute((ContainerRequest) getContext());
    }

    private void eventPermission()
    {
        changeFragment(ManagerFragmentRequest.SHOWPERMIST);
    }


    private void eventFormat()
    {
        changeFragment(ManagerFragmentRequest.FORMAT);
    }

    private void eventTool()
    {
        changeFragment(ManagerFragmentRequest.TOOL);
    }
    @Optional
    @OnClick(R.id.formats)
    public void clickFormat(){
        eventFormat();
    }

    @Optional
    @OnClick(R.id.tools)
    void clickTools(){
        eventTool();
    }
    @Optional
    @OnClick(R.id.permiss)
    public void clickPermiss(){

        eventPermission();
    }


    private void showToolbar(View view)
    {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        final ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.requests));
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    main();
                }
            });
        }

    }

    private void main()
    {
        activity.finish();
    }

}
