package com.zsj.designpattern.observer.event;

import lombok.Getter;

@Getter
public class MsgEvent {
    String msg = "";
    public MsgEvent(String msg) {
        this.msg = msg;
    }
}
