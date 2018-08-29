package com.praxis.staffy.model.DTO;

import com.google.gson.annotations.SerializedName;
import com.praxis.staffy.model.pojo.Project;

import java.util.ArrayList;

public class ListAllProject
{
    @SerializedName("data")
    private ArrayList<Project> projectArrayList=new ArrayList<>();

    public ArrayList<Project> getProjectArrayList() {
        return projectArrayList;
    }

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {
        this.projectArrayList = projectArrayList;
    }
}
