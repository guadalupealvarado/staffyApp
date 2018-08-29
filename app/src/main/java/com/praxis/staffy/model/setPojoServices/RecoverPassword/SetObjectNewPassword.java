package com.praxis.staffy.model.setPojoServices.RecoverPassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetObjectNewPassword {

    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("passwordNuevo")
    @Expose
    private String passwordNuevo;

    /**
     * No args constructor for use in serialization
     *
     */
    /**
     *
     * @param codigo
     * @param correo
     * @param passwordNuevo
     */
    public SetObjectNewPassword(String correo, String codigo, String passwordNuevo) {
        super();
        this.correo = correo;
        this.codigo = codigo;
        this.passwordNuevo = passwordNuevo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPasswordNuevo() {
        return passwordNuevo;
    }

    public void setPasswordNuevo(String passwordNuevo) {
        this.passwordNuevo = passwordNuevo;
    }

}