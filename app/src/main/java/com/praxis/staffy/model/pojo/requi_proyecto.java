package com.praxis.staffy.model.pojo;

import java.sql.Time;

public class requi_proyecto {

    private int id;
    private String numero_requi;
    private String observacion;
    private int id_estatus_requi_proyecto;
    private int id_proyecto;
    private Time fh_limite_requi;
    private int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_requi() {
        return numero_requi;
    }

    public void setNumero_requi(String numero_requi) {
        this.numero_requi = numero_requi;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_estatus_requi_proyecto() {
        return id_estatus_requi_proyecto;
    }

    public void setId_estatus_requi_proyecto(int id_estatus_requi_proyecto) {
        this.id_estatus_requi_proyecto = id_estatus_requi_proyecto;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Time getFh_limite_requi() {
        return fh_limite_requi;
    }

    public void setFh_limite_requi(Time fh_limite_requi) {
        this.fh_limite_requi = fh_limite_requi;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
