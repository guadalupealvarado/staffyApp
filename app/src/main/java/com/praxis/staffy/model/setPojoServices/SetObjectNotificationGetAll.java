package com.praxis.staffy.model.setPojoServices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetObjectNotificationGetAll {

    @SerializedName("idUsuario")
    @Expose
    private String idUsuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public SetObjectNotificationGetAll() {
    }

    /**
     *
     * @param idUsuario
     */
    public SetObjectNotificationGetAll(String idUsuario) {
        super();
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}