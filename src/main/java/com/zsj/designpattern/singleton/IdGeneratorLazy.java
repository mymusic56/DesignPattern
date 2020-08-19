package com.zsj.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorLazy extends AbstractIdGenerator {
    private static IdGenerator instance = null;

    private IdGeneratorLazy() {
    }

    public static synchronized IdGenerator getInstance() {
        if (instance == null) {
            instance = new IdGeneratorLazy();
        }
        return instance;
    }
}
