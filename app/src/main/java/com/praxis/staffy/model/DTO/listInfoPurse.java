package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.praxis.staffy.model.pojo.Purse.purseInfoGeneral;

import java.util.List;

public class listInfoPurse {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<purseInfoGeneral> infoRecursoPurseList = null;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public listInfoPurse() {
    }

    /**
     *
     * @param message
     * @param status
     * @param infoRecursoPurseList
     */
    public listInfoPurse(String status, List<purseInfoGeneral> infoRecursoPurseList, String message) {
        super();
        this.status = status;
        this.infoRecursoPurseList = infoRecursoPurseList;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<purseInfoGeneral> getData() {
        return infoRecursoPurseList;
    }

    public void setData(List<purseInfoGeneral> infoRecursoPurseList) {
        this.infoRecursoPurseList = infoRecursoPurseList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
