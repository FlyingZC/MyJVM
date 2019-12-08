package com.zc.jvm.ch02.localvar;

// -XX:+PrintGC

/**
 * 每一个 localvarGcN() 都分配了一块6MB的堆空间，并使用局部变量引用这块空间。
 *
 * localvarGc1() 中，在申请空间后，立即进行垃圾回收，很明显，由于byte数组被变量a引用，因此无法回收这块空间。
 *
 * localvarGc2() 中，在垃圾回收前，先将变量a置为null，使byte数组失去强引用，故垃圾回收可以顺利回收byte数组。
 *
 * localvarGc3()，在进行垃圾回收前，先使局部变量a失效，虽然变量a已经离开了作用域，但是变量a依然存在于局部变量表中，并且也指向这块byte数组，故byte数组依然无法被回收。
 *
 * localvarGc4()，在垃圾回收之前，不仅使变量a失效，更是声明了变量c，使变量c复用了变量a的字，由于变量a此时被销毁，故垃圾回收器可以顺利回收byte数组。
 *
 * localvarGc5()，它首先调用了localvarGc1()，很明显，在localvarGc1()中并没有释放byte数组，但在localvarGc1()返回后，它的栈帧被销毁，自然也包含了栈帧中的所有局部变量，故byte数组失去引用，在localvarGc5()的垃圾回收中被回收。
 */
public class LocalVarGC {
    public static void main(String[] args) {
        LocalVarGC ins = new LocalVarGC();
        ins.localVarGc5();
    }

    public void localVarGc1() {
        byte[] a = new byte[6 * 1024 * 1024];
        System.gc();
    }

    public void localVarGc2() {
        byte[] a = new byte[6 * 1024 * 1024];
        a = null;
        System.gc();
    }

    public void localVarGc3() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGc4() {
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c = 10;
        System.gc();
    }

    public void localVarGc5() {
        localVarGc1();
        System.gc();
    }
}
/*
1 无法回收
[GC (System.gc())  8110K->6880K(62976K), 0.0053615 secs]
[Full GC (System.gc())  6880K->6776K(62976K), 0.0085888 secs]

2 可以回收
[GC (System.gc())  8110K->720K(62976K), 0.0013561 secs]
[Full GC (System.gc())  720K->630K(62976K), 0.0086591 secs]

3 无法回收
[GC (System.gc())  8110K->6880K(62976K), 0.0043245 secs]
[Full GC (System.gc())  6880K->6777K(62976K), 0.0058498 secs]

4 可以回收
[GC (System.gc())  8110K->720K(62976K), 0.0013337 secs]
[Full GC (System.gc())  720K->632K(62976K), 0.0059000 secs]

5
[GC (System.gc())  8110K->6896K(62976K), 0.0043438 secs]
[Full GC (System.gc())  6896K->6774K(62976K), 0.0199998 secs]
[GC (System.gc())  7102K->6806K(62976K), 0.0004499 secs]
[Full GC (System.gc())  6806K->630K(62976K), 0.0064189 secs]
 */