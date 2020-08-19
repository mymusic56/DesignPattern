package com.zsj.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

abstract class AbstractIdGenerator implements IdGenerator {
    private AtomicLong id = new AtomicLong(0);

    @Override
    public long getId() {
        return id.incrementAndGet();
    }
}
