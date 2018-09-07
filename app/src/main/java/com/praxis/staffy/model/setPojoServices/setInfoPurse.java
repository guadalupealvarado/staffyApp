package com.praxis.staffy.model.setPojoServices;

import com.google.gson.annotations.SerializedName;

public class setInfoPurse {
    @SerializedName("id_recurso")
    private String id_recurso;

    public setInfoPurse(String id_recurso) {
        this.id_recurso = id_recurso;
    }




    public String getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(String id_recurso) {
        this.id_recurso = id_recurso;
    }
}
