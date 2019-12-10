package com.zc.jvm.ch05;

import java.util.HashMap;
import java.util.Map;

/**
 * 新生代对象最大的晋升年龄
 * -Xmx1024M -Xms1024M -XX:+PrintGCDetails -XX:MaxTenuringThreshold=15 -XX:+PrintHeapAtGC
 * -XX:+PrintHeapAtGC 每次 gc 都打印堆的信息
 * @author flyingzc
 */
public class ComputeTenuringThreshold {
    public static final int _1M = 1024 * 1024;
    public static final int _1K = 1024;

    public static void main(String args[]) {
        Map<Integer, byte[]> map = new HashMap<Integer, byte[]>();
        // 申请 5MB 空间,放入 map 引用一直持有,不会被回收
        for (int i = 0; i < 5 * _1K; i++) {
            byte[] b = new byte[_1K];
            map.put(i, b);
        }

        // 疯狂创建新对象,触发新生代 GC,下面的每次gc都会被回收掉
        for (int k = 0; k < 17; k++) {
            for (int i = 0; i < 270; i++) {
                byte[] g = new byte[_1M];
            }
        }
    }
}
