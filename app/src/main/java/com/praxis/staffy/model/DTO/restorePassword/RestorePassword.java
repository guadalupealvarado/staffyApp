package com.praxis.staffy.model.DTO.restorePassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RestorePassword {

    @SerializedName("restaurar_password")
    @Expose
    private Integer restaurarPassword;

    /**
     *
     * @param restaurarPassword
     */
    public RestorePassword(Integer restaurarPassword) {
        super();
        this.restaurarPassword = restaurarPassword;
    }

    public Integer getRestaurarPassword() {
        return restaurarPassword;
    }

    public void setRestaurarPassword(Integer restaurarPassword) {
        this.restaurarPassword = restaurarPassword;
    }

}