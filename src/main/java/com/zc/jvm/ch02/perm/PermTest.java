package com.zc.jvm.ch02.perm;

import java.util.HashMap;

/**
 * 使用 CGLIB 库生成大量的动态类,fullgc 仍然回收不了时,报 Caused by: java.lang.OutOfMemoryError: Metaspace
 * JDK1.6 1.7 -XX:+PrintGCDetails -XX:PermSize=15M -XX:MaxPermSize=15m
 * JDK1.8 -XX:+PrintGCDetails -XX:MaxMetaspaceSize=15M
 *
 * @author flyingzc
 */
public class PermTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            for (i = 0; i < 100000; i++) {
                CglibBean bean = new CglibBean("com.zc.jvm.ch02.perm" + i, new HashMap());
            }
        } catch (Exception e) {
            System.out.println("total create count:" + i);
            throw e;
        }
    }
}
/*
1.JDK1.8 -XX:+PrintGCDetails -XX:MaxMetaspaceSize=15M
E:\soft\jdk1.8.0_221\bin\java.exe -XX:+PrintGCDetails -XX:MaxMetaspaceSize=15M "-javaagent:D:\soft\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar=64739:D:\soft\JetBrains\IntelliJ IDEA 2019.1\bin" -Dfile.encoding=UTF-8 -classpath E:\soft\jdk1.8.0_221\jre\lib\charsets.jar;E:\soft\jdk1.8.0_221\jre\lib\deploy.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\access-bridge-64.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\cldrdata.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\dnsns.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\jaccess.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\jfxrt.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\localedata.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\nashorn.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\sunec.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\sunjce_provider.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\sunmscapi.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\sunpkcs11.jar;E:\soft\jdk1.8.0_221\jre\lib\ext\zipfs.jar;E:\soft\jdk1.8.0_221\jre\lib\javaws.jar;E:\soft\jdk1.8.0_221\jre\lib\jce.jar;E:\soft\jdk1.8.0_221\jre\lib\jfr.jar;E:\soft\jdk1.8.0_221\jre\lib\jfxswt.jar;E:\soft\jdk1.8.0_221\jre\lib\jsse.jar;E:\soft\jdk1.8.0_221\jre\lib\management-agent.jar;E:\soft\jdk1.8.0_221\jre\lib\plugin.jar;E:\soft\jdk1.8.0_221\jre\lib\resources.jar;E:\soft\jdk1.8.0_221\jre\lib\rt.jar;E:\workspace\03-mygitee\MyJVM\target\classes;D:\localRepository\com\google\guava\guava\19.0\guava-19.0.jar;D:\localRepository\cglib\cglib\3.1\cglib-3.1.jar;D:\localRepository\org\ow2\asm\asm\5.0.4\asm-5.0.4.jar;D:\localRepository\org\ow2\asm\asm-commons\5.0.4\asm-commons-5.0.4.jar;D:\localRepository\org\ow2\asm\asm-tree\5.0.4\asm-tree-5.0.4.jar;D:\localRepository\mysql\mysql-connector-java\5.1.18\mysql-connector-java-5.1.18.jar;E:\soft\jdk1.8.0_221\lib\tools.jar;D:\localRepository\junit\junit\4.12\junit-4.12.jar;D:\localRepository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar com.zc.jvm.ch02.perm.PermTest
[GC (Allocation Failure) [PSYoungGen: 65024K->2320K(75776K)] 65024K->2336K(249344K), 0.0020426 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 67344K->3384K(75776K)] 67360K->3408K(249344K), 0.0022552 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 68408K->4428K(75776K)] 68432K->4460K(249344K), 0.0025927 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Allocation Failure) [PSYoungGen: 69452K->5516K(75776K)] 69484K->5556K(249344K), 0.0030659 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[GC (Metadata GC Threshold) [PSYoungGen: 47805K->6216K(70144K)] 47845K->6264K(243712K), 0.0031523 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Metadata GC Threshold) [PSYoungGen: 6216K->0K(70144K)] [ParOldGen: 48K->6064K(105984K)] 6264K->6064K(176128K), [Metaspace: 14998K->14998K(1060864K)], 0.0164640 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
[GC (Last ditch collection) [PSYoungGen: 0K->0K(70656K)] 6064K->6064K(176640K), 0.0009866 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
[Full GC (Last ditch collection) [PSYoungGen: 0K->0K(70656K)] [ParOldGen: 6064K->4220K(201216K)] 6064K->4220K(271872K), [Metaspace: 14998K->14998K(1060864K)], 0.0273269 secs] [Times: user=0.17 sys=0.00, real=0.03 secs]
total create count:2310
Exception in thread "main" net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null
	at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:237)
	at net.sf.cglib.beans.BeanMap$Generator.create(BeanMap.java:122)
	at net.sf.cglib.beans.BeanMap.create(BeanMap.java:58)
	at com.zc.jvm.ch02.perm.CglibBean.<init>(CglibBean.java:35)
	at com.zc.jvm.ch02.perm.PermTest.main(PermTest.java:17)
Caused by: java.lang.reflect.InvocationTargetException
	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at net.sf.cglib.core.ReflectUtils.defineClass(ReflectUtils.java:384)
	at net.sf.cglib.core.AbstractClassGenerator.create(AbstractClassGenerator.java:219)
	... 4 more
Caused by: java.lang.OutOfMemoryError: Metaspace
	at java.lang.ClassLoader.defineClass1(Native Method)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:763)
	... 9 more
Heap
 PSYoungGen      total 70656K, used 1879K [0x00000007aae00000, 0x00000007b2680000, 0x00000007ff800000)
  eden space 63488K, 2% used [0x00000007aae00000,0x00000007aafd5dc8,0x00000007aec00000)
  from space 7168K, 0% used [0x00000007af400000,0x00000007af400000,0x00000007afb00000)
  to   space 8192K, 0% used [0x00000007aec00000,0x00000007aec00000,0x00000007af400000)
 ParOldGen       total 201216K, used 4220K [0x0000000701a00000, 0x000000070de80000, 0x00000007aae00000)
  object space 201216K, 2% used [0x0000000701a00000,0x0000000701e1f268,0x000000070de80000)
 Metaspace       used 15030K, capacity 15306K, committed 15360K, reserved 1060864K
  class space    used 3816K, capacity 3825K, committed 3840K, reserved 1048576K

Process finished with exit code 1

 */