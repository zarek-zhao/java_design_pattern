package com.zarek.singleton.thelazytype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * 静态内部类：当外部类被装载的时候，静态内部类不会被装载；当静态内部类里面的静态成员被调用的时候，静态内部类才会被装载,而且只会被装载一次，装载的时候也是线程安全的
 */
public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass()
    {
    }

    static class InnerClass {

        static SingletonStaticInnerClass singletonStaticInnerClass = new SingletonStaticInnerClass();

    }

    public static SingletonStaticInnerClass getInstance()
    {
        return InnerClass.singletonStaticInnerClass;
    }

}
