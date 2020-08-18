package com.threadDemo;

public class CounterThread implements Runnable {
    private int count = 0;
    private boolean stopped = true;

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    @Override
    public void run() {
        while (stopped) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }

    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread( );
        Thread thread = new Thread(counterThread);

        thread.start( );
    }
}