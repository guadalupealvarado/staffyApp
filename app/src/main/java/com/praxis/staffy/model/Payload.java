package com.praxis.staffy.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Carga utli
 * Model de los datos.
 */

public class Payload {
    private User user;
    private String deviceId;
    private String sessionId;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
