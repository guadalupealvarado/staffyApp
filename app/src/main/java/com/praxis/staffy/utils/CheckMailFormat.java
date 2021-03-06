package com.praxis.staffy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMailFormat {

    public static boolean checkMailFormat(String mail)
    {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(mail);
        return mather.find();
    }
}
