package com.praxis.staffy.utils;

import java.util.ArrayList;

public class MonthConverterToString
{
    private MonthConverterToString() {
        fillInMonth();
    }

    private static MonthConverterToString instance;

    private ArrayList<String> listMonth=new ArrayList<>();

    private void fillInMonth()
    {
        listMonth.add("en.");
        listMonth.add("ferb.");
        listMonth.add("mzo.");
        listMonth.add("abr.");
        listMonth.add("my.");
        listMonth.add("jun.");
        listMonth.add("jul.");
        listMonth.add("agto.");
        listMonth.add("sept.");
        listMonth.add("oct.");
        listMonth.add("nov.");
        listMonth.add("dic.");
    }

    public static MonthConverterToString getInstance() {
        if(instance==null)
        {
            instance=new MonthConverterToString();

        }
        return instance;
    }

    public String getMonth(int index)
    {
        return listMonth.get(index-1);
    }


}
