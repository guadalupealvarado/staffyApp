package com.praxis.staffy.ui.activities;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;
import butterknife.ButterKnife;

public class ActivitiesView extends BaseView implements ActivitiesMvp.view {

    ActivitiesPresenter activitiesPresenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_activities, container, false);
        ButterKnife.bind(this,rootView);
        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
                    //   Metodos antes de realizar el back o capturar el evento back
                    return true;
                }
                return false;
            }
        });
        return  rootView;
    }

}
