package com.praxis.staffy.model.DAO.codeRetrievePassword;

import com.praxis.staffy.model.pojo.CodeRecoverPassword;

import java.util.ArrayList;

public class CodeRetrieverPasswordDAO implements CodeRetrievePasswordInterfaz {

    public  static CodeRetrieverPasswordDAO instance=null;

    public CodeRetrieverPasswordDAO ()
    {
        instance=null;
    }

    public static CodeRetrieverPasswordDAO getInstance() {
        if(instance==null)
        {instance=new CodeRetrieverPasswordDAO();}
        return instance;
    }

    @Override
    public boolean addCodeRetrieve(CodeRecoverPassword code_recover_password) {
        return  true;
    }

    @Override
    public CodeRecoverPassword searchCodeRetrievePassword(String code) {
        return null;
    }

    @Override
    public ArrayList<CodeRecoverPassword> getCodesRetrievePassword(int id_user) {
        return null;
    }
}
