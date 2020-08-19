package com.zsj.designpattern.singleton;

public class IdGeneratorInnerStaticClass extends AbstractIdGenerator{
    private IdGeneratorInnerStaticClass(){}

    public static class IdGeneratorInnerClass{
        private static final IdGenerator instance = new IdGeneratorInnerStaticClass();
    }

    public static IdGenerator getInstance(){
        return IdGeneratorInnerClass.instance;
    }
}
