package com.atguigu.singleton.type1;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest01 {
    public static void main(String[] args)
    {
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
    }
}

/**
 * 饿汉式写法(静态常量)
 */

class Singleton {
    /**
     * private the constructor
     */
    private Singleton()
    {
    }

    /**
     * create a object instance
     */
    private final static Singleton instance = new Singleton();

    /**
     * return a public getInstance function
     *
     * @return instance
     */
    public static Singleton getInstance()
    {
        return instance;
    }

}