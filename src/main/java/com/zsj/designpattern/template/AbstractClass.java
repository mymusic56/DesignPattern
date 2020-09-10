package com.zsj.designpattern.template;

public abstract class AbstractClass {
    public final void update() throws Exception {
        methord1();
        methord2();
        System.out.println("Finish");
    }

    public void methord1() throws Exception{
        throw new Exception("请重写methord1()");
    }
    public void methord2() throws Exception {
        throw new Exception("请重写methord2()");
    }
}
