package com.threadDemo.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  线程池 优化 多线程编程
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime(); // 创建runtime对象
        runtime.gc( );
        long freeMemory = runtime.freeMemory( ); // 获取虚拟机当前空闲内存
        long currentTime = System.currentTimeMillis( );  // 获取虚拟机当前时间
        for (int i = 0; i < 1000; i++) {
            new Thread( new TempThread() ).start();
        }
        System.out.println("独立运行1000个线程占用的内存："+(freeMemory - runtime.freeMemory( ))+"字节" );
        System.out.println("独立运行1000个线程消耗的时间："+(System.currentTimeMillis() - currentTime)+"字节" );
        runtime.gc( );
        freeMemory = runtime.freeMemory( );
        currentTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(2);// 创建线程池
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new TempThread());
        }
        System.out.println("独立运行1000个线程占用的内存："+(freeMemory - runtime.freeMemory( ))+"字节" );
        System.out.println("独立运行1000个线程消耗的时间："+(System.currentTimeMillis() - currentTime)+"字节" );
//        独立运行1000个线程占用的内存：733624字节
//        独立运行1000个线程消耗的时间：88字节
//        独立运行1000个线程占用的内存：209840字节
//        独立运行1000个线程消耗的时间：5字节
    }
}
