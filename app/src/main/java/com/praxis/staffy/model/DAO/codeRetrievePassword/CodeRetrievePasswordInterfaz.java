package com.praxis.staffy.model.DAO.codeRetrievePassword;

import com.praxis.staffy.model.pojo.CodeRecoverPassword;

import java.util.ArrayList;

public interface CodeRetrievePasswordInterfaz
{
    boolean addCodeRetrieve(CodeRecoverPassword code_recover_password);
    CodeRecoverPassword searchCodeRetrievePassword(String code);
    ArrayList<CodeRecoverPassword> getCodesRetrievePassword(int id_user);

}
