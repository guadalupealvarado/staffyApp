package com.praxis.staffy.model.pojo;

import java.sql.Time;
import java.util.Timer;

public class entrevista {

    private int id;
    private int id_postulacion;
    private Time fh;
    private int id_estatus_entrevista;
    private Time hora;
    private float dir_longitud;
    private float dir_latitud;
    private int id_actualizacion;
    private Timer tm_actualizacion;
    private int id_creacion;
    private Timer tm_creacion;
    private String acompañante;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getId_estatus_entrevista() {
        return id_estatus_entrevista;
    }

    public void setId_estatus_entrevista(int id_estatus_entrevista) {
        this.id_estatus_entrevista = id_estatus_entrevista;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public float getDir_longitud() {
        return dir_longitud;
    }

    public void setDir_longitud(float dir_longitud) {
        this.dir_longitud = dir_longitud;
    }

    public float getDir_latitud() {
        return dir_latitud;
    }

    public void setDir_latitud(float dir_latitud) {
        this.dir_latitud = dir_latitud;
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

    public String getAcompañante() {
        return acompañante;
    }

    public void setAcompañante(String acompañante) {
        this.acompañante = acompañante;
    }
}
