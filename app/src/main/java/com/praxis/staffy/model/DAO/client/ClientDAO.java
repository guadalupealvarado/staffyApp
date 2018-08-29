package com.praxis.staffy.model.DAO.client;

import com.praxis.staffy.model.pojo.Client;

import java.util.ArrayList;

public class ClientDAO implements ClientInterface {

    public static ClientDAO instance;

    public static ClientDAO getInstance()
    {
        if(instance==null)
        {
            instance=new ClientDAO();
        }
        return instance;
    }
    private ClientDAO()
    {}

    ArrayList<Client> list=new ArrayList<>();
    @Override
    public ArrayList<Client> getAllClient() {
        return list;
    }

    @Override
    public void setAllClient(ArrayList<Client> listClient) {
        this.list=listClient;
    }

    @Override
    public Client getClient(int id) {
        return list.get(id);
    }
}
