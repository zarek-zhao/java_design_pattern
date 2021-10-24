package com.atguigu.principle._03dependecyinversionpriciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args)
    {
        A a = new A() {
            @Override
            void say()
            {
                System.out.println("hllll");
            }
        };
        a.say();
    }
}

abstract class A{
    void hello()
    {
        say();
    }

    void say(){
        System.out.println("hello java");
    }
}

class B extends A{
    @Override
    public void say(){
        System.out.println("hello world");
    }
}


