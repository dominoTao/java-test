package com.threadDemo;

public class DeadLock implements Runnable {

    private boolean flag;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    @Override
    public void run() {

    }
}
