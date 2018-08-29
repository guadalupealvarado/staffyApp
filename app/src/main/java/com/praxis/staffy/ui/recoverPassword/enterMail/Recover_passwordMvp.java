package com.praxis.staffy.ui.recoverPassword.enterMail;

import com.praxis.staffy.model.pojo.User;
import com.praxis.staffy.model.pojo.MailRecord;

public interface Recover_passwordMvp {
    interface view
    {
        void sendMain();
        void showMessage(String msj);
        void goEnterCode(String code, String mail);

    }
    interface presenter
    {
        void oncreate();
        void ondestroy();

        void searchEmail(String email);
        MailRecord sendMessage(User objusuario, String code);
        boolean sendCode(MailRecord objregistro_correo, String code);
    }

    interface model
    {
        User searchEmail(String email);
        MailRecord sendMessage(User objusuario, String code);
        boolean sendCode(MailRecord objregistro_correo, String code);
    }
}
