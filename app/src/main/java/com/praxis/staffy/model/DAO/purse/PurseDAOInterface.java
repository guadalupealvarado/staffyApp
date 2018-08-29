package com.praxis.staffy.model.DAO.purse;

import com.praxis.staffy.model.pojo.Purse.InfoRecursoPurse;

import java.util.List;

public interface PurseDAOInterface {
    List<InfoRecursoPurse> getAllResourcePurse();
    void setAllResourcePurse(List<InfoRecursoPurse> infoRecursoPurses);
    InfoRecursoPurse getOneInfoResoucePurse(int id_resource);
}
