package com.zc.jvm.ch04.ref;

import java.lang.ref.WeakReference;

/**
 * 在GC时，只要发现弱引用，不管堆空间使用情况如何，都会将WeakReference对象进行回收
 */
public class WeakRef {
    public static void main(String[] args) {
        User u = new User(1, "flyingzc");
        WeakReference<User> userWeakRef = new WeakReference<User>(u);
        u = null;
        System.out.println(userWeakRef.get());
        System.gc();
        // 不管当前内存空间足够与否，都会回收它的内存
        System.out.println("After GC:");
        System.out.println(userWeakRef.get());
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