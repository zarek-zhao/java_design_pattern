package com.zarek.adapter.classmodel;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args)
    {
        Target target = new ClassAdapter();
        target.request();
    }
}


/**
 * 适配者：已经存在的组件
 */
class Adaptee {
    void specificRequest()
    {
        System.out.println("已经存在的指定功能的方法");
    }
}

interface Target {
    /**
     * 目前需要的功能
     */
    void request();
}

class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request()
    {
        System.out.println("调用前，做点其他事情");
        specificRequest();
        System.out.println("调用后，再做点其他事情");
    }
}
