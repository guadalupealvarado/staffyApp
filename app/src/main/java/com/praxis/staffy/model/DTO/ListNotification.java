package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.Notification;

import java.util.ArrayList;

public class ListNotification
{
    @SerializedName("data")
    private ArrayList<Notification> list;

    public ArrayList<Notification> getList() {
        return list;
    }

    public void setList(ArrayList<Notification> list) {
        this.list = list;
    }
}
