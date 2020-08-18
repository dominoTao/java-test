package com.threadDemo;

/**
 * 线程的插队运行
 * join() : 使调用该方法的线程优先
 */
public class Emergency implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
            System.out.println("紧急情况："+i+"号车出发！" );
        }
    }

    public static void main(String[] args) {
        // 可以注释掉thread.join()方法 试试
        Thread thread = new Thread(new Emergency( ));
        thread.start();
        for (int i = 0; i < 6; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
            System.out.println("正常情况："+i+"号车出发！" );
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }

//        正常情况：0号车出发！
//        紧急情况：0号车出发！
//        紧急情况：1号车出发！
//        紧急情况：2号车出发！
//        紧急情况：3号车出发！
//        紧急情况：4号车出发！
//        紧急情况：5号车出发！
//        正常情况：1号车出发！
//        正常情况：2号车出发！
//        正常情况：3号车出发！
//        正常情况：4号车出发！
//        正常情况：5号车出发！
    }
}
