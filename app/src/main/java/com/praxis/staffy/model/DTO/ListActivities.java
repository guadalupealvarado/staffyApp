package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.ActivityP;

import java.util.ArrayList;

public class ListActivities {
    @SerializedName("data")
    private ArrayList<ActivityP> list;

    public ArrayList<ActivityP> getList() {
        return list;
    }

    public void setList(ArrayList<ActivityP> list) {
        this.list = list;
    }
}
