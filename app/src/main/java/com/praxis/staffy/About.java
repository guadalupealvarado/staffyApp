package com.praxis.staffy;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.ui.BaseView;

import butterknife.ButterKnife;

public class About extends BaseView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ButterKnife.bind(this,rootView);
        rootView= inflater.inflate(R.layout.fragment_about, container, false);
        return rootView;
    }

}
