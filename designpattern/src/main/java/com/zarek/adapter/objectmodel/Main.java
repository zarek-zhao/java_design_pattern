package com.zarek.adapter.objectmodel;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * 类模式
 */
public class Main {
    public static void main(String[] args)
    {
        Target target = new ClassAdapter(new Adaptee());
        target.request();
    }

}


class Adaptee {
    void specificRequest()
    {
        System.out.println("已经存在的组件方法");
    }
}

interface Target {
    void request();
}

class ClassAdapter implements Target {
    private Adaptee adaptee;

    public ClassAdapter(Adaptee adaptee)
    {
        this.adaptee = adaptee;
    }


    @Override
    public void request()
    {
        System.out.println("调用前，做点其他事情");
        adaptee.specificRequest();
        System.out.println("调用后，再做点其他事情");
    }
}

