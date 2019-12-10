package com.zc.jvm.ch05.t01serial;

public class T02Old {
    /**
     * 1.老年代使用 CMS
     * -XX:+UseConcMarkSweepGC：新生代使用ParNew并行收集器,老年代使用 CMS + 串行收集器.
     */
    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 30; i++) {
            b = new byte[1 * 1024 * 1024];
        }
    }
}
