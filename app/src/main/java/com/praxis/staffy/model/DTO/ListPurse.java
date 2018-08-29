package com.praxis.staffy.model.DTO;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;

public class ListPurse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("data")
    @Expose
    private List<InfoRecursoPurse> infoRecursoPurseList = null;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public ListPurse() {
    }

    /**
     *
     * @param message
     * @param status
     * @param infoRecursoPurseList
     */
    public ListPurse(String status, List<InfoRecursoPurse> infoRecursoPurseList, String message) {
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

    public List<InfoRecursoPurse> getData() {
        return infoRecursoPurseList;
    }

    public void setData(List<InfoRecursoPurse> infoRecursoPurseList) {
        this.infoRecursoPurseList = infoRecursoPurseList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}