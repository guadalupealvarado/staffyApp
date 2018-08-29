package com.praxis.staffy.model.DAO.sendMessage;

import com.praxis.staffy.model.pojo.MailRecord;
import java.util.List;

public interface sendMessageInterfaz
{
    List<MailRecord> getAllsendMessage();
    List<MailRecord> getSendMessageUser(int id_user);
    boolean setAllsendMessage(List<MailRecord> list);
    MailRecord saveSendMessage(MailRecord saveList_mail_record);
}
