package com.praxis.staffy.model.DAO.user;

import com.praxis.staffy.model.pojo.User;

import java.util.List;

public interface UserDAOInterfaz {

    List<User> getAllUser();
    User getUser(int id);
    boolean changeOfPassword(int id_user, String newPassword, String correo);
    User getUserToChangePassword(String code);
    int getSizeList();
    void addUser(User user);
}
