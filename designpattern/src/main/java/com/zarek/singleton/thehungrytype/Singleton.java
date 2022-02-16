package com.zarek.singleton.thehungrytype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * 饿汉式
 */
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton()
    {
    }

    public static Singleton getInstance()
    {
        return INSTANCE;
    }
}
