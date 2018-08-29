package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.Client;

import java.util.ArrayList;

public class ListClient {
    @SerializedName("data")
    ArrayList<Client> list;

    public ArrayList<Client> getList() {
        return list;
    }

    public void setList(ArrayList<Client> list) {
        this.list = list;
    }
}
