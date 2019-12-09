package com.zc.jvm.ch03.heap;

import java.nio.ByteBuffer;

/**
 * -server 模式下 差异明显
 */
public class AccessDirectBuffer {
    public static void main(String[] args) {
        AccessDirectBuffer alloc = new AccessDirectBuffer();
        alloc.bufferAccess();
        alloc.directAccess();

        alloc.bufferAccess();
        alloc.directAccess();
    }

    /**
     * 直接内存读写
     */
    public void directAccess() {
        long startTime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocateDirect(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testDirectWrite:" + (endTime - startTime));
    }

    /**
     * 堆内存读写
     */
    public void bufferAccess() {
        long startTime = System.currentTimeMillis();
        ByteBuffer b = ByteBuffer.allocate(500);
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < 99; j++) {
                b.putInt(j);
            }
            b.flip();
            for (int j = 0; j < 99; j++) {
                b.getInt();
            }
            b.clear();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("testBufferWrite:" + (endTime - startTime));
    }
}
/*
-server模式下:
testBufferWrite:27
testDirectWrite:19
testBufferWrite:15
testDirectWrite:11
* */