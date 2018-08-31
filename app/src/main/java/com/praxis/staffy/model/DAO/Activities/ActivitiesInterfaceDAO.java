package com.praxis.staffy.model.DAO.Activities;

import com.praxis.staffy.model.pojo.ActivityP;
import com.praxis.staffy.model.pojo.Notification;

import java.util.ArrayList;

public interface ActivitiesInterfaceDAO {
    ArrayList<com.praxis.staffy.model.pojo.ActivityP> getAllActivities();
    void setAllActivities(ArrayList<com.praxis.staffy.model.pojo.ActivityP> list);
}
