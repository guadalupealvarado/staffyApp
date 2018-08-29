package com.praxis.staffy.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CodeRecoverPassword {

    @SerializedName("correo")
    @Expose
    private String correo;
    @SerializedName("codigo")
    @Expose
    private String codigo;
    @SerializedName("usuario_id")
    @Expose
    private Integer usuarioId;

    /**
     * No args constructor for use in serialization
     *
     */
    public CodeRecoverPassword() {
    }

    /**
     *
     * @param codigo
     * @param usuarioId
     * @param correo
     */
    public CodeRecoverPassword(String correo, String codigo, Integer usuarioId) {
        super();
        this.correo = correo;
        this.codigo = codigo;
        this.usuarioId = usuarioId;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

}