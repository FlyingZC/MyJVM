package com.zc.jvm.ch05.t01serial;

/**
 * -XX:+UseG1GC :
 * -XX:+UseG1GC -Xmx20m -Xms20m -Xmn7m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * [Eden: 7168.0K(7168.0K)->0.0B(5120.0K) Survivors: 0.0B->2048.0K Heap: 10.9M(20.0M)->5554.5K(20.0M)]
 */
public class T03G1 {
    public static void main(String[] args) {
        int size = 30;
        // 一直持有 30 个 byte[] 数组的引用,回收不掉
        byte[][] bytes = new byte[size][];
        for (int i = 0; i < size; i++) {
            bytes[i] = new byte[1 * 1024 * 1024];
        }
    }
}

