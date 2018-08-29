package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Address {

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

    /**
     * No args constructor for use in serialization
     *
     */
    public Address() {
    }

    /**
     *
     * @param codigoPostal
     * @param estado
     * @param dirLongitud
     * @param delegacionMunicipio
     * @param dirLatitud
     * @param colonia
     * @param calle
     * @param numero
     * @param referencia
     */
    public Address(String referencia, String calle, String numero, String colonia, String delegacionMunicipio, String estado, String codigoPostal, Double dirLongitud, Double dirLatitud) {
        super();
        this.referencia = referencia;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.delegacionMunicipio = delegacionMunicipio;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.dirLongitud = dirLongitud;
        this.dirLatitud = dirLatitud;
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