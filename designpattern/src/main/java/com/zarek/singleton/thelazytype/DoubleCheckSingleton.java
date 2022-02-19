package com.zarek.singleton.thelazytype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * 双重检查
 */
public class DoubleCheckSingleton {

        // 加 volatile 关键字，为了防止指令重排序
        // 如果指令重排序,线程 A 设置 instance 指向内存空间,但是对象还没有初始化完成,此时线程 B 可能访问还未初始化成功的对象instance，
    public static volatile DoubleCheckSingleton instance = null;

    private DoubleCheckSingleton()
    {
    }

    public static DoubleCheckSingleton getInstance()
    {
        // 第一层检查是为了在对象已经实例化成功的前提前，不去触发同步代码 synchronized 从而提高代码效率
        if (instance == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }


        return instance;
    }
}
