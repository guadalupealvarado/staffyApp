package com.praxis.staffy.model.pojo;

import java.sql.Time;
import java.util.Timer;

public class filtro {
    private int id;
    private int id_experto_recurso;
    private int id_postulacion;
    private Time fh;
    private int id_filtro_estatus;
    private int resultado;
    private String observacion;
    private Time hora;
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

    public int getId_experto_recurso() {
        return id_experto_recurso;
    }

    public void setId_experto_recurso(int id_experto_recurso) {
        this.id_experto_recurso = id_experto_recurso;
    }

    public int getId_postulacion() {
        return id_postulacion;
    }

    public void setId_postulacion(int id_postulacion) {
        this.id_postulacion = id_postulacion;
    }

    public Time getFh() {
        return fh;
    }

    public void setFh(Time fh) {
        this.fh = fh;
    }

    public int getId_filtro_estatus() {
        return id_filtro_estatus;
    }

    public void setId_filtro_estatus(int id_filtro_estatus) {
        this.id_filtro_estatus = id_filtro_estatus;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
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
