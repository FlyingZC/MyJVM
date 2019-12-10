package com.zc.jvm.ch06.hold;

/**
 * 线程切换频繁
 * 使用 vmstat 监控,有着很高的cs值（上下文切换）和us值（用户CPU时间），表明系统的上下文切换频繁，用户CPU占用率很高。
 */
public class HoldLockMain {
    public static Object[] lock = new Object[10];

    public static java.util.Random r = new java.util.Random();

    static {
        for (int i = 0; i < lock.length; i++)
            lock[i] = new Object();
    }

    public static void main(String[] args) {
        for (int i = 0; i < lock.length * 2; i++)
            new Thread(new HoldLockTask(i / 2)).start();
    }

    public static class HoldLockTask implements Runnable {
        private int i;

        public HoldLockTask(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (lock[i]) {
                        if (i % 2 == 0)
                            lock[i].wait(r.nextInt(10));
                        else
                            lock[i].notifyAll();
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
