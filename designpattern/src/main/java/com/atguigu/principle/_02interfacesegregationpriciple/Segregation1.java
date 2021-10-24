package com.atguigu.principle._02interfacesegregationpriciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Segregation1 {
    public static void main(String[] args)
    {
        A a = new A();
        a.depend1(new B());
        C c = new C();
        c.depend1(new D());
    }
}

interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
    void operation5();
}

class B implements Interface1{

    @Override
    public void operation1()
    {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2()
    {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3()
    {
        System.out.println("B 实现了 operation3");
    }

    @Override
    public void operation4()
    {
        System.out.println("B 实现了 operation4");
    }

    @Override
    public void operation5()
    {
        System.out.println("B 实现了 operation5");
    }
}

class D implements Interface1{

    @Override
    public void operation1()
    {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation2()
    {
        System.out.println("D 实现了 operation2");
    }

    @Override
    public void operation3()
    {
        System.out.println("D 实现了 operation3");
    }

    @Override
    public void operation4()
    {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5()
    {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A 类通过接口Interface1 依赖（使用）B 类，但是只会用到1，2，3方法
 */
class A {
    public void depend1(Interface1 interface1){
        interface1.operation1();
        interface1.operation2();
        interface1.operation3();
    }
}

class C {
    public void depend1(Interface1 interface1){
        interface1.operation1();
        interface1.operation4();
        interface1.operation5();
    }
}