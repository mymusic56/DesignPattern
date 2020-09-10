package com.zsj.designpattern.observer;

import com.zsj.designpattern.observer.event.MsgEvent;
import org.greenrobot.eventbus.Subscribe;

public class SmsObserver {

    @Subscribe
    public void sendMsg(MsgEvent event) {
        System.out.println("SmsObserver 获取消息：" + event.getMsg());
    }
}
