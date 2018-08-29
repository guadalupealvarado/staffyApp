package com.praxis.staffy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeLapsedNotification {
    public String getNotificationDate(String DateNotification) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m");

        //Obtenemos los valores del Dia,Mes y Año en curso
        String Day = Integer.toString(calendar.get(Calendar.DATE));
        String Month = Integer.toString(calendar.get(Calendar.MONTH) + 1);
        String Year = Integer.toString(calendar.get(Calendar.YEAR));
        String Hour = Integer.toString(calendar.get(Calendar.HOUR));
        String Minutes = Integer.toString(calendar.get(Calendar.MINUTE));
        //Damos formato a las fechas de la notificacion y del sistema para poder hacer el calculo de tiempo

        Date DateToday = dateFormat.parse(Year + "-" + Month + "-" + Day + " " + Hour + ":" + Minutes);
        Date DateNotif = dateFormat.parse(DateNotification);
        int timeDifference = (int) ((DateToday.getTime() - DateNotif.getTime()) / 1000);
        int hourLapsed = 0;
        int dayLapsed = 0;
        int minutesLapsed = 0;
        String timeTotal;
        //Se hacen los calculos correspondientes al tiempo
        if (timeDifference > 86400) {
            dayLapsed = (int) Math.floor(timeDifference / 86400);
            timeDifference = timeDifference - (dayLapsed * 86400);
        }
        if (timeDifference > 3600) {
            hourLapsed = (int) Math.floor(timeDifference / 3600);
            timeDifference = timeDifference - (hourLapsed * 3600);
        }
        if (timeDifference > 1) {
            minutesLapsed = (int) Math.floor(timeDifference / 60);
            timeDifference = timeDifference - (minutesLapsed * 60);
        }
        //Evaluo la forma de mostrar el tiempo en la UI
        if (dayLapsed <= 0) {
            timeTotal = hourLapsed + " Hrs." + " " + minutesLapsed + " min.";
        } else {
            timeTotal = dayLapsed + " d " + " " + hourLapsed + " Hrs." + " " + minutesLapsed + " min.";
        }
        if (hourLapsed <= 0) {
            timeTotal = minutesLapsed + " minutos";
        } else {
            if (dayLapsed > 0) {
                timeTotal = dayLapsed + " d " + " " + hourLapsed + " Hrs." + " " + minutesLapsed + " min.";

            } else {
                timeTotal = hourLapsed + " Hrs." + " " + minutesLapsed + " min.";
            }
        }
        return timeTotal;
    }
}
