package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Timer;

public class ActivityP {

    @SerializedName("id_actividad")
    @Expose
    private Integer idActividad;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    @SerializedName("hora")
    @Expose
    private String hora;
    @SerializedName("id_creacion")
    @Expose
    private Integer idCreacion;
    @SerializedName("tm_creacion")
    @Expose
    private String tmCreacion;
    @SerializedName("id_actualizacion")
    @Expose
    private Integer idActualizacion;
    @SerializedName("tm_actualizacion")
    @Expose
    private String tmActualizacion;
    @SerializedName("id_estatus_actividad")
    @Expose
    private Integer idEstatusActividad;
    @SerializedName("estatus_actividad")
    @Expose
    private String estatusActividad;
    @SerializedName("id_tp_actividad")
    @Expose
    private Integer idTpActividad;
    @SerializedName("tp_actividad")
    @Expose
    private String tpActividad;

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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

    public Integer getIdEstatusActividad() {
        return idEstatusActividad;
    }

    public void setIdEstatusActividad(Integer idEstatusActividad) {
        this.idEstatusActividad = idEstatusActividad;
    }

    public String getEstatusActividad() {
        return estatusActividad;
    }

    public void setEstatusActividad(String estatusActividad) {
        this.estatusActividad = estatusActividad;
    }

    public Integer getIdTpActividad() {
        return idTpActividad;
    }

    public void setIdTpActividad(Integer idTpActividad) {
        this.idTpActividad = idTpActividad;
    }

    public String getTpActividad() {
        return tpActividad;
    }

    public void setTpActividad(String tpActividad) {
        this.tpActividad = tpActividad;
    }
}
