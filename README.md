# 包结构
com.zc.jvm: 实战JVM的demo

# 实战JVM的demo
## ch01

## ch02
SimpleArgs: 指定虚拟机启动参数 vm arguments

SimpleHeap: Java堆

TestStackDeep: 栈抛 StackOverflowError

LocalVar: 局部变量表槽位的复用

LocalVarGC: 局部变量作为GC Roots,查看其引用的对象能否被回收

OnStackTest: 栈上分配

PermTest: 永久代

## ch03
UnloadClass: 跟踪类的加载/卸载

HeapAlloc: 堆分配

`NewSizeDemo`: 新生代,模拟GC

`DumpOOM`: 堆OOM

AccessDirectBuffer: 统计 直接内存 和 堆内存 的读写速度

AllocDirectBuffer: 直接内存分配较慢

## ch04
CanReliveObj: 对象在 finalize() 中复活自己

SoftRef: 软引用

SoftRefQ: ReferenceQueue 的使用

WeakRef: 弱引用

WeakRefQ: ReferenceQueue 的使用

TraceCanReliveObj: 虚引用

StopWorldTest: stop-the-world