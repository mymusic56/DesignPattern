package com.zsj.designpattern.observer;

import com.zsj.designpattern.observer.event.IntegrationEvent;
import org.greenrobot.eventbus.Subscribe;

/**
 * 积分处理
 */
public class IntegrationObserver {
    @Subscribe
    public void test(IntegrationEvent event) {
        System.out.println("IntegrationEvent 获取消息：" + event.getMsg());
    }
}
