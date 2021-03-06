package com.praxis.staffy.model.DAO.purse;

import com.praxis.staffy.model.DTO.listInfoPurse;
import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;
import com.praxis.staffy.model.pojo.Purse.purseInfoGeneral;

import java.util.ArrayList;
import java.util.List;


public class PurseDAO implements PurseDAOInterface {

    private static PurseDAO instance;
    List<InfoRecursoPurse> infoRecursoPurses=new ArrayList<>();
    List<purseInfoGeneral> infoPurses= new ArrayList<>();

    private PurseDAO()
    { }

    public static PurseDAO getInstance()
    {
        if(instance==null)
        {
            instance=new PurseDAO();
        }return instance;
    }


    @Override
    public List<InfoRecursoPurse> getAllResourcePurse() {
        return infoRecursoPurses;
    }

    @Override
    public void setAllResourcePurse(List<InfoRecursoPurse> infoRecursoPurses) {
        this.infoRecursoPurses=infoRecursoPurses;
    }

    @Override
    public InfoRecursoPurse getOneInfoResoucePurse(int id_resource) {
        for(int i=0;i>infoRecursoPurses.size();i++)
        {
            if(infoRecursoPurses.get(i).getId()==id_resource)
            {
                return infoRecursoPurses.get(i);
            }
        }
        return null;
    }

    public List<purseInfoGeneral> getInfoResourcePurse() {
        return infoPurses;
    }

    @Override
    public void setInfoResourcePurse(List<purseInfoGeneral> infoPurses) {
        this.infoPurses=infoPurses;
}
}
