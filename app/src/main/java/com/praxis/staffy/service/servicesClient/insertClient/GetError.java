package com.praxis.staffy.service.servicesClient.insertClient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetError {

    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     *
     */
    public GetError() {
    }

    /**
     *
     * @param data
     */
    public GetError(Data data) {
        super();
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}