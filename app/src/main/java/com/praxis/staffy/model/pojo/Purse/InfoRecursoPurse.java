package com.praxis.staffy.model.pojo.Purse;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InfoRecursoPurse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("ap_paterno")
    @Expose
    private String apPaterno;
    @SerializedName("ap_materno")
    @Expose
    private String apMaterno;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("es_experto")
    @Expose
    private Boolean esExperto;
    @SerializedName("id_tp_recurso")
    @Expose
    private Integer idTpRecurso;
    @SerializedName("tp_recurso")
    @Expose
    private String tpRecurso;
    @SerializedName("recurso_perfil")
    @Expose
    private List<ResourceProfile> resourceProfiles = null;
    @SerializedName("evaluaciones")
    @Expose
    private List<EvaluationResource> evaluationResources= null;

    /**
     * No args constructor for use in serialization
     *
     */
    public InfoRecursoPurse() {
    }

    /**
     *
     * @param nombre
     * @param id
     * @param tpRecurso
     * @param area
     * @param idTpRecurso
     * @param apPaterno
     * @param resourceProfiles
     * @param esExperto
     * @param apMaterno
     * @param evaluationResources
     */
    public InfoRecursoPurse(Integer id, String nombre, String apPaterno,
                            String apMaterno, String area, Boolean esExperto,
                            Integer idTpRecurso, String tpRecurso, List<ResourceProfile> resourceProfiles,
                            List<EvaluationResource> evaluationResources) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.area = area;
        this.esExperto = esExperto;
        this.idTpRecurso = idTpRecurso;
        this.tpRecurso = tpRecurso;
        this.resourceProfiles = resourceProfiles;
        this.evaluationResources = evaluationResources;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Boolean getEsExperto() {
        return esExperto;
    }

    public void setEsExperto(Boolean esExperto) {
        this.esExperto = esExperto;
    }

    public Integer getIdTpRecurso() {
        return idTpRecurso;
    }

    public void setIdTpRecurso(Integer idTpRecurso) {
        this.idTpRecurso = idTpRecurso;
    }

    public String getTpRecurso() {
        return tpRecurso;
    }

    public void setTpRecurso(String tpRecurso) {
        this.tpRecurso = tpRecurso;
    }

    public List<ResourceProfile> getRecursoPerfil() {
        return resourceProfiles;
    }

    public void setRecursoPerfil(List<ResourceProfile> recursoPerfil) {
        this.resourceProfiles = recursoPerfil;
    }

    public List<EvaluationResource> getEvaluaciones() {
        return evaluationResources;
    }

    public void setEvaluaciones(List<EvaluationResource> evaluaciones) {
        this.evaluationResources = evaluaciones;
    }

}