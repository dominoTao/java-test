package com.commons.JVMQry;

import java.awt.*;

public class JVMDEMO implements Runnable {
    public static void main(String[] args) {
        new Thread( new JVMDEMO() ).start();
    }

    @Override
    public void run() {
        while(true) {
            System.gc();
            long freeMemory = Runtime.getRuntime( ).freeMemory( )/1024;// 获取可用内存
            long totalMemory = Runtime.getRuntime( ).totalMemory( )/1024;// 获取总内存
            System.out.println(freeMemory+"KB\t" +totalMemory+"KB" );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }

//    if(Desktop)

//    new Robot
}

