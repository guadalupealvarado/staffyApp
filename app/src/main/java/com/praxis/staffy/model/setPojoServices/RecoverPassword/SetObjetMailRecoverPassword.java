package com.praxis.staffy.model.setPojoServices.RecoverPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetObjetMailRecoverPassword {

    @SerializedName("correo")
    @Expose
    private String correo;

    /**
     * No args constructor for use in serialization
     *
     */
    /**
     *
     * @param correo
     */
    public SetObjetMailRecoverPassword(String correo) {
        super();
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}