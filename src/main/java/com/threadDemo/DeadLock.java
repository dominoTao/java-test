package com.threadDemo;

/**
 * 死锁示例
 *
 * 去掉任何一个同步块  就可以解决死锁
 */
public class DeadLock implements Runnable {

    private boolean flag;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    @Override
    public void run() {
        String name = Thread.currentThread( ).getName( );
        System.out.println(name + ":flag = " + flag );
        if(flag) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace( );
                }
                System.out.println(name + "进入o1 准备进入o2");
                synchronized(o2) {
                    System.out.println(name + "进入o2" );
                }
            }
        }
        if(!flag) {
            synchronized (o2) {
                try {
                    Thread.sleep(1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace( );
                }
                System.out.println(name + "进入o2，准备进入o1" );
                synchronized (o1) {
                    System.out.println(name + "进入o1" );
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        DeadLock d2 = new DeadLock();
        d1.flag = true;
        d2.flag = false;
        new Thread(d1).start();
        new Thread( d2 ).start();
    }
}
