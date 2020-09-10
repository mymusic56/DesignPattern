package com.zsj.designpattern.observer.event;

import lombok.Getter;

@Getter
public class IntegrationEvent {
    String msg = "";
    public IntegrationEvent(String msg) {
        this.msg = msg;
    }
}
