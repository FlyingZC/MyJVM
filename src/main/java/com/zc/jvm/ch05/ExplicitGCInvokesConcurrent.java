package com.zc.jvm.ch05;

/**
 * -XX:+PrintGCDetails -XX:+ExplicitGCInvokesConcurrent -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails -XX:+ExplicitGCInvokesConcurrent -XX:+UseG1GC
 * <p>
 * ExplicitGCInvokesConcurrent 在System.gc()时会使用并发方式 回收
 *
 * @author flyingzc
 */
public class ExplicitGCInvokesConcurrent {
    public static void main(String args[]) {
        while (true) {
            System.gc();
            Thread.yield();
        }
    }
}
