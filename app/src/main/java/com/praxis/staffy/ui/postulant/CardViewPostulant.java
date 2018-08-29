package com.praxis.staffy.ui.postulant;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.praxis.staffy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardViewPostulant extends Fragment {


ProgressBar horizontal_progress_bar;
    public CardViewPostulant() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.card_view_postulant, container, false);

        //para el color del progressbar
        ProgressBar miprogressbar = (ProgressBar)view.findViewById(R.id.horizontal_progress_bar_fracment_postulant);
        miprogressbar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        return view;

    }

}
