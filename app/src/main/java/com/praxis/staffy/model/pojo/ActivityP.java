package com.praxis.staffy.model.pojo;

import java.util.Timer;

public class ActivityP {
    private int id;
    private String descripcion;
    private Timer fh;
    private int id_actualizacion;
    private Timer tm_actualizacion;
    private int id_creacion;
    private Timer tm_creacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timer getFh() {
        return fh;
    }

    public void setFh(Timer fh) {
        this.fh = fh;
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
}
