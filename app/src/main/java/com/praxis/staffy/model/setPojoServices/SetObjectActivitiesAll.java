package com.praxis.staffy.model.setPojoServices;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetObjectActivitiesAll {

    @SerializedName("fecha")
    private String fecha;
    @SerializedName("idUsuario")
    private String idUsuario;
    /**
     * No args constructor for use in serialization
     *
     */
    /**
     *
     * @param fecha
     */
    public SetObjectActivitiesAll(String fecha,String idUsuario) {
        super();
        this.fecha = fecha;
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}
