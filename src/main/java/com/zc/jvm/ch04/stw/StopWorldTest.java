package com.zc.jvm.ch04.stw;

import java.util.HashMap;

/**
 * -Xmx1g -Xms1g -Xmn2m -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails
 * 开启了两个线程，
 * PrintThread(模拟用户线程,当fullgc时,打印会短暂停止)负责每0.1秒在控制台上进行一次时间戳的输出，
 * MyThread则不停地消耗内存资源，以引起GC。
 * 在内存消耗大于900MB时，清空内存，防止内存溢出。
 */
public class StopWorldTest {
    public static void main(String args[]) {
        MyThread t = new MyThread();
        PrintThread p = new PrintThread();
        t.start();
        p.start();
    }

    public static class MyThread extends Thread {
        HashMap map = new HashMap();

        @Override
        public void run() {
            try {
                while (true) {
                    if (map.size() * 512 / 1024 / 1024 >= 900) {
                        map.clear();
                        System.out.println("clean map");
                    }
                    byte[] b1;
                    for (int i = 0; i < 100; i++) {
                        b1 = new byte[512];
                        map.put(System.nanoTime(), b1);
                    }
                    Thread.sleep(1);
                }
            } catch (Exception e) {

            }
        }
    }

    public static class PrintThread extends Thread {
        public static final long starttime = System.currentTimeMillis();

        @Override
        public void run() {
            try {
                while (true) {
                    long t = System.currentTimeMillis() - starttime;
                    System.out.println(t / 1000 + "." + t % 1000);
                    Thread.sleep(100);
                }
            } catch (Exception e) {

            }
        }
    }
}