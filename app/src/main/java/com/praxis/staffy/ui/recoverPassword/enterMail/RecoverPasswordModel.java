package com.praxis.staffy.ui.recoverPassword.enterMail;

import com.praxis.staffy.model.DAO.codeRetrievePassword.CodeRetrieverPasswordDAO;
import com.praxis.staffy.model.DAO.sendMessage.SendMessageDAO;
import com.praxis.staffy.model.pojo.User;
import com.praxis.staffy.model.pojo.CodeRecoverPassword;
import com.praxis.staffy.model.pojo.MailRecord;

public class RecoverPasswordModel implements Recover_passwordMvp.model {


    public static final int IDNOTFOUND=-1;
    private static final String TITLEMSG="Envio de código para recuperar contraseña";
    public static final int NOTSAVEMSG=1;

    @Override
    public User searchEmail(String email) {
      return null;
    }

    @Override
    public MailRecord sendMessage(User objusuario, String code) {
        try {
            MailRecord save_mailRecord =new MailRecord();
            if(code.isEmpty())
                return null;
            else
                save_mailRecord.setActividad("Envio de código para recuperar contraseña tú cpodigo es : "+code);
            save_mailRecord.setEstatus(true);
            if(objusuario.getCorreoElectronico().isEmpty())
                return null;
            else
                save_mailRecord.setCorreo_electronico(objusuario.getCorreoElectronico());
            save_mailRecord.setTitulo_mensaje(TITLEMSG);
            if(objusuario.getId()!=IDNOTFOUND)
            {
                save_mailRecord.setId_usuario(objusuario.getId());
                save_mailRecord.setId_actualizacion(objusuario.getId());
                save_mailRecord.setId_creacion(objusuario.getId());
            }
            else
                return null;
            //Se lo pasamos en DAO
            return SendMessageDAO.getInstance().saveSendMessage(save_mailRecord);
        } catch (Exception ex)
        {
            return null;
        }
    }


    @Override
    public boolean sendCode(MailRecord objregistro_correo, String code) {

        CodeRecoverPassword objcodigo_recuperar_contrasenia=new CodeRecoverPassword();

        if(objregistro_correo.getId()==-1)
            return false;
        if(code.isEmpty())
            return false;
        else
            objcodigo_recuperar_contrasenia.setCodigo(code);
        //Me quedé aquió
        return CodeRetrieverPasswordDAO.getInstance().addCodeRetrieve(objcodigo_recuperar_contrasenia);

    }
}
