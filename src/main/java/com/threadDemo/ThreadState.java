package com.threadDemo;

public class ThreadState implements Runnable {
    public synchronized void waitForASecond() throws InterruptedException{
        wait(500);
    }
    public synchronized void waitForYears() throws InterruptedException{
        wait();
    }
    public synchronized void notifyNow() throws InterruptedException{
        notify();
    }
    @Override
    public void run() {
        try {
            waitForASecond();
            waitForYears();
        } catch (InterruptedException e) {
            e.printStackTrace( );
        }
    }
}
