package com.praxis.staffy.ui.recoverPassword.enterMail;

import com.praxis.staffy.ui.MyAplication;
import com.praxis.staffy.R;
import com.praxis.staffy.model.pojo.User;
import com.praxis.staffy.model.pojo.MailRecord;
import com.praxis.staffy.utils.GeneratePasswordRecoveryCode;

public class RecoverPasswordPresenterImp implements Recover_passwordMvp.presenter
{

    private Recover_passwordMvp.model model;
    private Recover_passwordMvp.view view;

    public RecoverPasswordPresenterImp(RecoverPasswordView view)
    {
        this.view=view;
        this.model=new RecoverPasswordModel();

    }

    @Override
    public void oncreate() {

    }

    @Override
    public void ondestroy() {

    }

    @Override
    public void searchEmail(String mail)
    {
        User objuasuario=model.searchEmail(mail);
       if( objuasuario.getId()!=RecoverPasswordModel.IDNOTFOUND)
       {
           String code=GeneratePasswordRecoveryCode.generateCode();
           MailRecord objMailRecord =sendMessage(objuasuario,code);
           if(objMailRecord !=null)
           {
               view.showMessage(String.valueOf(sendMessage(objuasuario,code).getId()));
                if (model.sendCode(objMailRecord,code))
                    view.goEnterCode(code,mail);
                else
                    view.showMessage("No pudimos enviar el código.");
           }
           else{
               view.showMessage("El mensaje no fue enviado.");
           }
       }else
       {
           view.showMessage(MyAplication.getContext().getResources().getString(R.string.the_mail_was_not_found_msg));
       }

    }

    @Override
    public MailRecord sendMessage(User objusuario, String code) {
        return model.sendMessage(objusuario,code);
    }

    @Override
    public boolean sendCode(MailRecord objregistro_correo, String code) {
        return model.sendCode(objregistro_correo,code);

    }
}
