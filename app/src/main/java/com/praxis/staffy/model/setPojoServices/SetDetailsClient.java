package com.praxis.staffy.model.setPojoServices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetDetailsClient {

    @SerializedName("id_cliente")
    @Expose
    private String idCliente;

    /**
     * No args constructor for use in serialization
     *
     */
    /**
     *
     * @param idCliente
     */
    public SetDetailsClient(String idCliente) {
        super();
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

}