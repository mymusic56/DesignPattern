package com.zsj.designpattern.observer;

import com.zsj.designpattern.observer.event.MsgEvent;
import com.zsj.designpattern.observer.event.IntegrationEvent;
import org.greenrobot.eventbus.EventBus;

public class Test {
    public static void main(String[] args) {
        //创建观察者
        SmsObserver smsObserver = new SmsObserver();
        EmailObserver emailObserver = new EmailObserver();
        IntegrationObserver integrationObserver = new IntegrationObserver();

        //注册观察者
        EventBus eventBus = new EventBus();
        eventBus.register(smsObserver);
        eventBus.register(emailObserver);
        eventBus.register(integrationObserver);

        MsgEvent emailEvent = new MsgEvent("周末愉快！");
        IntegrationEvent integrationEvent = new IntegrationEvent("周末有零花钱了！");


        eventBus.post(emailEvent);
        eventBus.post(integrationEvent);
    }
}
