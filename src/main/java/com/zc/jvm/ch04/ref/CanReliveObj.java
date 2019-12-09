package com.zc.jvm.ch04.ref;

/**
 * 对象有可能在 finalize() 中使自己复活
 */
public class CanReliveObj {
    public static CanReliveObj obj;

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        obj = null;
        System.out.println("第一次gc");
        System.gc();
        Thread.sleep(1000);
        if (obj == null) {
            System.out.println("obj 是 null");
        } else {
            System.out.println("obj 可用");
        }
        System.out.println("第二次gc");
        obj = null;
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
        System.out.println("finalize()方法被调用: CanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am CanReliveObj";
    }
}