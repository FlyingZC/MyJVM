package com.zc.jvm.ch05;

/**
 * -XX:+PrintGCDetails -XX:-DisableExplicitGC
 *
 * @author flyingzc
 */
public class DisableExplictGC {
    public static void main(String args[]) {
        while (true) {
            System.gc();
            Thread.yield();
        }
    }
}
