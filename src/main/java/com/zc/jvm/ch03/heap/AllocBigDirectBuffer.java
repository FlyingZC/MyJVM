package com.zc.jvm.ch03.heap;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MaxDirectMemorySize=10M -XX:+PrintGCDetails
 *
 * @author flyingzc
 */
public class AllocBigDirectBuffer {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, Exception {
        AllocBigDirectBuffer alloc = new AllocBigDirectBuffer();
        alloc.testDirectAllocate();
    }

    public void testDirectAllocate() {
        long starttime = System.currentTimeMillis();
        List<ByteBuffer> l = new ArrayList<ByteBuffer>();
        for (int i = 0; i < 11; i++) {
            ByteBuffer b = ByteBuffer.allocateDirect(1024 * 1024);
            l.add(b);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("testDirectAllocate:" + (endtime - starttime));
    }
}