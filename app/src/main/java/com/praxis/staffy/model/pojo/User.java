package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private Integer id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("ap_paterno")
    private String apPaterno;
    @SerializedName("ap_materno")
    private String apMaterno;
    @SerializedName("contrasenia")
    private String contrasenia;
    @SerializedName("id_telefono")
    private Integer idTelefono;
    @SerializedName("correo_electronico")
    private String correoElectronico;
    @SerializedName("id_actualizacion")
    private Integer idActualizacion;
    @SerializedName("tm_actualizacion")
    private String tmActualizacion;
    @SerializedName("id_creacion")
    private Integer idCreacion;
    @SerializedName("tm_creacion")
    private String tmCreacion;

    /**
     * No args constructor for use in serialization
     *
     * @param retro3
     * @param retro2
     * @param s2
     * @param f2
     * @param f1
     * @param retro1
     * @param s1
     * @param s
     * @param f
     * @param sd
     * @param retro
     */
    public User(String retro3, String retro2, String s2, String f2, String f1, String retro1, String s1, String s, String f, String sd, String retro) {
    }

    /**
     *
     * @param nombre
     * @param id
     * @param correoElectronico
     * @param tmActualizacion
     * @param apPaterno
     * @param tmCreacion
     * @param idActualizacion
     * @param contrasenia
     * @param idTelefono
     * @param apMaterno
     * @param idCreacion
     */
    public User(Integer id, String nombre, String apPaterno, String apMaterno, String contrasenia, Integer idTelefono, String correoElectronico, Integer idActualizacion, String tmActualizacion, Integer idCreacion, String tmCreacion) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.contrasenia = contrasenia;
        this.idTelefono = idTelefono;
        this.correoElectronico = correoElectronico;
        this.idActualizacion = idActualizacion;
        this.tmActualizacion = tmActualizacion;
        this.idCreacion = idCreacion;
        this.tmCreacion = tmCreacion;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Integer getIdActualizacion() {
        return idActualizacion;
    }

    public void setIdActualizacion(Integer idActualizacion) {
        this.idActualizacion = idActualizacion;
    }

    public String getTmActualizacion() {
        return tmActualizacion;
    }

    public void setTmActualizacion(String tmActualizacion) {
        this.tmActualizacion = tmActualizacion;
    }

    public Integer getIdCreacion() {
        return idCreacion;
    }

    public void setIdCreacion(Integer idCreacion) {
        this.idCreacion = idCreacion;
    }

    public String getTmCreacion() {
        return tmCreacion;
    }

    public void setTmCreacion(String tmCreacion) {
        this.tmCreacion = tmCreacion;
    }

}
