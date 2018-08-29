package com.praxis.staffy.model.pojo;

public class postulacion {

    private int id;
    private int id_recurso;
    private int id_estatus_postulacion;
    private int id_requi_proyecto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getId_estatus_postulacion() {
        return id_estatus_postulacion;
    }

    public void setId_estatus_postulacion(int id_estatus_postulacion) {
        this.id_estatus_postulacion = id_estatus_postulacion;
    }

    public int getId_requi_proyecto() {
        return id_requi_proyecto;
    }

    public void setId_requi_proyecto(int id_requi_proyecto) {
        this.id_requi_proyecto = id_requi_proyecto;
    }

    public postulacion(String s3, String s2, String s1, String s) {
    }

}
