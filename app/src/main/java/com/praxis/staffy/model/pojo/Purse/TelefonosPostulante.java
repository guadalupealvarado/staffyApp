package com.praxis.staffy.model.pojo.Purse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TelefonosPostulante {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_tp_telefono")
    @Expose
    private Integer idTpTelefono;
    @SerializedName("numero")
    @Expose
    private String numero;
    @SerializedName("extension")
    @Expose
    private String extension;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTpTelefono() {
        return idTpTelefono;
    }

    public void setIdTpTelefono(Integer idTpTelefono) {
        this.idTpTelefono = idTpTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
