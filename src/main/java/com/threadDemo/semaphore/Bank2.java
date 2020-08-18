package com.threadDemo.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 线程同步：信号量
 */
public class Bank2 {
    private int account = 100;
    public void deposit(int money) {
        account += money;
    }
    public int getAccount(){
        return account;
    }
    private class Transfer implements Runnable {
        private Bank2 bank2;
        /**
         * 信号量
         */
        private Semaphore semaphore;

        public Transfer(Bank2 bank2, Semaphore semaphore) {
            this.bank2 = bank2;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    semaphore.acquire();// 从信号量获取一个许可
                    bank2.deposit(10);
                    System.out.println(bank2.getAccount() );
                    semaphore.release();// 释放许可到信号量
                } catch (InterruptedException e) {
                    e.printStackTrace( );
                }
            }
        }
    }
}
