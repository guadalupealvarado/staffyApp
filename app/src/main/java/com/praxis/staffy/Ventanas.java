package com.praxis.staffy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.ui.BaseView;


import butterknife.ButterKnife;

public class Ventanas extends BaseView{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_requiried_profiel, container, false);
        LayoutInflater layoutInflater=getLayoutInflater();
        ButterKnife.bind(this, rootView);

        return rootView;
        }

}
