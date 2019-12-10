package com.zc.jvm.ch05.t01serial;

import org.junit.Test;

/**
 * 1.新生代 和 老年代 使用 串行收集器
 * -XX:+UseSerialGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * eden:512  from:256   to:256, eden + from = 768k
 *
 * -XX:+UseSerialGC -Xmx20m -Xms20m -Xmn7m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * -XX:+UseSerialGC -Xmx20m -Xms20m -Xmn15m  -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -XX:+UseSerialGC -Xmx20M -Xms20M -XX:NewRatio=2  -XX:+PrintGCDetails
 *
 * 2.ParNew 新生代并行收集器
 * -XX:+UseParNewGC : 在新生代使用ParNew并行收集器,老年代使用串行回收期.
 * -XX:+UseConcMarkSweepGC：新生代使用ParNew并行收集器,老年代使用 CMS + 串行收集器.
 *
 * -XX:+UseParNewGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 *
 * -XX:+UseConcMarkSweepGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 *
 * 3.Parallel 新生代并行收集器
 * -XX:+UseParallelGC : 新生代使用 Parallel 回收器，老年代使用串行回收器
 * -XX:+UseParallelOldGC : 新生代使用 Parallel 回收器，老年代使用 ParallelOldGC 回收器
 *
 * -XX:+UseParallelGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * PSYoungGen ParOldGen
 *
 * -XX:+UseParallelOldGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * PSYoungGen ParOldGen
 *
 * @author flyingzc
 */
public class TestSerial {
    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 30; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }

    @Test
    public void test01() {
        int size = 30;
        // 一直持有 30 个 byte[] 数组的引用,回收不掉
        byte[][] bytes = new byte[size][];
        for (int i = 0; i < size; i++) {
            bytes[i] = new byte[1 * 1024 * 1024];
        }
    }

    @Test
    public void test02() {
        int size = 15;
        // 一直持有 30 个 byte[] 数组的引用,回收不掉
        byte[][] bytes = new byte[size][];
        for (int i = 0; i < size; i++) {
            bytes[i] = new byte[1 * 1024 * 1024];
        }
        System.gc();

        size = 30;
        // 一直持有 30 个 byte[] 数组的引用,回收不掉
        bytes = new byte[size][];
        for (int i = 0; i < size; i++) {
            bytes[i] = new byte[1 * 1024 * 1024];
        }
    }
}