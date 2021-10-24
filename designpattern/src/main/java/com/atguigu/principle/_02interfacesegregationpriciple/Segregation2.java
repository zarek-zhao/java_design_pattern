package com.atguigu.principle._02interfacesegregationpriciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Segregation2 {
    public static void main(String[] args)
    {
        AA a = new AA();
        a.depend1(new BB());
        a.depend2(new BB());
        CC c = new CC();
        c.depend1(new DD());
        c.depend3(new DD());
    }
}

interface Interface11 {
    void operation1();
}

interface Interface12 {
    void operation2();

    void operation3();
}

interface Interface13 {
    void operation4();

    void operation5();
}

class BB implements Interface11, Interface12 {

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
}

class DD implements Interface11, Interface13 {

    @Override
    public void operation1()
    {
        System.out.println("D 实现了 operation1");
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

class AA {
    public void depend1(Interface11 interface11)
    {
        interface11.operation1();

    }

    public void depend2(Interface12 interface12)
    {
        interface12.operation2();
        interface12.operation3();
    }
}

class CC {
    public void depend1(Interface11 interface11)
    {
        interface11.operation1();

    }

    public void depend3(Interface13 interface13)
    {
        interface13.operation4();
        interface13.operation5();
    }
}