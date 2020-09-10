package com.zsj.designpattern.observer;

import com.zsj.designpattern.observer.event.MsgEvent;
import org.greenrobot.eventbus.Subscribe;

public class EmailObserver {

    @Subscribe
    public void sendMsg(MsgEvent event) {
        System.out.println("EmailObserver 获取消息：" + event.getMsg());
    }
}
