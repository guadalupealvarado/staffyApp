package com.praxis.staffy.model.pojo;

import java.sql.Time;

public class notificacion {

    private int id;
    private String descripcion;
    private int id_usuario;
    private Time fh;
    private boolean visto;

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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Time getFh() {
        return fh;
    }

    public void setFh(Time fh) {
        this.fh = fh;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}
