package com.zc.jvm.ch04.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用
 * 如果一个对象只持有软引用，那么当堆空间不足时，就会被回收
 * -Xmx10m
 * After gc, soft ref is exists
 * after create byte array ,soft ref is gc
 */
public class SoftRef {
    public static void main(String[] args) {
        User u = new User(1, "flyingzc"); // 强引用
        // 软引用
        SoftReference<User> userSoftRef = new SoftReference<User>(u);
        u = null; // 去除强引用

        System.out.println(userSoftRef.get());
        System.gc();
        System.out.println("After GC:");
        System.out.println(userSoftRef.get());

        System.out.println("创建大数组");

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
}