package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.SerializedName;

public class Client {

    @SerializedName("id_cliente")
    private Integer idCliente;
    @SerializedName("nombre_cliente")
    private String nombreCliente;
    @SerializedName("logo")
    private String logo;
    @SerializedName("id_actualizacion")
    private Integer idActualizacion;
    @SerializedName("tm_actualizacion")
    private String tmActualizacion;
    @SerializedName("id_creacion")
    private Integer idCreacion;
    @SerializedName("tm_creacion")
    private String tmCreacion;

    /**
     * No args constructor for use in serialization
     */
    public Client() {
    }

    /**
     * @param logo
     * @param tmActualizacion
     * @param tmCreacion
     * @param idActualizacion
     * @param idCliente
     * @param idCreacion
     * @param nombreCliente
     */
    public Client(Integer idCliente, String nombreCliente, String logo, Integer idActualizacion, String tmActualizacion, Integer idCreacion, String tmCreacion) {
        super();
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.logo = logo;
        this.idActualizacion = idActualizacion;
        this.tmActualizacion = tmActualizacion;
        this.idCreacion = idCreacion;
        this.tmCreacion = tmCreacion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getIdActualizacion() {
        return idActualizacion;
    }

    public void setIdActualizacion(Integer idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public String getTmActualizacion() {
        return tmActualizacion;
    }

    public void setTmActualizacion(String tmActualizacion) {
        this.tmActualizacion = tmActualizacion;
    }

    public Integer getIdCreacion() {
        return idCreacion;
    }

    public void setIdCreacion(Integer idCreacion) {
        this.idCreacion = idCreacion;
    }

    public String getTmCreacion() {
        return tmCreacion;
    }

    public void setTmCreacion(String tmCreacion) {
        this.tmCreacion = tmCreacion;
    }

}