package com.zsj.designpattern.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程内单例模式
 */
public class IdGeneratorThread extends AbstractIdGenerator{
    private static ConcurrentHashMap<Long, IdGeneratorThread> map = new ConcurrentHashMap<>();

    private IdGeneratorThread() {
        System.out.println("线程ID：" + Thread.currentThread().getId() + "创建对象");
    }

    public static IdGeneratorThread getInstance() {
        Long threadId = Thread.currentThread().getId();
//        map.putIfAbsent(threadId, new IdGeneratorThread());
        if (map.get(threadId) == null) {
            synchronized (IdGeneratorThread.class) {
                map.put(threadId, new IdGeneratorThread());
            }
        }
        return map.get(threadId);
    }
}
