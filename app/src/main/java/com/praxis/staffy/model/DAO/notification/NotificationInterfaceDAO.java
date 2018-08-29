package com.praxis.staffy.model.DAO.notification;

import java.util.ArrayList;

public interface NotificationInterfaceDAO {
    ArrayList<com.praxis.staffy.model.pojo.Notification> getAllnotification();
    void setAllNotification(ArrayList<com.praxis.staffy.model.pojo.Notification> list);

}
