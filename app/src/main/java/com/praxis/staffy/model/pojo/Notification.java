package com.praxis.staffy.model.pojo;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notification {

    @SerializedName("id_notifiacion")
    @Expose
    private Integer idNotifiacion;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("id_usuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("fh")
    @Expose
    private String fh;
    @SerializedName("visto")
    @Expose
    private Boolean visto;

    public Notification() {
    }

    /**
     *
     * @param visto
     * @param idNotifiacion
     * @param idUsuario
     * @param fh
     * @param descripcion
     */
    public Notification(Integer idNotifiacion, String descripcion, Integer idUsuario, String fh, Boolean visto) {
        super();
        this.idNotifiacion = idNotifiacion;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
        this.fh = fh;
        this.visto = visto;
    }

    public Integer getId() {
        return idNotifiacion;
    }

    public void setId(Integer idNotifiacion) {
        this.idNotifiacion = idNotifiacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFh() {
        return fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public Boolean getVisto() {
        return visto;
    }

    public void setVisto(Boolean visto) {
        this.visto = visto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}