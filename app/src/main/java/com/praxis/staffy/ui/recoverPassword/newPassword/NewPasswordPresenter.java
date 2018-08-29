package com.praxis.staffy.ui.recoverPassword.newPassword;

public class NewPasswordPresenter implements NewPasswordMVP.presentador {
    private NewPasswordView view=null;
    private NewPasswordModel model=null;
    public NewPasswordPresenter(NewPasswordView view)
    {
        this.view=view;
        this.model=new NewPasswordModel();
    }
    @Override
    public void newPassword(String code, String newPassword) {
        if(model.newPassword(code,newPassword))
            view.goToIndex();
            else
                view.showMessage("No se puede realizar");

    }
}
