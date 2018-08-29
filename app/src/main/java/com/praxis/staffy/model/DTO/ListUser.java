package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.User;

import java.util.ArrayList;

public class ListUser {

    @SerializedName("data")
    private ArrayList<User> list;

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
}
