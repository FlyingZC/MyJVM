package com.zc.jvm.ch04.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 每一个 软引用 都可以附带一个引用队列，当对象的可达性发生改变时（由可达变为不可达），软引用对象就会进入引用队列。通过这个引用队列，可以跟踪对象的回收情况。
 * -Xmx10m
 */
public class SoftRefQ {
    static ReferenceQueue<User> softQueue = null;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        User u = new User(1, "flyingzc");
        softQueue = new ReferenceQueue<User>(); // 1.创建 软引用队列
        UserSoftReference userSoftRef = new UserSoftReference(u, softQueue); // 2.通过 软引用队列 参数 创建 软引用对象 // 3.当软引用对象被回收时会被添加到 ReferenceQueue 中 ,通过这个 ReferenceQueue 队列,就可以追踪到被回收的 UserSoftReference 实例.
        u = null;
        System.out.println(userSoftRef.get());
        System.gc();

        // 内存足够，不会被回收
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());

        System.out.println("try to create byte array and GC");
        List<byte[]> list = new ArrayList<>();
        while (true) {
            byte[] b = new byte[1024];
            list.add(b);
            if (userSoftRef.get() == null) {
                System.out.println("可用内存为: " + Runtime.getRuntime().freeMemory() + " byte, SoftReference 被回收");
            }
        }
    }

    public static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "[id=" + String.valueOf(id) + ",name=" + name + "]";
        }
    }

    public static class CheckRefQueue extends Thread {
        @Override
        public void run() {
            while (true) {
                if (softQueue != null) {
                    UserSoftReference obj = null;
                    try {
                        // 3.当软引用对象被回收时会被添加到 ReferenceQueue 中 ,通过这个 ReferenceQueue 队列,就可以追踪到被回收的 UserSoftReference 实例.
                        obj = (UserSoftReference) softQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (obj != null)
                        System.out.println("user id " + obj.uid + " is delete"); // 4.通过 uid 判断具体哪个对象被回收了
                }
            }
        }
    }

    public static class UserSoftReference extends SoftReference<User> {
        int uid;

        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid = referent.id;
        }
    }
}