package com.zsj.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorEager extends AbstractIdGenerator {

    private static final IdGenerator instance = new IdGeneratorEager();

    private IdGeneratorEager() {
    }

    public static IdGenerator getInstance() {
        return instance;
    }
}
