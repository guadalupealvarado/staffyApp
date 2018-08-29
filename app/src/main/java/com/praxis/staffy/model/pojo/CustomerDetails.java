package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CustomerDetails {

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
    @SerializedName("contactos")
    private Object contactos;
    @SerializedName("proyectos")
    private Object proyectos;
    @SerializedName("direcciones")
    private List<AddressCustomerDetails> direcciones =new ArrayList<>();
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
    public Object getContactos() {
        return contactos;
    }

    public void setContactos(Object contactos) {
        this.contactos = contactos;
    }

    public Object getProyectos() {
        return proyectos;
    }

    public void setProyectos(Object proyectos) {
        this.proyectos = proyectos;
    }

    public List<AddressCustomerDetails> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<AddressCustomerDetails> direcciones) {
        this.direcciones = direcciones;
    }

}