package com.praxis.staffy.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.praxis.staffy.R;


public class User {

    // final debido al nombre de los
    // key para el Session Manager

    public static final String USER = "USER";
    public static final String SALESFORCE = "SALESFORCE";
    public static final String IDSALESFORCE = "IDSALESFORCE";
    public static final String IDREGION = "IDREGION";
    public static final String USER_NAME = "USER_NAME";
    public static final String EMPNUMBER = "EMPNUMBER";
    private String user;
    private String salesForce;
    private String idSalesForce;
    private String idRegion;
    private String userName;
    private String empNumber;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSalesForce() {
        return salesForce;
    }

    public void setSalesForce(String salesForce) {
        this.salesForce = salesForce;
    }

    public String getIdSalesForce() {
        return idSalesForce;
    }

    public void setIdSalesForce(String idSalesForce) {
        this.idSalesForce = idSalesForce;
    }

    public String getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    // guarda en sharedPref
    // Los datos de la persona que recibió como objeto user.
    // y el contexto

    // ?????????????????????????????
    // que es el context.

    public static void saveSession(Context context, User user){
        //objeto de preferencias compartidas-
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.app_name), Context.MODE_PRIVATE);
        //Se crea un editor para manipular.

        SharedPreferences.Editor editor = sharedPref.edit();
        //**Save user in session**//
        editor.putString(USER, user.getUser());
        editor.putString(SALESFORCE, user.getSalesForce());
        editor.putString(IDSALESFORCE, user.getIdSalesForce());
        editor.putString(IDREGION, user.getIdRegion());
        editor.putString(USER_NAME, user.getUserName());
        editor.putString(EMPNUMBER, user.getEmpNumber());
        editor.commit();
    }


    //????????????????????????????????????????????????????????
    //Este metodo lo que hace es obtener de las preferencias compartidas
    //El mombre y de eso lo guarda en un objeto user que retorna.
    public static User getSessionUser(Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(
                context.getString(R.string.app_name), Context.MODE_PRIVATE);

        //Se crea un objeto de User
        User user = new User();
        //El nombre del User es igual al
        //String con el valor
        user.setUserName(sharedPref.getString(USER_NAME, ""));
        return user;
    }
}
