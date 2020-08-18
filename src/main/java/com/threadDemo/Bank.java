package com.threadDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程同步
 *  1 同步方法
 *  2 同步代码块
 *  3 特殊域变量
 *  4 可重入锁
 *  5 线程局部变量：使用ThreadLocal管理变量，则每个使用变量的线程都会获得一份该变量的副本。副本之间相互独立，每个线程可以所以改动自己的变量副本，而对其他线程没有影响。
 *  6 阻塞队列
 *  7 信号量
 *  8 原子变量
 */
public class Bank {
    private ReentrantLock lock = new ReentrantLock(  );
    private volatile int account = 100;
    public void deposit(int money) {
        synchronized (this) {
            account += money;
        }
    }
    public synchronized void deposit1(int money) {
        account += money;
    }
    public void deposit2(int money) {
        lock.lock();
        try {
            account += money;
        }finally {
            lock.unlock();
        }
    }

    private static ThreadLocal<Integer> account1 = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };
    public void deposit3(int money) {
        account1.set(account1.get()+money);
    }
}
