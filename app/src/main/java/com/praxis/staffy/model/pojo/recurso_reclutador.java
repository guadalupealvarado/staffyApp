package com.praxis.staffy.model.pojo;

import java.sql.Time;

public class recurso_reclutador {
    private int id_recurso;
    private int id_reclutador_recurso;
    private Time fh_reclutamiento;

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getId_reclutador_recurso() {
        return id_reclutador_recurso;
    }

    public void setId_reclutador_recurso(int id_reclutador_recurso) {
        this.id_reclutador_recurso = id_reclutador_recurso;
    }

    public Time getFh_reclutamiento() {
        return fh_reclutamiento;
    }

    public void setFh_reclutamiento(Time fh_reclutamiento) {
        this.fh_reclutamiento = fh_reclutamiento;
    }
}
