package com.praxis.staffy.ui.calendar;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

import com.darwindeveloper.onecalendar.clases.Day;
import com.darwindeveloper.onecalendar.views.OneCalendarView;
import com.praxis.staffy.R;
import com.praxis.staffy.ui.BaseView;

import java.util.Calendar;
import java.util.Date;
/**
 * A simple {@link Fragment} subclass.
 */
public class calendar extends BaseView {
    int mes = 0;
    int year = 0;
    private OneCalendarView calendarView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = rootView.findViewById(R.id.calendarView);
        //los metodos son obigatorios
        calendarView.getCurrentDayMonth();

        calendarView.setOneCalendarClickListener(new OneCalendarView.OneCalendarClickListener() {

            @Override
            public void dateOnClick(Day day, int position) {
            }

            @Override
            public void dateOnLongClick(Day day, int position) {

            }
        });
        calendarView.setOnCalendarChangeListener(new OneCalendarView.OnCalendarChangeListener() {
            @Override
            public void prevMonth() {
                year = calendarView.getYear();
                mes = calendarView.getMonth();
                String month = String.valueOf(mes);
                String yearS = String.valueOf(year);

                Toast.makeText(context, "Mes " + month + " año " + yearS, Toast.LENGTH_LONG).show();
            }

            @Override
            public void nextMonth() {
                year = calendarView.getYear();
                mes = calendarView.getMonth();
                String month = String.valueOf(mes);
                String yearS = String.valueOf(year);

                Toast.makeText(context, "mes " + month + " año " + yearS, Toast.LENGTH_LONG).show();

            }
        });
        return rootView;
    }

    private void initCalendar() {
        //el siguiente fragmento puede ser usado para capturar los swipes en el calendar
        calendarView.setOnCalendarChangeListener(new OneCalendarView.OnCalendarChangeListener() {

            /**
             * notifica al usuario que el calendario a cambiado al mes anterior
             */
            @Override
            public void prevMonth() {
                Toast.makeText(context, calendarView.getStringMonth(calendarView.getMonth()) + " " + calendarView.getYear(), Toast.LENGTH_SHORT).show();
            }

            /**
             * notifica al usuario que el calendario a cambiado al mes siguiente
             */
            @Override
            public void nextMonth() {
                Toast.makeText(context, calendarView.getStringMonth(calendarView.getMonth()) + " " + calendarView.getYear(), Toast.LENGTH_SHORT).show();
            }
        });


        //el siguiente fragmento de codigo muestra como obtener los datos de un dia en el calendario
        //ademas de realizar otras acciones
        calendarView.setOneCalendarClickListener(new OneCalendarView.OneCalendarClickListener() {

            /**
             * cuando se da click en un dia en el calendario mostrado
             *
             * @param day      un Objeto de tipo Day del cual podemos llara a su metodo getDate() para recuperar una fecha
             * @param position posicion desde 0-41, que ocupa en el calendario actual
             */
            @Override
            public void dateOnClick(Day day, int position) {
                //En java los meses inician desde 0
                //el siguiente fragemento de codigo comprueba si un dia en el calendario esta o no seleccionado

                if (calendarView.isDaySelected(position)) {
                    calendarView.removeDaySeleted(position);
                } else {
                    calendarView.addDaySelected(position);
                }


            }//Fiun dateOnClick

            /**
             * cuando se da click prolongado en un dia en el calendario mostrado
             *
             * @param day      un Objeto de tipo Day del cual podemos llara a su metodo getDate() para recuperar una fecha
             * @param position posicion desde 0-41, que ocupa en el calendario actual
             */
            @Override
            public void dateOnLongClick(Day day, int position) {

            }//Fin dateOnLongClick
        });
    }


}
