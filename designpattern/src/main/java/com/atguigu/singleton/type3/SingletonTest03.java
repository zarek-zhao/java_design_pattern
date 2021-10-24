package com.atguigu.singleton.type3;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest03 {
    public static void main(String[] args)
    {
        System.out.println("懒汉式线程不安全");
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
    }
}

/**
 * 懒汉式 多线程中可能会产生多个实例
 *
 * 在实际开发中，不要使用这种方式
 */
class Singleton {
    private static Singleton instance;

    private Singleton()
    {
    }

    /**
     * provide a static function, use this function when create object instance
     *
     * @return
     */
    public static Singleton getInstance()
    {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}