```
// 1.gc之前
{Heap before GC invocations=1 (full 0):
 PSYoungGen      total 305664K, used 261493K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
 // eden满了,所以要新生代gc
  eden space 262144K, 99% used [0x00000000eab00000,0x00000000faa5d5b8,0x00000000fab00000)
  from space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 ParOldGen       total 699392K, used 0K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0000000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 261493K->6280K(305664K)] 261493K->6288K(1005056K), 0.0088846 secs] [Times: user=0.05 sys=0.00, real=0.01 secs]

// gc之后
Heap after GC invocations=1 (full 0):
 PSYoungGen      total 305664K, used 6280K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
 // eden空了
  eden space 262144K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fab00000)
  // from用了14%
  from space 43520K, 14% used [0x00000000fab00000,0x00000000fb122030,0x00000000fd580000)
  to   space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 第2次
{Heap before GC invocations=2 (full 0):
 PSYoungGen      total 305664K, used 268424K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 100% used [0x00000000eab00000,0x00000000fab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fab00000,0x00000000fb122030,0x00000000fd580000)
  to   space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 268424K->6248K(305664K)] 268432K->6256K(1005056K), 0.0178029 secs] [Times: user=0.02 sys=0.00, real=0.02 secs]


Heap after GC invocations=2 (full 0):
 PSYoungGen      total 305664K, used 6248K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fd580000,0x00000000fdb9a030,0x0000000100000000)
  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 3.
{Heap before GC invocations=3 (full 0):
 PSYoungGen      total 305664K, used 268392K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 100% used [0x00000000eab00000,0x00000000fab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fd580000,0x00000000fdb9a030,0x0000000100000000)
  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 268392K->6248K(305664K)] 268400K->6256K(1005056K), 0.0013530 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]


Heap after GC invocations=3 (full 0):
 PSYoungGen      total 305664K, used 6248K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fab00000,0x00000000fb11a030,0x00000000fd580000)
  to   space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 4.
{Heap before GC invocations=4 (full 0):
 PSYoungGen      total 305664K, used 268392K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 100% used [0x00000000eab00000,0x00000000fab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fab00000,0x00000000fb11a030,0x00000000fd580000)
  to   space 43520K, 0% used [0x00000000fd580000,0x00000000fd580000,0x0000000100000000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 268392K->6216K(305664K)] 268400K->6224K(1005056K), 0.0022423 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=4 (full 0):
 PSYoungGen      total 305664K, used 6216K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fd580000,0x00000000fdb92030,0x0000000100000000)
  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 5.
{Heap before GC invocations=5 (full 0):
 PSYoungGen      total 305664K, used 268360K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 100% used [0x00000000eab00000,0x00000000fab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fd580000,0x00000000fdb92030,0x0000000100000000)
  to   space 43520K, 0% used [0x00000000fab00000,0x00000000fab00000,0x00000000fd580000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 268360K->6248K(305664K)] 268368K->6256K(1005056K), 0.0014694 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=5 (full 0):
 PSYoungGen      total 305664K, used 6248K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fab00000,0x00000000fb11a030,0x00000000fd580000)
  to   space 6656K, 0% used [0x00000000ff980000,0x00000000ff980000,0x0000000100000000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 6.
{Heap before GC invocations=6 (full 0):
 PSYoungGen      total 305664K, used 268113K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 262144K, 99% used [0x00000000eab00000,0x00000000faaba410,0x00000000fab00000)
  from space 43520K, 14% used [0x00000000fab00000,0x00000000fb11a030,0x00000000fd580000)
  to   space 6656K, 0% used [0x00000000ff980000,0x00000000ff980000,0x0000000100000000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 268113K->6216K(342528K)] 268121K->6224K(1041920K), 0.0024872 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=6 (full 0):
 PSYoungGen      total 342528K, used 6216K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 335872K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000ff300000)
  from space 6656K, 93% used [0x00000000ff980000,0x00000000fff92030,0x0000000100000000)
  to   space 6656K, 0% used [0x00000000ff300000,0x00000000ff300000,0x00000000ff980000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 7.
{Heap before GC invocations=7 (full 0):
 PSYoungGen      total 342528K, used 341570K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 335872K, 99% used [0x00000000eab00000,0x00000000ff27e9c8,0x00000000ff300000)
  from space 6656K, 93% used [0x00000000ff980000,0x00000000fff92030,0x0000000100000000)
  to   space 6656K, 0% used [0x00000000ff300000,0x00000000ff300000,0x00000000ff980000)
 ParOldGen       total 699392K, used 8K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c0002000,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 341570K->0K(336384K)] 341578K->6576K(1035776K), 0.0022866 secs] [Times: user=0.03 sys=0.02, real=0.00 secs]


Heap after GC invocations=7 (full 0):
 PSYoungGen      total 336384K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 335872K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000ff300000)
  from space 512K, 0% used [0x00000000ff300000,0x00000000ff300000,0x00000000ff380000)
  to   space 7680K, 0% used [0x00000000ff880000,0x00000000ff880000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 8.
{Heap before GC invocations=8 (full 0):
 PSYoungGen      total 336384K, used 335325K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 335872K, 99% used [0x00000000eab00000,0x00000000ff277780,0x00000000ff300000)
  from space 512K, 0% used [0x00000000ff300000,0x00000000ff300000,0x00000000ff380000)
  to   space 7680K, 0% used [0x00000000ff880000,0x00000000ff880000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 335325K->0K(339456K)] 341902K->6576K(1038848K), 0.0006879 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=8 (full 0):
 PSYoungGen      total 339456K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 331776K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fef00000)
  from space 7680K, 0% used [0x00000000ff880000,0x00000000ff880000,0x0000000100000000)
  to   space 8704K, 0% used [0x00000000fef00000,0x00000000fef00000,0x00000000ff780000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 9.
{Heap before GC invocations=9 (full 0):
 PSYoungGen      total 339456K, used 331180K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 331776K, 99% used [0x00000000eab00000,0x00000000fee6b278,0x00000000fef00000)
  from space 7680K, 0% used [0x00000000ff880000,0x00000000ff880000,0x0000000100000000)
  to   space 8704K, 0% used [0x00000000fef00000,0x00000000fef00000,0x00000000ff780000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 331180K->0K(332288K)] 337756K->6576K(1031680K), 0.0007463 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=9 (full 0):
 PSYoungGen      total 332288K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 331776K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fef00000)
  from space 512K, 0% used [0x00000000fef00000,0x00000000fef00000,0x00000000fef80000)
  to   space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 10.
{Heap before GC invocations=10 (full 0):
 PSYoungGen      total 332288K, used 331201K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 331776K, 99% used [0x00000000eab00000,0x00000000fee70598,0x00000000fef00000)
  from space 512K, 0% used [0x00000000fef00000,0x00000000fef00000,0x00000000fef80000)
  to   space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 331201K->0K(339968K)] 337777K->6576K(1039360K), 0.0002707 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=10 (full 0):
 PSYoungGen      total 339968K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fee00000)
  from space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
  to   space 9216K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000ff700000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 11.
{Heap before GC invocations=11 (full 0):
 PSYoungGen      total 339968K, used 330170K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 99% used [0x00000000eab00000,0x00000000fed6e978,0x00000000fee00000)
  from space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
  to   space 9216K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000ff700000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 330170K->0K(331264K)] 336746K->6576K(1030656K), 0.0003703 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=11 (full 0):
 PSYoungGen      total 331264K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fee00000)
  from space 512K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000fee80000)
  to   space 9728K, 0% used [0x00000000ff680000,0x00000000ff680000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 12.
{Heap before GC invocations=12 (full 0):
 PSYoungGen      total 331264K, used 330179K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 99% used [0x00000000eab00000,0x00000000fed70c40,0x00000000fee00000)
  from space 512K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000fee80000)
  to   space 9728K, 0% used [0x00000000ff680000,0x00000000ff680000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 330179K->0K(339456K)] 336755K->6576K(1038848K), 0.0003674 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=12 (full 0):
 PSYoungGen      total 339456K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 329728K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fed00000)
  from space 9728K, 0% used [0x00000000ff680000,0x00000000ff680000,0x0000000100000000)
  to   space 9728K, 0% used [0x00000000fed00000,0x00000000fed00000,0x00000000ff680000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 13.
{Heap before GC invocations=13 (full 0):
 PSYoungGen      total 339456K, used 329140K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 329728K, 99% used [0x00000000eab00000,0x00000000fec6d0e0,0x00000000fed00000)
  from space 9728K, 0% used [0x00000000ff680000,0x00000000ff680000,0x0000000100000000)
  to   space 9728K, 0% used [0x00000000fed00000,0x00000000fed00000,0x00000000ff680000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 329140K->0K(339456K)] 335716K->6576K(1038848K), 0.0002425 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=13 (full 0):
 PSYoungGen      total 339456K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 329728K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fed00000)
  from space 9728K, 0% used [0x00000000fed00000,0x00000000fed00000,0x00000000ff680000)
  to   space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 14.
{Heap before GC invocations=14 (full 0):
 PSYoungGen      total 339456K, used 329143K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 329728K, 99% used [0x00000000eab00000,0x00000000fec6dfc0,0x00000000fed00000)
  from space 9728K, 0% used [0x00000000fed00000,0x00000000fed00000,0x00000000ff680000)
  to   space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 329143K->0K(339968K)] 335720K->6576K(1039360K), 0.0005601 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]


Heap after GC invocations=14 (full 0):
 PSYoungGen      total 339968K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fee00000)
  from space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
  to   space 9216K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000ff700000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}

// 15.
{Heap before GC invocations=15 (full 0):
 PSYoungGen      total 339968K, used 330190K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 99% used [0x00000000eab00000,0x00000000fed73b20,0x00000000fee00000)
  from space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
  to   space 9216K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000ff700000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
[GC (Allocation Failure) [PSYoungGen: 330190K->0K(339968K)] 336766K->6576K(1039360K), 0.0034323 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]

// 16.每次GC年龄加1,第16次GC,将新生代清空,全部晋升到老年代中
Heap after GC invocations=15 (full 0):
 PSYoungGen      total 339968K, used 0K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 0% used [0x00000000eab00000,0x00000000eab00000,0x00000000fee00000)
  from space 9216K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000ff700000)
  to   space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3445K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
}


Heap
 PSYoungGen      total 339968K, used 186277K [0x00000000eab00000, 0x0000000100000000, 0x0000000100000000)
  eden space 330752K, 56% used [0x00000000eab00000,0x00000000f60e9530,0x00000000fee00000)
  from space 9216K, 0% used [0x00000000fee00000,0x00000000fee00000,0x00000000ff700000)
  to   space 9216K, 0% used [0x00000000ff700000,0x00000000ff700000,0x0000000100000000)
 ParOldGen       total 699392K, used 6576K [0x00000000c0000000, 0x00000000eab00000, 0x00000000eab00000)
  object space 699392K, 0% used [0x00000000c0000000,0x00000000c066c090,0x00000000eab00000)
 Metaspace       used 3452K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 376K, capacity 388K, committed 512K, reserved 1048576K

Process finished with exit code 0
```

```
// 1.(young)新生代GC, (initial-mark)初始标记 
[GC pause (G1 Humongous Allocation) (young) (initial-mark), 0.0009823 secs]
// 2.后续并行时间 Parallel Time
   [Parallel Time: 0.8 ms, GC Workers: 4]
   // 给出每一个GC线程的执行情况.给出了这几个启动数据的统计值，如平均（Avg）、最小（Min）、最大（Max）和差值（Diff）。Diff表示最大值和最小值的差
      [GC Worker Start (ms): Min: 132.8, Avg: 132.8, Max: 132.8, Diff: 0.0]
      // 给出了根扫描的耗时
      [Ext Root Scanning (ms): Min: 0.3, Avg: 0.4, Max: 0.8, Diff: 0.5, Sum: 1.6]
      // 给出了更新记忆集（Remembered Set）的耗时
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
      // 扫描RS的时间
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      // 在正式回收时，G1会对被回收区域的对象进行疏散，即将存活对象放置在其他区域中，因此需要进行对象的复制。这里给出的Object Copy就是进行对象赋值的耗时。
      [Object Copy (ms): Min: 0.0, Avg: 0.4, Max: 0.5, Diff: 0.5, Sum: 1.4]
      // 给出GC工作线程的终止信息
      [Termination (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
         [Termination Attempts: Min: 1, Avg: 1.3, Max: 2, Diff: 1, Sum: 5]
      // 显示GC线程花费在其他任务中的耗时，单位是毫秒
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.1]
      [GC Worker Total (ms): Min: 0.8, Avg: 0.8, Max: 0.8, Diff: 0.0, Sum: 3.2]
      // 显示GC工作线程的完成时间
      [GC Worker End (ms): Min: 133.6, Avg: 133.6, Max: 133.6, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   // 显示清空CardTable的时间，RS就是依靠CardTable来记录哪些是存活对象的
   [Clear CT: 0.0 ms]
   // 显示其他几个任务的耗时
   [Other: 0.1 ms]
      [Choose CSet: 0.0 ms] // 比如选择CSet（Collection Sets）的时间
      [Ref Proc: 0.0 ms] // Ref Proc（处理弱引用、软引用的时间）
      [Ref Enq: 0.0 ms] // Ref Enq（弱引用、软引用入队时间）
      [Redirty Cards: 0.0 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms] // Free CSet（释放被回收的CSet中区域的时间，包括它们的RS）
    // 回收前后的 eden,survivors,heap
   [Eden: 3072.0K(7168.0K)->0.0B(6144.0K) Survivors: 0.0B->1024.0K Heap: 6290.4K(20.0M)->4816.1K(20.0M)]
 [Times: user=0.00 sys=0.00, real=0.00 secs]
 
  
[GC concurrent-root-region-scan-start]
[GC concurrent-root-region-scan-end, 0.0004220 secs]
[GC concurrent-mark-start]
[GC concurrent-mark-end, 0.0001751 secs]
[GC remark [Finalize Marking, 0.0000507 secs] [GC ref-proc, 0.0000302 secs] [Unloading, 0.0004639 secs], 0.0006310 secs]
 [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC cleanup 8912K->8912K(20M), 0.0249159 secs]
 [Times: user=0.00 sys=0.00, real=0.03 secs] 
[GC pause (G1 Humongous Allocation) (young) (to-space exhausted), 0.0078425 secs]
   [Parallel Time: 7.2 ms, GC Workers: 4]
      [GC Worker Start (ms): Min: 161.2, Avg: 161.2, Max: 161.3, Diff: 0.2]
      [Ext Root Scanning (ms): Min: 0.1, Avg: 1.8, Max: 7.1, Diff: 7.1, Sum: 7.4]
      [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
         [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
      [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.2, Diff: 0.2, Sum: 0.2]
      [Object Copy (ms): Min: 0.0, Avg: 4.5, Max: 7.0, Diff: 7.0, Sum: 18.0]
      [Termination (ms): Min: 0.0, Avg: 0.7, Max: 1.5, Diff: 1.5, Sum: 2.9]
         [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 4]
      [GC Worker Other (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
      [GC Worker Total (ms): Min: 7.0, Avg: 7.1, Max: 7.2, Diff: 0.2, Sum: 28.4]
      [GC Worker End (ms): Min: 168.3, Avg: 168.3, Max: 168.3, Diff: 0.0]
   [Code Root Fixup: 0.0 ms]
   [Code Root Purge: 0.0 ms]
   [Clear CT: 0.0 ms]
   [Other: 0.6 ms]
      [Evacuation Failure: 0.5 ms]
      [Choose CSet: 0.0 ms]
      [Ref Proc: 0.0 ms]
      [Ref Enq: 0.0 ms]
      [Redirty Cards: 0.0 ms]
      [Humongous Register: 0.0 ms]
      [Humongous Reclaim: 0.0 ms]
      [Free CSet: 0.0 ms]
   [Eden: 1024.0K(6144.0K)->0.0B(7168.0K) Survivors: 1024.0K->0.0B Heap: 10059.1K(20.0M)->10059.1K(20.0M)]
 [Times: user=0.00 sys=0.00, real=0.01 secs] 
[Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 10059K->9862K(20M), 0.0018004 secs]
	at com.zc.jvm.ch05.t01serial.T03G1.main(T03G1.java:14)
   [Eden: 0.0B(7168.0K)->0.0B(7168.0K) Survivors: 0.0B->0.0B Heap: 10059.1K(20.0M)->9862.8K(20.0M)], [Metaspace: 3427K->3427K(1056768K)]
 [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (Allocation Failure)  9862K->9844K(20M), 0.0015562 secs]
   [Eden: 0.0B(7168.0K)->0.0B(7168.0K) Survivors: 0.0B->0.0B Heap: 9862.8K(20.0M)->9844.7K(20.0M)], [Metaspace: 3427K->3427K(1056768K)]
 [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 garbage-first heap   total 20480K, used 9844K [0x00000000fec00000, 0x00000000fed000a0, 0x0000000100000000)
  region size 1024K, 1 young (1024K), 0 survivors (0K)
 Metaspace       used 3470K, capacity 4496K, committed 4864K, reserved 1056768K
  class space    used 379K, capacity 388K, committed 512K, reserved 1048576K

Process finished with exit code 1
```