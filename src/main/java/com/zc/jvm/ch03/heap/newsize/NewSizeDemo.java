package com.zc.jvm.ch03.heap.newsize;

/**
 * vm options:
 * -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * -Xmx20m -Xms20m -Xmn7m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * -Xmx20m -Xms20m -Xmn15m  -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -Xmx20M -Xms20M -XX:NewRatio=2  -XX:+PrintGCDetails
 * 其中: -XX:SurvivorRatio = eden/from = eden/to
 */
public class NewSizeDemo {
    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++) { // 共申请10次,共10MB内存
            b = new byte[1 * 1024 * 1024]; // 每次申请 1MB
        }
    }
}
/*
1.-Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
[GC (Allocation Failure) [PSYoungGen: 512K->488K(1024K)] 512K->504K(19968K), 0.0006319 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 1000K->480K(1024K)] 1016K->648K(19968K), 0.0054702 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
[GC (Allocation Failure) [PSYoungGen: 992K->504K(1024K)] 1160K->680K(19968K), 0.0005278 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 PSYoungGen      total 1024K, used 922K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
  eden space 512K, 81% used [0x00000000ffe80000,0x00000000ffee8bc8,0x00000000fff00000)
  from space 512K, 98% used [0x00000000fff00000,0x00000000fff7e010,0x00000000fff80000)
  to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 ParOldGen       total 18944K, used 10416K [0x00000000fec00000, 0x00000000ffe80000, 0x00000000ffe80000)
  object space 18944K, 54% used [0x00000000fec00000,0x00000000ff62c0a0,0x00000000ffe80000)
 Metaspace       used 3430K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 374K, capacity 388K, committed 512K, reserved 1048576K
Java HotSpot(TM) 64-Bit Server VM warning: NewSize (1536k) is greater than the MaxNewSize (1024k). A new max generation size of 1536k will be used. // 虚拟机建议最小新生代为 1536k

Process finished with exit code 0

2.-Xmx20m -Xms20m -Xmn7m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails
(4096 + 1536 * 2) / 1024 = 7mb
[GC (Allocation Failure) [PSYoungGen: 3072K->776K(5632K)] 3072K->1808K(18944K), 0.0027936 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 3924K->1528K(5632K)] 4956K->2792K(18944K), 0.0019124 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 4794K->1528K(5632K)] 6058K->2792K(18944K), 0.0048887 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 PSYoungGen      total 5632K, used 4757K [0x00000000ff900000, 0x0000000100000000, 0x0000000100000000) // 其中 新生代的 total 5632K = 4096+1536(eden + from)
  eden space 4096K, 78% used [0x00000000ff900000,0x00000000ffc27570,0x00000000ffd00000)
  from space 1536K, 99% used [0x00000000ffd00000,0x00000000ffe7e020,0x00000000ffe80000)
  to   space 1536K, 0% used [0x00000000ffe80000,0x00000000ffe80000,0x0000000100000000)
 ParOldGen       total 13312K, used 1264K [0x00000000fec00000, 0x00000000ff900000, 0x00000000ff900000)
  object space 13312K, 9% used [0x00000000fec00000,0x00000000fed3c010,0x00000000ff900000)
 Metaspace       used 3444K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 376K, capacity 388K, committed 512K, reserved 1048576K

Process finished with exit code 0

3.-Xmx20m -Xms20m -Xmn15m  -XX:SurvivorRatio=8 -XX:+PrintGCDetails
[GC (Allocation Failure) [PSYoungGen: 11536K->1528K(13824K)] 11536K->1760K(18944K), 0.0009594 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
Heap
 PSYoungGen      total 13824K, used 2675K [0x00000000ff100000, 0x0000000100000000, 0x0000000100000000)
  eden space 12288K, 9% used [0x00000000ff100000,0x00000000ff21ed08,0x00000000ffd00000)
  from space 1536K, 99% used [0x00000000ffd00000,0x00000000ffe7e040,0x00000000ffe80000)
  to   space 1536K, 0% used [0x00000000ffe80000,0x00000000ffe80000,0x0000000100000000)
 ParOldGen       total 5120K, used 232K [0x00000000fec00000, 0x00000000ff100000, 0x00000000ff100000)
  object space 5120K, 4% used [0x00000000fec00000,0x00000000fec3a000,0x00000000ff100000)
 Metaspace       used 3443K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 376K, capacity 388K, committed 512K, reserved 1048576K

Process finished with exit code 0
* */