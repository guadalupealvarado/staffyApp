package com.praxis.staffy.helper;

public interface EventbusInterface {
    void register(Object subscribe);
    void unregister(Object subscribe);
    void post(Object event);
}
