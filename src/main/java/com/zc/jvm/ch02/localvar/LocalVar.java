package com.zc.jvm.ch02.localvar;

/**
 * localvar1()函数中，局部变量a和b都作用到了函数末尾，故b无法复用a所在的位置。
 * 而在localvar2()函数中，局部变量a在第21行时不再有效，故局部变量b可以复用a的槽位（1个字）
 */
public class LocalVar {
    public static void main(String[] args) {
    }

    // 第0个槽位为函数的this引用（实例方法的第一个局部变量都是this引用），第1个槽位为变量a，第2个槽位为变量b，每个变量占1字，合计3字
    public void localVar1() {
        int a = 0;
        System.out.println(a);
        int b = 0;
    }

    public void localVar2() {
        {
            int a = 0;
            System.out.println(a);
        } // 超出 a 的作用域
        int b = 0;
    }
}
/*

 */