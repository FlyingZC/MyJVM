package com.zc.jvm.ch05;

/**
 * 并行
 * 在使用并行回收器时，触发Full GC之前，进行了一次新生代GC。
 * -XX:+PrintGCDetails  -XX:-ScavengeBeforeFullGC -XX:+UseParallelOldGC
 *
 * 串行
 * 只会触发一次fullgc
 * -XX:+PrintGCDetails -XX:+UseSerialGC
 *
 * @author flyingzc
 */
public class ScavengeBeforeFullGC {
    public static void main(String args[]) {
        System.gc();
    }
}