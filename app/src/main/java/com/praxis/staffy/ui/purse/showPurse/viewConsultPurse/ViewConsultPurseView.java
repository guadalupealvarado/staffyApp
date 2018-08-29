package com.praxis.staffy.ui.purse.showPurse.viewConsultPurse;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;

public class ViewConsultPurseView extends BaseView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_view_consult_purse_view, container, false);
        return rootView;
    }
}
