package com.zc.jvm.ch02.xss;

/**
 * 递归没有出口,这段代码可能会出现 StackOverflowError 错误
 * -Xss1m
 * 或
 * -Xss200K
 * 由于每次函数调用都会生成对应的栈帧,从而占用一定的栈空间.
 * 因此,如果栈空间不足,那么函数调用自然无法继续进行.
 * 当请求的栈深度大于最大可用栈深度时,系统就会抛出 StackOverflowError 栈溢出错误.
 * -Xss 来指定线程的最大栈空间,这个参数也直接决定了函数调用的最大深度.
 */
public class TestStackDeep {
    private static int count = 0;

    public static void recursion(long a, long b, long c) {
        long e = 1, f = 2, g = 3, h = 4, i = 5, k = 6, q = 7, x = 8, y = 9, z = 10;
        count++;
        recursion(a, b, c);
    }

    public static void recursion() {
        count++;
        recursion();
    }

    public static void main(String args[]) {
        try {
            // 由于局部变量表在栈帧之中，因此，如果函数的参数和局部变量较多，会使局部变量表膨胀，从而每一次函数调用就会占用更多的栈空间，最终导致函数的嵌套调用次数减少。
            // 相同栈容量下,局部变量少的函数可以支持更深的函数调用.
            // recursion(0L,0L,0L); // 1
            recursion(); // 2
        } catch (Throwable e) {
            System.out.println("deep of calling = " + count);
            e.printStackTrace();
        }
    }
}
/*
1
-Xss128K
deep of calling = 298
java.lang.StackOverflowError

-Xss256K
deep of calling = 1929
java.lang.StackOverflowError

2
-Xss128K
deep of calling = 1822
java.lang.StackOverflowError

-Xss256K
deep of calling = 3432
java.lang.StackOverflowError
第二次运行：
java.lang.StackOverflowError
deep of calling = 3779
第三次运行：
deep of calling = 3186
java.lang.StackOverflowError
 */