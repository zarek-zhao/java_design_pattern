package com.zarek.singleton;

import com.zarek.singleton.thelazytype.DoubleCheckSingleton;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {


    public static void main(String[] args) throws InterruptedException
    {
        AsyncClass async = new AsyncClass();
        AsyncClass async1 = new AsyncClass();
//        while(true){

            Thread t1 = new Thread(async,"Thread-A");
            Thread t2 = new Thread(async,"Thread-B");
            Thread t3 = new Thread(async,"Thread-C");
            Thread t4 = new Thread(async1,"Thread-D");
            Thread t5 = new Thread(async1,"Thread-E");
            Thread t6 = new Thread(async1,"Thread-F");


            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();





    }
}

class AsyncClass implements Runnable {

    @Override
    public void run()
    {
//        饿汉式
//        Singleton singleton = Singleton.getInstance();
//        静态代码块
//        SingletonStaticCodeBlock singleton = SingletonStaticCodeBlock.getInstance();
//        双重检查
        DoubleCheckSingleton singleton = DoubleCheckSingleton.getInstance();
//        静态内部类
//        SingletonStaticInnerClass singleton = SingletonStaticInnerClass.getInstance();
//        枚举
//        Singleton singleton = com.zarek.singleton.enumtype.Singleton.SPRING;

        System.out.println(Thread.currentThread().getName()+"  singleton = " + singleton.hashCode());
    }
}

