package com.praxis.staffy.utils;

public class ManagementUrlWebServices {

    private  static String url_web_services="http://192.168.45.126" +
            ":3000/";

    public static String getUrl_web_services() {
        return url_web_services;
    }

    public static void setUrl_web_services(String url_web_services) {
        ManagementUrlWebServices.url_web_services = url_web_services;
    }
}
