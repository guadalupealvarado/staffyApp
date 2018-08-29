package com.praxis.staffy.model.pojo;

import java.sql.Time;
import java.util.Timer;

public class evaluacion {

    private int id;
    private Time fh;
    private int id_recurso_perfil;
    private int id_experto_recurso;
    private int resultado;
    private String observacion;
    private int id_tp_evaluacion;
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

    public Time getFh() {
        return fh;
    }

    public void setFh(Time fh) {
        this.fh = fh;
    }

    public int getId_recurso_perfil() {
        return id_recurso_perfil;
    }

    public void setId_recurso_perfil(int id_recurso_perfil) {
        this.id_recurso_perfil = id_recurso_perfil;
    }

    public int getId_experto_recurso() {
        return id_experto_recurso;
    }

    public void setId_experto_recurso(int id_experto_recurso) {
        this.id_experto_recurso = id_experto_recurso;
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

    public int getId_tp_evaluacion() {
        return id_tp_evaluacion;
    }

    public void setId_tp_evaluacion(int id_tp_evaluacion) {
        this.id_tp_evaluacion = id_tp_evaluacion;
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
