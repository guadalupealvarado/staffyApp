package com.praxis.staffy.model.pojo;

import java.sql.Time;
import java.util.Timer;

public class solicitud {

    private int id;
    private int id_tp_solicitud;
    private Time fh_inicio;
    private Time fh_fin;
    private String motivo;
    private String correo_electronico;
    private int id_recurso;
    private int id_actualizacion;
    private Timer tm_actualizacion;
    private int id_creacion;
    private Timer tm_creacion;
    private int id_estatus_solicitud;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_tp_solicitud() {
        return id_tp_solicitud;
    }

    public void setId_tp_solicitud(int id_tp_solicitud) {
        this.id_tp_solicitud = id_tp_solicitud;
    }

    public Time getFh_inicio() {
        return fh_inicio;
    }

    public void setFh_inicio(Time fh_inicio) {
        this.fh_inicio = fh_inicio;
    }

    public Time getFh_fin() {
        return fh_fin;
    }

    public void setFh_fin(Time fh_fin) {
        this.fh_fin = fh_fin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getId_actualizacion() {
        return id_actualizacion;
    }

    public void setId_actualizacion(int id_actualizacion) {
        this.id_actualizacion = id_actualizacion;
    }

    public Timer getTm_actualizacion() {
        return tm_actualizacion;
    }

    public void setTm_actualizacion(Timer tm_actualizacion) {
        this.tm_actualizacion = tm_actualizacion;
    }

    public int getId_creacion() {
        return id_creacion;
    }

    public void setId_creacion(int id_creacion) {
        this.id_creacion = id_creacion;
    }

    public Timer getTm_creacion() {
        return tm_creacion;
    }

    public void setTm_creacion(Timer tm_creacion) {
        this.tm_creacion = tm_creacion;
    }

    public int getId_estatus_solicitud() {
        return id_estatus_solicitud;
    }

    public void setId_estatus_solicitud(int id_estatus_solicitud) {
        this.id_estatus_solicitud = id_estatus_solicitud;
    }
}
