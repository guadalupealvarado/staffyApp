package com.praxis.staffy.model.pojo;

import java.sql.Time;
import java.util.Timer;

public class recurso {
    private int id;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private Time fh_nacimiento;
    private String correo_electronico;
    private int id_tp_recurso;
    private int id_actualizacion;
    private Timer tm_actualizacion;
    private int id_creacion;
    private Timer tm_creacion;
    private Time fh_disponibilidad;
    private String descripcion;
    private String area;
    private boolean es_experto;
    private String observacion;
    private int id_archivo;
    private int periodo_evaluacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public Time getFh_nacimiento() {
        return fh_nacimiento;
    }

    public void setFh_nacimiento(Time fh_nacimiento) {
        this.fh_nacimiento = fh_nacimiento;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public int getId_tp_recurso() {
        return id_tp_recurso;
    }

    public void setId_tp_recurso(int id_tp_recurso) {
        this.id_tp_recurso = id_tp_recurso;
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

    public Time getFh_disponibilidad() {
        return fh_disponibilidad;
    }

    public void setFh_disponibilidad(Time fh_disponibilidad) {
        this.fh_disponibilidad = fh_disponibilidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isEs_experto() {
        return es_experto;
    }

    public void setEs_experto(boolean es_experto) {
        this.es_experto = es_experto;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(int id_archivo) {
        this.id_archivo = id_archivo;
    }

    public int getPeriodo_evaluacion() {
        return periodo_evaluacion;
    }

    public void setPeriodo_evaluacion(int periodo_evaluacion) {
        this.periodo_evaluacion = periodo_evaluacion;
    }
}
