package com.praxis.staffy.ui.recoverPassword.newPassword;

import com.praxis.staffy.model.DAO.user.UserDAO;
import com.praxis.staffy.model.pojo.User;

public class NewPasswordModel implements NewPasswordMVP.model {
    @Override
    public boolean newPassword(String code, String newPassword) {
        User objusuario= UserDAO.getInstance().getUserToChangePassword(code);
        return UserDAO.getInstance().changeOfPassword(objusuario.getId(),newPassword,objusuario.getCorreoElectronico());
    }
}
