package com.praxis.staffy.utils;

public class GeneratePasswordRecoveryCode {


    public static String generateCode()
    {
        String codigo=""+((int) (Math.random() * 9) + 0)+((int) (Math.random() * 9) + 0)+((int) (Math.random() * 9) + 0)
                +((int) (Math.random() * 9) + 0)+((int) (Math.random() * 9) + 0)+((int) (Math.random() * 9) + 0);
        return codigo;
    }
}
