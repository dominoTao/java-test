package com.threadDemo;

import java.util.concurrent.Callable;

/**
 * 有返回值的线程接口
 */
public class Transfer implements Callable<Integer> {
    private Bank bank;

    public Transfer(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            bank.deposit3(10);
            System.out.println(bank.getAccount() );
        }
        return bank.getAccount();
    }
}
