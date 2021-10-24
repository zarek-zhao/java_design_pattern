package com.atguigu.singleton.type6;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest06 {
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("懒汉式3 静态内部类，线程安全,效率高");
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
        Thread.sleep(10000);
    }
}

/**
 * 懒汉式 静态内部类
 * <p>
 *
 * 静态内部类的特点：
 * 1. 将外部类被装载的时候，静态内部类并不会立即被装载
 * 2. 当外部类调用getInstance()方法的时候，会导致静态内部类的装载，但只会被装载一次。
 *
 * 因此可以达到懒加载的效果，同时线程安全和效率高。
 * 推荐使用
 */
class Singleton {
    private Singleton()
    {
    }

    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }

}