package com.zc.jvm.ch03.heap;

import java.nio.ByteBuffer;

/**
 * 直接内存分配较慢,数值大些比较明显
 */
public class AllocDirectBuffer {
    // 1000, 200000
    private int capacity = 1000;

    private int loopCount = 20000;

    public static void main(String[] args) {
        AllocDirectBuffer alloc = new AllocDirectBuffer();
        alloc.bufferAllocate();
        alloc.directAllocate();

        alloc.bufferAllocate();
        alloc.directAllocate();
    }

    public void directAllocate() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopCount; i++) {
            ByteBuffer b = ByteBuffer.allocateDirect(capacity);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("directAllocate:" + (endTime - startTime));
    }

    public void bufferAllocate() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < loopCount; i++) {
            ByteBuffer b = ByteBuffer.allocate(capacity);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("bufferAllocate:" + (endTime - startTime));
    }
}