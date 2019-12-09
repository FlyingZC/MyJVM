package com.zc.jvm.ch03.heap.newsize;

/**
 * -Xmx20m -Xms20m -XX:NewRatio=1 -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 *
 * @author flyingzc
 */
public class NewSizeRatio {

    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++)
            b = new byte[1 * 1024 * 1024];
    }
}