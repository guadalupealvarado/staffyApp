package com.praxis.staffy.model.pojo;

import java.sql.Time;
import java.util.Timer;

public class visita {

    private int id;
    private Time fh;
    private Time hora;
    private float dir_longitud;
    private float dir_latitud;
    private boolean mensaje;
    private int id_recurso;
    private int id_cliente;
    private int id_visita_estatus;
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

    public boolean isMensaje() {
        return mensaje;
    }

    public void setMensaje(boolean mensaje) {
        this.mensaje = mensaje;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_visita_estatus() {
        return id_visita_estatus;
    }

    public void setId_visita_estatus(int id_visita_estatus) {
        this.id_visita_estatus = id_visita_estatus;
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
