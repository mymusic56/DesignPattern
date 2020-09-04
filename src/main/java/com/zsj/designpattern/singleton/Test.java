package com.zsj.designpattern.singleton;

public class Test {
    public static void main(String[] args) {
        IdGenerator idGeneratorEager = IdGeneratorEager.getInstance();
        long id = idGeneratorEager.getId();
        id = idGeneratorEager.getId();
        System.out.println("id = " + id);

        IdGenerator idGeneratorLazy = IdGeneratorLazy.getInstance();
        long idLazy = idGeneratorLazy.getId();
        System.out.println("idLazy = " + idLazy);

        IdGenerator idGeneratorDoubleCheck = IdGeneratorDoubleCheck.getInstance();
        id = idGeneratorDoubleCheck.getId();
        id = idGeneratorDoubleCheck.getId();
        id = idGeneratorDoubleCheck.getId();
        id = idGeneratorDoubleCheck.getId();
        System.out.println("id = " + id);

        IdGenerator idGeneratorStaticClass = IdGeneratorInnerStaticClass.getInstance();
        id = idGeneratorStaticClass.getId();
        id = idGeneratorStaticClass.getId();
        id = idGeneratorStaticClass.getId();
        id = idGeneratorStaticClass.getId();
        id = idGeneratorStaticClass.getId();
        System.out.println("id = " + id);

        long val, val2;
        val = IdGeneratorEnum.INSTANCE.getId();
        val = IdGeneratorEnum.INSTANCE.getId();
        val2 = IdGeneratorEnum.INSTANCE_SECOND.getId();

        System.out.println("val = " + val);
        System.out.println("val2 = " + val2);

        threadSingletonTest();
    }

    /**
     * 线程内单例模式
     */
    private static void threadSingletonTest(){
        System.out.println("====================线程内单例模式====================");
        new Thread() {
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程ID：" + threadId);
                long id;

                for (int i = 1; i <= 3; i++) {
                    id = IdGeneratorThread.getInstance().getId();
                    System.out.println("线程ID：" + threadId + ", i = " + i);
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                long threadId = Thread.currentThread().getId();
                System.out.println("线程ID：" + threadId);
                long id;

                for (int i = 1; i <= 3; i++) {
                    id = IdGeneratorThread.getInstance().getId();
                    System.out.println("线程ID：" + threadId + ", i = " + i);
                }
            }
        }).start();
    }
}
