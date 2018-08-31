package com.praxis.staffy.ui.calendar;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;


/**
 * A simple {@link Fragment} subclass.
 */
public class calendar extends BaseView implements CalendarView.OnDateChangeListener {


    public calendar() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         //CalendarView calendarView =rootView.findViewById(R.id.calendarView);
        rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
CalendarView calendarView= rootView.findViewById(R.id.calendarView);
calendarView.setOnDateChangeListener(this);
        return rootView;

    }


    @Override
    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
builder.setTitle("Calendario")
        .setItems(R.array.optionsCalendar, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // The 'which' argument contains the index position
                // of the selected item
            }
        });

AlertDialog dialog =builder.create();
dialog.show();

}}
