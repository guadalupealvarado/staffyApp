package com.praxis.staffy.model.pojo.Purse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResourceProfile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("id_perfil")
    @Expose
    private Integer idPerfil;
    @SerializedName("id_rango")
    @Expose
    private Integer idRango;
    @SerializedName("perfil")
    @Expose
    private String perfil;
    @SerializedName("rango")
    @Expose
    private String rango;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResourceProfile() {
    }

    /**
     *
     * @param idPerfil
     * @param id
     * @param idRango
     * @param perfil
     * @param rango
     */
    public ResourceProfile(Integer id, Integer idPerfil, Integer idRango, String perfil, String rango) {
        super();
        this.id = id;
        this.idPerfil = idPerfil;
        this.idRango = idRango;
        this.perfil = perfil;
        this.rango = rango;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdRango() {
        return idRango;
    }

    public void setIdRango(Integer idRango) {
        this.idRango = idRango;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

}