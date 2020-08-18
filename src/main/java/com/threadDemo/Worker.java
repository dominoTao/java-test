package com.threadDemo;

public class Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("java编程词典第"+i+"次更新" );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }
}
