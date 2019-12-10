package com.zc.jvm.ch05;

/**
 * 测试使用TLAB后对象分配的速度
 * 打开了TLAB (默认开启),并启用了对所有函数的JIT以及禁止后台编译(这里只是希望在相对一致的环境中测试) ,同时禁用了逃逸分析,以防止栈上分配的行为影响本次测试结果,开启Server 模式是因为在Client模式下,不支持逃逸分析参数DoEscapeAnalysis
 *
 * -XX:-UseTLAB  -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server
 * <p>
 * -XX:+UseTLAB  -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis -server
 * <p>
 * 测试日志
 * -XX:+UseTLAB  -XX:+PrintTLAB -XX:+PrintGC -XX:TLABSize=307200 -XX:-ResizeTLAB
 * <p>
 * 使用 XX:TLABRefillWasteFraction 改变refill waste
 * -XX:+UseTLAB  -XX:+PrintTLAB -XX:+PrintGC -XX:TLABSize=102400 -XX:-ResizeTLAB -XX:TLABRefillWasteFraction=100 -XX:-DoEscapeAnalysis -server
 *
 * @author flyingzc
 */
public class UseTLAB {
    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;

    }

    public static void main(String args[]) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}