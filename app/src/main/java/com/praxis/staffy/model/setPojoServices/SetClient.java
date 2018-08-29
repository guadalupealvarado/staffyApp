package com.praxis.staffy.model.setPojoServices;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.Address;

import java.util.ArrayList;
import java.util.List;

public class SetClient {

    @SerializedName("nb_cliente")
    @Expose
    private String nbCliente;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("id_usuario")
    @Expose
    private Integer idUsuario;
    @SerializedName("direcciones")
    @Expose
    private List<Address> direcciones = null;

    public SetClient() {
    }

    /**
     *
     * @param direcciones
     * @param logo
     * @param idUsuario
     * @param nbCliente
     */
    public  SetClient(String nbCliente, String logo, Integer idUsuario, List<Address> direcciones) {
        super();
        this.nbCliente = nbCliente;
        this.logo = logo;
        this.idUsuario = idUsuario;
        this.direcciones = direcciones;
    }

    public String getNbCliente() {
        return nbCliente;
    }

    public void setNbCliente(String nbCliente) {
        this.nbCliente = nbCliente;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Address> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Address> direcciones) {
        this.direcciones = direcciones;
    }

}