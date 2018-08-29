package com.praxis.staffy.model.setPojoServices.updateClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetAddressClientUpdate {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("referencia")
    @Expose
    private String referencia;
    @SerializedName("calle")
    @Expose
    private String calle;
    @SerializedName("numero")
    @Expose
    private String numero;
    @SerializedName("colonia")
    @Expose
    private String colonia;
    @SerializedName("delegacion_municipio")
    @Expose
    private String delegacionMunicipio;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("codigo_postal")
    @Expose
    private String codigoPostal;
    @SerializedName("dir_longitud")
    @Expose
    private Double dirLongitud;
    @SerializedName("dir_latitud")
    @Expose
    private Double dirLatitud;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Double getDirLongitud() {
        return dirLongitud;
    }

    public void setDirLongitud(Double dirLongitud) {
        this.dirLongitud = dirLongitud;
    }

    public Double getDirLatitud() {
        return dirLatitud;
    }

    public void setDirLatitud(Double dirLatitud) {
        this.dirLatitud = dirLatitud;
    }
}
