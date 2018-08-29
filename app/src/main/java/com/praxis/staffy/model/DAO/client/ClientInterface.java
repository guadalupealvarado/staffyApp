package com.praxis.staffy.model.DAO.client;

import com.praxis.staffy.model.pojo.Client;

import java.util.ArrayList;

public interface ClientInterface {

    ArrayList<Client> getAllClient();
    void setAllClient(ArrayList<Client> listClient);
    Client getClient(int id);

}
