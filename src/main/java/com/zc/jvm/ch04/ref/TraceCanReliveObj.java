package com.zc.jvm.ch04.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用
 * @author flyingzc
 */
public class TraceCanReliveObj {
    public static TraceCanReliveObj obj;
    // 引用队列
    static ReferenceQueue<TraceCanReliveObj> phantomQueue = null;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        phantomQueue = new ReferenceQueue<TraceCanReliveObj>();
        obj = new TraceCanReliveObj();
        // 虚引用
        PhantomReference<TraceCanReliveObj> phantomRef = new PhantomReference<TraceCanReliveObj>(obj, phantomQueue);

        obj = null; // 解除强引用
        System.gc(); // gc
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
        System.out.println("第二次gc");
        obj = null; // 解除 强引用
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this; // 重新建立 强引用
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }

    public static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            while (true) {
                if (phantomQueue != null) {
                    PhantomReference<TraceCanReliveObj> objt = null;
                    try {
                        objt = (PhantomReference<TraceCanReliveObj>) phantomQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (objt != null) {
                        System.out.println("TraceCanReliveObj is delete by GC");
                    }
                }
            }
        }
    }
}