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

## ch05
`T01Serial`: 各种gc算法的组合

CMSTest: CMS

PermTest: 使用CMS回收Perm

G1Test: G1

AllocEden: 初创的对象在 eden 区

MaxTenuringThreshold: 新生代对象最大的晋升年龄

PretenureSizeThreshold: 超过给定大小的对象直接晋升到老年代

UseTLAB: 使用 TLAB

LongFinalize: finalize()对gc的影响

## ch06 性能检测工具
top 显示整体资源使用情况

vmstat 监视内存和CPU
HoldLockMain: 上下文频繁切换

iostat 监视IO使用

pidstat 多功能诊断器
HoldCPUMain: 死循环线程 和 空闲线程
HoldIOMain: 大量IO操作的线程
HoldMemoryMain: 占用大量内存的线程

### JDK性能监控工具
jps 查看Java进程

jstat 查看JVM运行时信息

jinfo 查看JVM参数

jmap 导出堆Heap到文件

jhat JDK自带的堆Heap分析工具

jstack 查看线程堆栈Stack
DeadLock: 死锁

jstatd 远程主机参数收集

jcmd 多功能命令行

hprof 性能统计工具

JConsole 图形化JVM监控工具

Visual VM 可视化性能监控工具 （可装BTrace插件）
Brace使用: HoldNetMain

Mission Control JRockit虚拟机诊断工具 jmc.exe

## ch07 分析JAVA堆
MAT
Visual VM

SimpleHeapOOM: 堆OOM
DirectBufferOOM: 直接内存OOM
MultiThreadOOM: 创建线程过多导致的OOM
PermOOM: 永久代OOM