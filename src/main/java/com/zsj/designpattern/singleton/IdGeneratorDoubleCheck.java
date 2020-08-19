package com.zsj.designpattern.singleton;

public class IdGeneratorDoubleCheck extends AbstractIdGenerator{
    private static IdGenerator instance;

    public IdGeneratorDoubleCheck() {
    }

    public static IdGenerator getInstance(){
        if (instance == null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                if (instance == null) {
                    instance = new IdGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }
}
