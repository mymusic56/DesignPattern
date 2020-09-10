package com.zsj.designpattern.template;

public class Test {
    public static void main(String[] args) throws Exception {
        ChildClass1 childClass1 = new ChildClass1();
        ChildClass2 childClass2 = new ChildClass2();
        childClass1.update();
        childClass2.update();
    }
}
