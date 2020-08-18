package com.threadDemo;

public class TestThreadDemo {
    public static void main(String[] args) throws InterruptedException{
        test();
    }
    public static void test(){
        Thread userThread = new Thread(new Worker());
        Thread daemonThread = new Thread( new Timer() );
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }

    /**
     * 查看线程运行状态
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException{
        ThreadState state = new ThreadState();
        Thread thread = new Thread( state );
        System.out.println("新建线程："+thread.getState() );
        thread.start();
        System.out.println("启动线程："+thread.getState() );
        Thread.sleep(100);
        System.out.println("计时等待："+thread.getState() );
        Thread.sleep(1000);
        System.out.println("等待线程："+thread.getState() );
        state.notifyNow();
        System.out.println("唤醒线程："+thread.getState() );
        Thread.sleep(1000);
        System.out.println("终止线程："+thread.getState() );

    }
    public static void test1(){
        StringBuilder sb = new StringBuilder(  );
        for (int i = 0; i < 5; i++) {
            new Thread(  ){
                @Override
                public void run() {
                    sb.append("《java编程词典》\n");
                }
            }.start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(  ){
                @Override
                public void run() {
                    sb.append("《视频学习java》\n");
                }
            }.start();
        }
        System.out.println(sb.toString() );
    }
}
