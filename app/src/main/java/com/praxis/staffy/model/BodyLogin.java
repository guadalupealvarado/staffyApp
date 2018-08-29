package com.praxis.staffy.model;

import com.google.gson.annotations.SerializedName;

/**
 *  Model
 *  Que se usa en el GSON
 *
 */

public class BodyLogin {

    @SerializedName("user")
    private String user;
    @SerializedName("password")
    private String password;
    @SerializedName("deviceId")
    private String deviceId;
    @SerializedName("version")
    private String version;

    public BodyLogin(String user, String password, String deviceId, String version) {
        this.user = user;
        this.password = password;
        this.deviceId = deviceId;
        this.version = version;
    }
}
