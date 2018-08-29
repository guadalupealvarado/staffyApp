package com.praxis.staffy.model.DTO.restorePassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectRestorePassword {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private RestorePassword restorePassword;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public ObjectRestorePassword() {
    }

    /**
     *
     * @param message
     * @param status
     * @param restorePassword
     */
    public ObjectRestorePassword(String status, RestorePassword restorePassword, String message) {
        super();
        this.status = status;
        this.restorePassword = restorePassword;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RestorePassword getData() {
        return restorePassword;
    }

    public void setData(RestorePassword restorePassword) {
        this.restorePassword = restorePassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

