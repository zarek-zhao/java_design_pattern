package com.zarek.singleton.thelazytype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * 懒汉式
 */
public class Singleton {
    public static volatile Singleton instance = null;

    private Singleton()
    {
    }

    public static  Singleton getInstance()
    {
//        if (instance == null) {
//            synchronized (Singleton.class){
//                if(instance == null){
//                    instance = new Singleton();
//                }
//            }
//        }

        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }
}
