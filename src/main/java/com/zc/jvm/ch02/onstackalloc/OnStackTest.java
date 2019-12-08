package com.zc.jvm.ch02.onstackalloc;

/**
 * 栈上分配
 * -server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB  -XX:+EliminateAllocations
 */
public class OnStackTest {
    public static void alloc() {
        User u = new User();
        u.id = 5;
        u.name = "flyingzc";
    }

    public static void main(String[] args) throws InterruptedException {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }

    public static class User {
        public int id = 0;
        public String name = "";
    }
}
/*
1.无VM参数时：
通过 -XX:+PrintCommandLineFlags 打印虚拟机显式和隐式参数
-XX:InitialHeapSize=266187008 -XX:MaxHeapSize=4258992128 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
431

2.使用参数：
-server -Xmx10m -Xms10m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-UseTLAB  -XX:+EliminateAllocations
其中: -server参数,只有在Server模式下,才可以启用逃逸分析.
参数 -XX:+DoEscapeAnalysis 启用逃逸分析
参数 -XX:+EliminateAllocations 开启了标量替换（默认打开），允许将对象打散分配在栈上，比如对象拥有id和name两个字段，那么这两个字段将会被视为两个独立的局部变量进行分配。
参数-XX:-UseTLAB关闭了TLAB

输出:
[GC (Allocation Failure)  2047K->664K(9728K), 0.0019008 secs]
11
 */