package com.atguigu.singleton.type2;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest02 {
    public static void main(String[] args)
    {
        Singleton instance = Singleton.getInstance();
        System.out.println("instance = " + instance);
        Singleton instance1 = Singleton.getInstance();
        System.out.println("instance1 = " + instance1);
    }
}

/**
 * 饿汉式写法(静态代码块)
 *
 * 这种写法可以使用，但是可能会造成内存浪费
 * 因为，在类装载的时候，实例就会被创建出来，但是不一定会被使用
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
    private static Singleton instance;

    //  create object instance in static code block
    static {
        instance = new Singleton();
    }

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