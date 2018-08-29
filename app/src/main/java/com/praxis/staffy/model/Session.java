package com.praxis.staffy.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

import com.praxis.staffy.R;

/**
 * Created by Abraham Sánchez Juárez on 03/04/2018.
 */

public class Session {
    private String status;
    private String timeStamp;
    private ArrayList<Payload> payload;
    private String password;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ArrayList<Payload> getPayload() {
        return payload;
    }

    public void setPayload(ArrayList<Payload> payload) {
        this.payload = payload;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void saveSession(Context context){

        //??????????
        /*

        Permite administrar propiedades como POJOs de Java simples y
        almacenarlo en un archivo XML (Justo lo que son las Preferencias
        Compartidas, un archivo XML) para la persistencia y la recuperación.
         */
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.app_name), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        /*
        * Las Preferencias compartidas le permiten guardar y recuperar datos
         * en forma de clave, par de valores. Para usar las preferencias
         * compartidas, debe llamar a un método getSharedPreferences ()
         * que devuelve una instancia de SharedPreference que apunta al
         * archivo que contiene los valores de las preferencias.
        *
        * */

    }
}
