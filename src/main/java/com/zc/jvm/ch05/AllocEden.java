package com.zc.jvm.ch05;

/**
 * 初创的对象在 eden 区
 * -Xmx64M -Xms64M -XX:+PrintGCDetails
 *
 * @author flyingzc
 */
public class AllocEden {
    public static final int _1K = 1024;

    public static void main(String args[]) {
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b = new byte[_1K];
        }
        // 1.不调用 gc 的话,此时只会使用eden的空间
        // System.gc();
    }
}