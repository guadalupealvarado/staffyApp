package com.praxis.staffy.model.pojo;

import java.sql.Time;

public class proxima_retro {

    private int id_recurso;
    private Time fh;
    private int id_estatus_actividad;

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public Time getFh() {
        return fh;
    }

    public void setFh(Time fh) {
        this.fh = fh;
    }

    public int getId_estatus_actividad() {
        return id_estatus_actividad;
    }

    public void setId_estatus_actividad(int id_estatus_actividad) {
        this.id_estatus_actividad = id_estatus_actividad;
    }
}
