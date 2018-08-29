package com.praxis.staffy.model.DAO.sendMessage;

import com.praxis.staffy.model.pojo.MailRecord;

import java.util.ArrayList;
import java.util.List;

public class SendMessageDAO implements sendMessageInterfaz {


    private  static SendMessageDAO instance=null;
    private ArrayList<MailRecord> list;

    private SendMessageDAO()
    {
        this.list=new ArrayList<MailRecord>();
    }
//Singleton
    public static SendMessageDAO getInstance()
    {
        if(instance==null)
        {instance=new SendMessageDAO();}
        return instance;
    }




    @Override
    public List<MailRecord> getAllsendMessage() {
        return null;
    }

    @Override
    public List<MailRecord> getSendMessageUser(int id_user) {
        return null;
    }

    @Override
    public boolean setAllsendMessage(List<MailRecord> list) {
        return false;
    }

    @Override
    public MailRecord saveSendMessage(MailRecord saveList_mail_record)
    {
        saveList_mail_record.setId(25);
        return saveList_mail_record;

    }
}
