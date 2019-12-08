package com.zc.jvm.ch02.heap;

/**
 * 声明了一个 SimpleHeap 类，在 main() 方法中创建了两个 SimpleHeap 实例.
 * SimpleHeap 实例本身在堆中分配,描述 SimpleHeap 类的信息存放在方法区,main()方法中 s1 和 s2 局部变量 存放在Java栈中,并指向堆中的两个实例.
 */
public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        SimpleHeap s1 = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);
        s1.show();
        s2.show();
    }

    public void show() {
        System.out.println("My ID is " + id);
    }
}
/*
My ID is 1
My ID is 2
 */