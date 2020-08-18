package com.threadDemo.pool;

public class TempThread implements Runnable {

    private int id = 0;
    @Override
    public void run() {
        id++;
    }
}
