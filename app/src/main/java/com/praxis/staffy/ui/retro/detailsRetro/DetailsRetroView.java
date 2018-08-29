package com.praxis.staffy.ui.retro.detailsRetro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsRetroView extends BaseView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_see_retro, container, false);
        return rootView;
    }

}
