package com.zc.jvm.ch06.hold;

/**
 * HoldCPUTask 线程死循环,跑满cpu
 * LazyTask 空闲线程
 */
public class HoldCPUMain {
    public static void main(String[] args) {
        new Thread(new HoldCPUTask()).start();
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
        new Thread(new LazyTask()).start();
    }

    public static class HoldCPUTask implements Runnable {
        @Override
        public void run() {
            while (true) { // 死循环,占用cpu
                double a = Math.random() * Math.random();
            }
        }
    }

    public static class LazyTask implements Runnable {
        public void run() {
            try {
                while (true) { // 空闲线程
                    Thread.sleep(1000);
                }
            } catch (Exception e) {

            }
        }
    }
}