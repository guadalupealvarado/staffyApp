package com.praxis.staffy.model.setPojoServices;

import com.google.gson.annotations.SerializedName;

public class SetUserModel {
    @SerializedName("correo")
    private String user;
    @SerializedName("password")
    private String password;

    public SetUserModel(String user, String password) {
        this.user = user;
        this.password = password;
    }
}
