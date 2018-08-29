package com.praxis.staffy.model.pojo;

import java.util.Timer;

public class MailRecord {
    private int id;
    private String actividad;
    private boolean estatus;
    private String correo_electronico;
    private String titulo_mensaje;
    private int id_usuario;
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

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getTitulo_mensaje() {
        return titulo_mensaje;
    }

    public void setTitulo_mensaje(String titulo_mensaje) {
        this.titulo_mensaje = titulo_mensaje;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
