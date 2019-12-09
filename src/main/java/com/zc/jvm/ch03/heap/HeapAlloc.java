package com.zc.jvm.ch03.heap;

/**
 * 最大堆、初始堆 和 系统可用内存 的含义
 * -Xmx20m -Xms5m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
 */
public class HeapAlloc {
    public static void main(String[] args) {
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() + " bytes"); // 最大可用内存,不一定等于-Xmx指定的值,因为(比如 from/to的空间的浪费 等)
        System.out.print("freeMemory=");
        System.out.println(Runtime.getRuntime().freeMemory() + " bytes"); // 当前空闲内存
        System.out.print("totalMemory=");
        System.out.println(Runtime.getRuntime().totalMemory() + " bytes"); // 当前总内存

        byte[] b = new byte[1 * 1024 * 1024]; // 使用了1MB内存空间
        System.out.println("分配了1M空间给数组");

        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
        System.out.print("freeMemory=");
        System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
        System.out.print("totalMemory=");
        System.out.println(Runtime.getRuntime().totalMemory() + " bytes");

        b = new byte[4 * 1024 * 1024];
        System.out.println("分配了4M空间给数组");

        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory() + " bytes");
        System.out.print("freeMemory=");
        System.out.println(Runtime.getRuntime().freeMemory() + " bytes");
        System.out.print("totalMemory=");
        System.out.println(Runtime.getRuntime().totalMemory() + " bytes");
    }
}