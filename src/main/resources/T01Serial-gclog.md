## 1.新生代 和 老年代 都使用 串行收集器
### 1.1. -XX：+UseSerialGC：新生代、老年代都使用串行回收器
```
test01()
-XX:+UseSerialGC -Xmx20m -Xms20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails

[GC (Allocation Failure) [DefNew: 511K->256K(768K), 0.0007911 secs] 511K->434K(20224K), 0.0008392 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 768K->104K(768K), 0.0008436 secs] 946K->538K(20224K), 0.0008732 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 614K->162K(768K), 0.0005988 secs] 1048K->597K(20224K), 0.0006228 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 674K->161K(768K), 0.0009419 secs] 1109K->696K(20224K), 0.0009735 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [DefNew: 673K->146K(768K), 0.0006747 secs] 1208K->740K(20224K), 0.0007017 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 658K->70K(768K), 0.0006407 secs] 1252K->752K(20224K), 0.0006736 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 582K->201K(768K), 0.0009319 secs] 1264K->882K(20224K), 0.0009650 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 713K->54K(768K), 0.0009671 secs] 1394K->934K(20224K), 0.0010005 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 562K->125K(768K), 0.0004815 secs] 1442K->1005K(20224K), 0.0005483 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 637K->126K(768K), 0.0005750 secs] 1517K->1006K(20224K), 0.0006120 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 638K->111K(768K), 0.0004618 secs] 1517K->991K(20224K), 0.0004961 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [DefNew: 623K->110K(768K), 0.0006325 secs] 1503K->990K(20224K), 0.0007340 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [DefNew: 622K->137K(768K), 0.0006093 secs] 1502K->1017K(20224K), 0.0006486 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [DefNew: 649K->649K(768K), 0.0000496 secs][Tenured: 19312K->19449K(19456K), 0.0035384 secs] 19961K->19449K(20224K), [Metaspace: 5199K->5199K(1056768K)], 0.0036592 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Allocation Failure) [Tenured: 19449K->19387K(19456K), 0.0072431 secs] 19449K->19387K(20224K), [Metaspace: 5199K->5199K(1056768K)], 0.0072777 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]

java.lang.OutOfMemoryError: Java heap space

	at com.zc.jvm.ch05.t01serial.T01Serial.test01(T01Serial.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

Heap
 def new generation   total 768K, used 368K [0x00000000fec00000, 0x00000000fed00000, 0x00000000fed00000)
  eden space 512K,  71% used [0x00000000fec00000, 0x00000000fec5c038, 0x00000000fec80000)
  from space 256K,   0% used [0x00000000fecc0000, 0x00000000fecc0000, 0x00000000fed00000)
  to   space 256K,   0% used [0x00000000fec80000, 0x00000000fec80000, 0x00000000fecc0000)
 tenured generation   total 19456K, used 19387K [0x00000000fed00000, 0x0000000100000000, 0x0000000100000000)
   the space 19456K,  99% used [0x00000000fed00000, 0x00000000fffeee68, 0x00000000fffef000, 0x0000000100000000)
 Metaspace       used 5267K, capacity 5418K, committed 5632K, reserved 1056768K
  class space    used 611K, capacity 658K, committed 768K, reserved 1048576K

Process finished with exit code -1
```

## 2.ParNew 新生代并行收集器
### 2.1. -XX:+UseParNewGC : 在新生代使用 ParNew 并行收集器,老年代使用串行回收期.
```
test01()
-XX:+UseParNewGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails

[GC (Allocation Failure) [ParNew: 511K->255K(768K), 0.0005026 secs] 511K->511K(20224K), 0.0005469 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 767K->237K(768K), 0.0004613 secs] 1023K->830K(20224K), 0.0004985 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 748K->195K(768K), 0.0004202 secs] 1341K->788K(20224K), 0.0004486 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 707K->191K(768K), 0.0005448 secs] 1300K->896K(20224K), 0.0005747 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [ParNew: 703K->255K(768K), 0.0002859 secs] 1408K->1043K(20224K), 0.0003126 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 767K->109K(768K), 0.0003328 secs] 1555K->1001K(20224K), 0.0003657 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 621K->238K(768K), 0.0004214 secs] 1513K->1130K(20224K), 0.0004610 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 750K->66K(768K), 0.0030942 secs] 1642K->1163K(20224K), 0.0031294 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 569K->152K(768K), 0.0003868 secs] 1666K->1249K(20224K), 0.0004199 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 664K->133K(768K), 0.0023423 secs] 1761K->1230K(20224K), 0.0023837 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 641K->131K(768K), 0.0002838 secs] 1738K->1228K(20224K), 0.0003146 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 643K->135K(768K), 0.0095089 secs] 1740K->1232K(20224K), 0.0095482 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] [GC (Allocation Failure) [ParNew: 647K->161K(768K), 0.0005164 secs] 1744K->1258K(20224K), 0.0005516 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [ParNew: 670K->131K(768K), 0.0008328 secs][Tenured: 18545K->18655K(19456K), 0.0039085 secs] 19176K->18655K(20224K), [Metaspace: 5188K->5188K(1056768K)], 0.0048108 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
[Full GC (Allocation Failure) [Tenured: 18655K->18363K(19456K), 0.0080864 secs] 18655K->18363K(20224K), [Metaspace: 5188K->5188K(1056768K)], 0.0081278 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [ParNew: 0K->0K(768K), 0.0009630 secs][Tenured: 19387K->19387K(19456K), 0.0029499 secs] 19387K->19387K(20224K), [Metaspace: 5185K->5185K(1056768K)], 0.0039718 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
[Full GC (Allocation Failure) [Tenured: 19387K->19387K(19456K), 0.0030836 secs] 19387K->19387K(20224K), [Metaspace: 5185K->5185K(1056768K)], 0.0031185 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

java.lang.OutOfMemoryError: Java heap space

	at com.zc.jvm.ch05.t01serial.T01Serial.test01(T01Serial.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

Heap
 par new generation   total 768K, used 365K [0x00000000fec00000, 0x00000000fed00000, 0x00000000fed00000)
  eden space 512K,  71% used [0x00000000fec00000, 0x00000000fec5b5e0, 0x00000000fec80000)
  from space 256K,   0% used [0x00000000fecc0000, 0x00000000fecc0000, 0x00000000fed00000)
  to   space 256K,   0% used [0x00000000fec80000, 0x00000000fec80000, 0x00000000fecc0000)
 tenured generation   total 19456K, used 19387K [0x00000000fed00000, 0x0000000100000000, 0x0000000100000000)
   the space 19456K,  99% used [0x00000000fed00000, 0x00000000fffeeef8, 0x00000000fffef000, 0x0000000100000000)
 Metaspace       used 5259K, capacity 5430K, committed 5632K, reserved 1056768K
  class space    used 611K, capacity 658K, committed 768K, reserved 1048576K
Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future release

Process finished with exit code -1
```

### 2.2. -XX:+UseConcMarkSweepGC：新生代使用 ParNew 并行收集器,老年代使用 CMS.
```
test01()
-XX:+UseConcMarkSweepGC -Xmx20m -Xms20m -Xmn1m   -XX:SurvivorRatio=2 -XX:+PrintGCDetails

[GC (Allocation Failure) [ParNew: 511K->256K(768K), 0.0008935 secs] 511K->446K(20224K), 0.0009483 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 768K->242K(768K), 0.0007084 secs] 958K->688K(20224K), 0.0007422 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 754K->220K(768K), 0.0004096 secs] 1200K->666K(20224K), 0.0004463 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 725K->230K(768K), 0.0005258 secs] 1171K->778K(20224K), 0.0005612 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [ParNew: 742K->223K(768K), 0.0003765 secs] 1290K->831K(20224K), 0.0004061 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 735K->109K(768K), 0.0034317 secs] 1343K->805K(20224K), 0.0034812 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 621K->225K(768K), 0.0004428 secs] 1317K->920K(20224K), 0.0004774 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 737K->188K(768K), 0.0010342 secs] 1432K->1084K(20224K), 0.0010694 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 689K->142K(768K), 0.0004935 secs] 1584K->1038K(20224K), 0.0005284 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 654K->140K(768K), 0.0003926 secs] 1550K->1035K(20224K), 0.0004264 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 648K->126K(768K), 0.0003501 secs] 1544K->1021K(20224K), 0.0003853 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [ParNew: 638K->118K(768K), 0.0003642 secs] 1533K->1014K(20224K), 0.0004000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [ParNew: 630K->146K(768K), 0.0023863 secs] 1526K->1042K(20224K), 0.0024312 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [ParNew: 658K->153K(768K), 0.0005976 secs][CMS: 18331K->18430K(19456K), 0.0078598 secs] 18962K->18430K(20224K), [Metaspace: 5199K->5199K(1056768K)], 0.0085245 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
[Full GC (Allocation Failure) [CMS: 18430K->18373K(19456K), 0.0080123 secs] 18430K->18373K(20224K), [Metaspace: 5199K->5199K(1056768K)], 0.0080650 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[GC (CMS Initial Mark) [1 CMS-initial-mark: 18373K(19456K)] 18551K(20224K), 0.0004560 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[CMS-concurrent-mark-start]
[CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[CMS-concurrent-preclean-start]
[CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (CMS Final Remark) [YG occupancy: 265 K (768 K)][Rescan (parallel) , 0.0009251 secs][weak refs processing, 0.0000243 secs][class unloading, 0.0007738 secs][scrub symbol table, 0.0006750 secs][scrub string table, 0.0001331 secs][1 CMS-remark: 18373K(19456K)] 18639K(20224K), 0.0026696 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 

java.lang.OutOfMemoryError: Java heap space

	at com.zc.jvm.ch05.t01serial.T01Serial.test01(T01Serial.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

[CMS-concurrent-sweep-start]
[CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[CMS-concurrent-reset-start]
[CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 par new generation   total 768K, used 372K [0x00000000fec00000, 0x00000000fed00000, 0x00000000fed00000)
  eden space 512K,  72% used [0x00000000fec00000, 0x00000000fec5d348, 0x00000000fec80000)
  from space 256K,   0% used [0x00000000fec80000, 0x00000000fec80000, 0x00000000fecc0000)
  to   space 256K,   0% used [0x00000000fecc0000, 0x00000000fecc0000, 0x00000000fed00000)
 concurrent mark-sweep generation total 19456K, used 941K [0x00000000fed00000, 0x0000000100000000, 0x0000000100000000)
 Metaspace       used 5265K, capacity 5418K, committed 5632K, reserved 1056768K
  class space    used 611K, capacity 658K, committed 768K, reserved 1048576K

Process finished with exit code -1

```

## 3.Parallel 新生代并行收集器
### 3.1. -XX:+UseParallelGC : 新生代使用 Parallel 回收器，老年代使用串行回收器
```
[GC (Allocation Failure) [PSYoungGen: 511K->488K(1024K)] 511K->504K(19968K), 0.0230237 secs] [Times: user=0.00 sys=0.00, real=0.02 secs] 
[GC (Allocation Failure) [PSYoungGen: 1000K->504K(1024K)] 1016K->576K(19968K), 0.0012943 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1014K->504K(1024K)] 1086K->648K(19968K), 0.0083046 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 1016K->488K(1024K)] 1160K->748K(19968K), 0.0020594 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [PSYoungGen: 1000K->504K(1024K)] 1260K->862K(19968K), 0.0006917 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1011K->488K(1024K)] 1369K->886K(19968K), 0.0016210 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1000K->336K(1024K)] 1398K->1094K(19968K), 0.0125550 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 848K->256K(1024K)] 1606K->1110K(19968K), 0.0232278 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 
[GC (Allocation Failure) [PSYoungGen: 761K->320K(1024K)] 1615K->1214K(19968K), 0.0163515 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
[GC (Allocation Failure) [PSYoungGen: 832K->128K(1024K)] 1726K->1198K(19968K), 0.0080498 secs] [Times: user=0.01 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 640K->96K(1024K)] 1710K->1190K(19968K), 0.0086958 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 608K->128K(1024K)] 1702K->1238K(19968K), 0.0043606 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [PSYoungGen: 640K->128K(1024K)] 1750K->1262K(19968K), 0.0012234 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [PSYoungGen: 638K->96K(1024K)] 19181K->18670K(19968K), 0.0065391 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 96K->0K(1024K)] 18670K->18630K(19968K), 0.0068431 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] [ParOldGen: 18630K->18449K(18944K)] 18630K->18449K(19968K), [Metaspace: 5191K->5191K(1056768K)], 0.0174018 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 
[GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] 18449K->18449K(19968K), 0.0002777 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] [ParOldGen: 18449K->18393K(18944K)] 18449K->18393K(19968K), [Metaspace: 5191K->5187K(1056768K)], 0.0111188 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 

java.lang.OutOfMemoryError: Java heap space

	at com.zc.jvm.ch05.t01serial.T01Serial.test01(T01Serial.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

Heap
 PSYoungGen      total 1024K, used 365K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
  eden space 512K, 71% used [0x00000000ffe80000,0x00000000ffedb6c0,0x00000000fff00000)
  from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
  to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 ParOldGen       total 18944K, used 18393K [0x00000000fec00000, 0x00000000ffe80000, 0x00000000ffe80000)
  object space 18944K, 97% used [0x00000000fec00000,0x00000000ffdf6798,0x00000000ffe80000)
 Metaspace       used 5260K, capacity 5434K, committed 5632K, reserved 1056768K
  class space    used 611K, capacity 658K, committed 768K, reserved 1048576K
Java HotSpot(TM) 64-Bit Server VM warning: NewSize (1536k) is greater than the MaxNewSize (1024k). A new max generation size of 1536k will be used.

Process finished with exit code -1
```

### 3.2. -XX:+UseParallelOldGC : 新生代使用 Parallel 回收器，老年代使用 ParallelOldGC 回收器
```
[GC (Allocation Failure) [PSYoungGen: 511K->488K(1024K)] 511K->496K(19968K), 0.0004393 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1000K->504K(1024K)] 1008K->600K(19968K), 0.0006082 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1014K->504K(1024K)] 1110K->672K(19968K), 0.0010424 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1016K->504K(1024K)] 1184K->776K(19968K), 0.0026790 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [PSYoungGen: 1016K->504K(1024K)] 1288K->853K(19968K), 0.0007862 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1013K->504K(1024K)] 1362K->948K(19968K), 0.0006853 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 1016K->368K(1024K)] 1460K->1148K(19968K), 0.0009360 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 880K->288K(1024K)] 1660K->1172K(19968K), 0.0007257 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 790K->320K(1024K)] 1675K->1252K(19968K), 0.0006079 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 832K->192K(1024K)] 1764K->1324K(19968K), 0.0011260 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 704K->96K(1024K)] 1836K->1252K(19968K), 0.0038935 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC (Allocation Failure) [PSYoungGen: 608K->160K(1024K)] 1764K->1340K(19968K), 0.0004369 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] [GC (Allocation Failure) [PSYoungGen: 672K->96K(1024K)] 1852K->1300K(19968K), 0.0070856 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] [GC (Allocation Failure) [PSYoungGen: 605K->64K(1024K)] 19218K->18700K(19968K), 0.0060303 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 64K->0K(1024K)] 18700K->18684K(19968K), 0.0054632 secs] [Times: user=0.03 sys=0.00, real=0.00 secs] 
[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] [ParOldGen: 18684K->18419K(18944K)] 18684K->18419K(19968K), [Metaspace: 5198K->5198K(1056768K)], 0.0121166 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
[GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] 18419K->18419K(19968K), 0.0003806 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] [ParOldGen: 18419K->18363K(18944K)] 18419K->18363K(19968K), [Metaspace: 5198K->5195K(1056768K)], 0.0100778 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 

java.lang.OutOfMemoryError: Java heap space

	at com.zc.jvm.ch05.t01serial.T01Serial.test01(T01Serial.java:49)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

Heap
 PSYoungGen      total 1024K, used 383K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
  eden space 512K, 74% used [0x00000000ffe80000,0x00000000ffedfda8,0x00000000fff00000)
  from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
  to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 ParOldGen       total 18944K, used 18363K [0x00000000fec00000, 0x00000000ffe80000, 0x00000000ffe80000)
  object space 18944K, 96% used [0x00000000fec00000,0x00000000ffdeef80,0x00000000ffe80000)
 Metaspace       used 5265K, capacity 5418K, committed 5632K, reserved 1056768K
  class space    used 611K, capacity 658K, committed 768K, reserved 1048576K
Java HotSpot(TM) 64-Bit Server VM warning: NewSize (1536k) is greater than the MaxNewSize (1024k). A new max generation size of 1536k will be used.

Process finished with exit code -1
```