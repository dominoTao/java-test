package com.threadDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 查看JVM中的线程名
 */
public class ThreadList {

    public static void main(String[] args) {
        for (String string:
             getThreadGroups(getRootThreadGroups())) {
            System.out.println(string );
        }
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[rootGroup.activeCount( )];
        rootGroup.enumerate(threads);
        for (Thread e:
             threads) {
            // 获取线程优先级等信息
            System.out.println(e.getId()+"\t"+e.getName()+"\t"+e.getPriority() );
        }
    }
    // 获取根线程组
    private static ThreadGroup getRootThreadGroups(){
        // 获取当前线程组
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        while (true) {
            if(rootGroup.getParent()!=null) {
                rootGroup = rootGroup.getParent();
            } else {
                break;
            }
        }
        return rootGroup;
    }

    /**
     * 获得给定线程组中所有线程名
     * @param group
     * @return
     */
    public static List<String> getThreads(ThreadGroup group) {
        List<String> threadList = new ArrayList<>(  );
        Thread[] threads = new Thread[group.activeCount( )];
        int enumerate = group.enumerate(threads, false);
        for (int i = 0; i < enumerate; i++) {
            threadList.add(group.getName()+"线程组："+threads[i].getName());
        }
        return threadList;
    }

    /**
     * 获得线程组中子线程组
     * @param group
     * @return
     */
    public static List<String> getThreadGroups(ThreadGroup group) {
        List<String> threadList = getThreads(group);
        ThreadGroup[] groups = new ThreadGroup[group.activeGroupCount( )];
        int count = group.enumerate(groups, false);
        for (int i = 0; i < count; i++) {
            threadList.addAll(getThreads(groups[i]));
        }
        return threadList;
    }
}
