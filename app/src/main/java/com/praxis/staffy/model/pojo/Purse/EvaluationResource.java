package com.praxis.staffy.model.pojo.Purse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EvaluationResource {

    @SerializedName("id_recurso_perfil")
    @Expose
    private Integer idRecursoPerfil;
    @SerializedName("id_tp_evaluacion")
    @Expose
    private Integer idTpEvaluacion;
    @SerializedName("id_experto_recurso")
    @Expose
    private Integer idExpertoRecurso;
    @SerializedName("resultado")
    @Expose
    private Integer resultado;
    @SerializedName("observacion")
    @Expose
    private String observacion;
    @SerializedName("id_estatus_evaluacion")
    @Expose
    private Integer idEstatusEvaluacion;
    @SerializedName("estatus_evaluacion")
    @Expose
    private String estatusEvaluacion;
    @SerializedName("id_rango")
    @Expose
    private Integer idRango;
    @SerializedName("id_perfil")
    @Expose
    private Integer idPerfil;

    /**
     * No args constructor for use in serialization
     *
     */
    public EvaluationResource() {
    }

    /**
     *
     * @param idPerfil
     * @param idEstatusEvaluacion
     * @param estatusEvaluacion
     * @param observacion
     * @param idExpertoRecurso
     * @param idRango
     * @param idRecursoPerfil
     * @param resultado
     * @param idTpEvaluacion
     */
    public EvaluationResource(Integer idRecursoPerfil, Integer idTpEvaluacion, Integer idExpertoRecurso, Integer resultado, String observacion, Integer idEstatusEvaluacion, String estatusEvaluacion, Integer idRango, Integer idPerfil) {
        super();
        this.idRecursoPerfil = idRecursoPerfil;
        this.idTpEvaluacion = idTpEvaluacion;
        this.idExpertoRecurso = idExpertoRecurso;
        this.resultado = resultado;
        this.observacion = observacion;
        this.idEstatusEvaluacion = idEstatusEvaluacion;
        this.estatusEvaluacion = estatusEvaluacion;
        this.idRango = idRango;
        this.idPerfil = idPerfil;
    }

    public Integer getIdRecursoPerfil() {
        return idRecursoPerfil;
    }

    public void setIdRecursoPerfil(Integer idRecursoPerfil) {
        this.idRecursoPerfil = idRecursoPerfil;
    }

    public Integer getIdTpEvaluacion() {
        return idTpEvaluacion;
    }

    public void setIdTpEvaluacion(Integer idTpEvaluacion) {
        this.idTpEvaluacion = idTpEvaluacion;
    }

    public Integer getIdExpertoRecurso() {
        return idExpertoRecurso;
    }

    public void setIdExpertoRecurso(Integer idExpertoRecurso) {
        this.idExpertoRecurso = idExpertoRecurso;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getIdEstatusEvaluacion() {
        return idEstatusEvaluacion;
    }

    public void setIdEstatusEvaluacion(Integer idEstatusEvaluacion) {
        this.idEstatusEvaluacion = idEstatusEvaluacion;
    }

    public String getEstatusEvaluacion() {
        return estatusEvaluacion;
    }

    public void setEstatusEvaluacion(String estatusEvaluacion) {
        this.estatusEvaluacion = estatusEvaluacion;
    }

    public Integer getIdRango() {
        return idRango;
    }

    public void setIdRango(Integer idRango) {
        this.idRango = idRango;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

}