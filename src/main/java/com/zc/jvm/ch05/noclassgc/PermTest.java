package com.zc.jvm.ch05.noclassgc;

import java.util.HashMap;

/**
 * noclassgc 不会回收perm
 * -XX:+PrintGCDetails -XX:PermSize=5M -XX:MaxPermSize=5m  -verbose:class -Xnoclassgc
 * <p>
 * Perm默认不用CMS，加了CMSClassUnloadingEnabled启用CMS回收Perm
 * JDK1.8之前使用
 * -XX:+PrintGCDetails -XX:PermSize=5M -XX:MaxPermSize=5m  -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled
 *
 * JDK1.8之后使用
 * -XX:+PrintGCDetails -XX:MetaspaceSize=15M -XX:MaxMetaspaceSize=15M  -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled
 *
 * @author flyingzc
 */
public class PermTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            CglibBean bean = new CglibBean("com.zc.jvm.ch5.perm" + i, new HashMap());
        }
    }
}