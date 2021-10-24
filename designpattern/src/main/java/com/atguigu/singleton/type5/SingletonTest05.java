package com.atguigu.singleton.type5;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest05 {
    public static void main(String[] args)
    {
        System.out.println("懒汉式2，线程安全,效率高");
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
    }
}

/**
 * 懒汉式 双重检查 多线程安全写法
 * <p>
 * 推荐使用
 */
class Singleton {
    private static volatile Singleton instance;

    private Singleton()
    {
    }

    /**
     * provide a static function, use this function when create object instance
     * add synchronized code to solve no-safe multiple thread question and lower effective
     *
     * @return
     */
    public static Singleton getInstance()
    {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}