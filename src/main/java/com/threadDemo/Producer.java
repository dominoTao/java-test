package com.threadDemo;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 */
public class Producer implements Runnable {
    LinkedBlockingQueue queue = new LinkedBlockingQueue(  );

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            int b = new Random().nextInt(255);
            try {
                queue.put(b);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }
}
