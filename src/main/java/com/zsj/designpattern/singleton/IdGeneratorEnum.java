package com.zsj.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGeneratorEnum {
    INSTANCE(0), INSTANCE_SECOND(10);

    private AtomicLong id;

    private IdGeneratorEnum() {
    }

    private IdGeneratorEnum(long initialValue) {
        id = new AtomicLong(initialValue);
    }


    public long getId() {
        return id.incrementAndGet();
    }
}
