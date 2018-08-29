package com.praxis.staffy.model.DTO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.CodeRecoverPassword;

public class ObjectRecoverPassword {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private CodeRecoverPassword data;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public ObjectRecoverPassword() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ObjectRecoverPassword(String status, CodeRecoverPassword data, String message) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CodeRecoverPassword getData() {
        return data;
    }

    public void setData(CodeRecoverPassword data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}