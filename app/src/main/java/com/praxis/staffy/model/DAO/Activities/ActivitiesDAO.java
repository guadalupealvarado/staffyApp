package com.praxis.staffy.model.DAO.Activities;


import com.praxis.staffy.model.pojo.ActivityP;

import java.util.ArrayList;

public class ActivitiesDAO {
    private static ActivitiesDAO instance;
    private ArrayList<ActivityP> list=new ArrayList<>();

    private ActivitiesDAO(){
        instance=null;
    }

    public static ActivitiesDAO getInstance()
    {
        if(instance==null)
        {
            instance=new ActivitiesDAO();
        }
        return instance;
    }

    public ArrayList<ActivityP> getList() {
        return list;
    }

    public void setList(ArrayList<ActivityP> list) {
        this.list = list;
    }
}
