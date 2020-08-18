package com.threadDemo;

/**
 * 守护线程
 * 唯一用途就是：为其他线程服务
 * 守护线程随时可以中断，不要再守护线程上使用需要释放资源的资源
 * 如：io流，数据库连接等
 * 守护线程是后台线程，当虚拟机中只剩下守护线程的时候，虚拟机就会自动退出
 */
public class Timer implements Runnable {
    @Override
    public void run() {
        long l = System.currentTimeMillis( );
        long processTime = 0;
        while (true) {
            if((System.currentTimeMillis() - l) > processTime) {
                processTime = System.currentTimeMillis() - l;
                System.out.println("程序运行时间：" + processTime +"毫秒");
            }
        }
    }
}
