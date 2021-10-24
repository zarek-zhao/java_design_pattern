package com.atguigu.singleton.type4;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest04 {
    public static void main(String[] args)
    {
        System.out.println("懒汉式2，线程安全");
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
    }
}

/**
 * 懒汉式 多线程安全写法
 * 每个类想要getInstance()的时候，都要进行同步。
 * 实际开发中，不推荐使用，效率太低了。
 */
class Singleton {
    private static Singleton instance;

    private Singleton()
    {
    }

    /**
     * provide a static function, use this function when create object instance
     * add synchronized code to solve no-safe multiple thread question
     * @return
     */
    public static synchronized Singleton getInstance()
    {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}