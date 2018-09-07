package com.praxis.staffy.model.pojo.Purse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class purseInfoGeneral {

    @SerializedName("id_recurso")
    @Expose
    private Integer idRecurso;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("ap_paterno")
    @Expose
    private String apPaterno;
    @SerializedName("ap_materno")
    @Expose
    private String apMaterno;
    @SerializedName("correo_electronico")
    @Expose
    private String correoElectronico;
    @SerializedName("fh_disponibilidad")
    @Expose
    private String fhDisponibilidad;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("observacion")
    @Expose
    private String observacion;
    @SerializedName("periodo_evaluacion")
    @Expose
    private Integer periodoEvaluacion;
    @SerializedName("id_tp_recurso")
    @Expose
    private Integer idTpRecurso;
    @SerializedName("telefonos_postulante")
    @Expose
    private List<TelefonosPostulante> telefonosPostulante = null;
    @SerializedName("fh_reclutamiento")
    @Expose
    private String fhReclutamiento;
    @SerializedName("id_reclutador")
    @Expose
    private Integer idReclutador;
    @SerializedName("nombre_reclutador")
    @Expose
    private String nombreReclutador;
    @SerializedName("ap_paterno_reclutador")
    @Expose
    private String apPaternoReclutador;
    @SerializedName("ap_materno_reclutador")
    @Expose
    private String apMaternoReclutador;
    @SerializedName("telefonos_reclutador")
    @Expose
    private List<TelefonosReclutador> telefonosReclutador = null;

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getFhDisponibilidad() {
        return fhDisponibilidad;
    }

    public void setFhDisponibilidad(String fhDisponibilidad) {
        this.fhDisponibilidad = fhDisponibilidad;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getPeriodoEvaluacion() {
        return periodoEvaluacion;
    }

    public void setPeriodoEvaluacion(Integer periodoEvaluacion) {
        this.periodoEvaluacion = periodoEvaluacion;
    }

    public Integer getIdTpRecurso() {
        return idTpRecurso;
    }

    public void setIdTpRecurso(Integer idTpRecurso) {
        this.idTpRecurso = idTpRecurso;
    }

    public List<TelefonosPostulante> getTelefonosPostulante() {
        return telefonosPostulante;
    }

    public void setTelefonosPostulante(List<TelefonosPostulante> telefonosPostulante) {
        this.telefonosPostulante = telefonosPostulante;
    }

    public String getFhReclutamiento() {
        return fhReclutamiento;
    }

    public void setFhReclutamiento(String fhReclutamiento) {
        this.fhReclutamiento = fhReclutamiento;
    }

    public Integer getIdReclutador() {
        return idReclutador;
    }

    public void setIdReclutador(Integer idReclutador) {
        this.idReclutador = idReclutador;
    }

    public String getNombreReclutador() {
        return nombreReclutador;
    }

    public void setNombreReclutador(String nombreReclutador) {
        this.nombreReclutador = nombreReclutador;
    }

    public String getApPaternoReclutador() {
        return apPaternoReclutador;
    }

    public void setApPaternoReclutador(String apPaternoReclutador) {
        this.apPaternoReclutador = apPaternoReclutador;
    }

    public String getApMaternoReclutador() {
        return apMaternoReclutador;
    }

    public void setApMaternoReclutador(String apMaternoReclutador) {
        this.apMaternoReclutador = apMaternoReclutador;
    }

    public List<TelefonosReclutador> getTelefonosReclutador() {
        return telefonosReclutador;
    }

    public void setTelefonosReclutador(List<TelefonosReclutador> telefonosReclutador) {
        this.telefonosReclutador = telefonosReclutador;
    }
}
