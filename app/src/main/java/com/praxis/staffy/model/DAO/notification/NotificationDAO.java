package com.praxis.staffy.model.DAO.notification;

import com.praxis.staffy.model.pojo.Notification;

import java.util.ArrayList;

public class NotificationDAO
{
    private static NotificationDAO instance;
    private ArrayList<Notification> list=new ArrayList<>();

    private NotificationDAO(){
        instance=null;
    }

    public static NotificationDAO getInstance()
    {
        if(instance==null)
        {
            instance=new NotificationDAO();
        }
        return instance;
    }

    public ArrayList<Notification> getList() {
        return list;
    }

    public void setList(ArrayList<Notification> list) {
        this.list = list;
    }
}
