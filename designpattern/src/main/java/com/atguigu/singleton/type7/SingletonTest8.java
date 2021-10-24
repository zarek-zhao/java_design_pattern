package com.atguigu.singleton.type7;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingletonTest8 {
    public static void main(String[] args)
    {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        Singleton hello = Singleton.HELLO;
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode() = " + instance.hashCode());
        System.out.println("instance2.hashCode() = " + instance2.hashCode());
        System.out.println("hello.hashCode() = " + hello.hashCode());

        instance.sayOK();
        hello.sayOK();
    }
}

enum Singleton{
    /**
     * 春天
     */
    INSTANCE("春天",1),
    /**
     * 夏天
     */
    HELLO("夏天",2);

    private Singleton(String name,Integer id){
        this.name = name;
        this.id = id;
    }

    private String name;
    private Integer id;

    public void sayOK(){
        System.out.println("ok~");
    }
}
