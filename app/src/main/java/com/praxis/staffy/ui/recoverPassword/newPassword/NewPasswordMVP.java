package com.praxis.staffy.ui.recoverPassword.newPassword;

public interface NewPasswordMVP {
    interface view
    {
        void goAccess();

    }
    interface presentador
    {
        void newPassword(String code, String newPassword);
    }
    interface model
    {
        boolean newPassword(String code, String newPassword);

    }
}
