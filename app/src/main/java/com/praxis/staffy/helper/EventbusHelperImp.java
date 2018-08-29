package com.praxis.staffy.helper;
import org.greenrobot.eventbus.EventBus;

public class EventbusHelperImp implements EventbusInterface {

    private EventBus eventBus;

    public static class SingletonHolder
    {
        private static final EventbusHelperImp INSTANCE = new EventbusHelperImp();
    }

    public static EventbusHelperImp getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public EventbusHelperImp() {
        this.eventBus = EventBus.getDefault();
    }

    @Override
    public void register(Object subscribe) {
        this.eventBus.register(subscribe);
    }

    @Override
    public void unregister(Object subscribe) {
        this.eventBus.unregister(subscribe);
    }

    @Override
    public void post(Object event) {
        this.eventBus.post(event);
    }
}
