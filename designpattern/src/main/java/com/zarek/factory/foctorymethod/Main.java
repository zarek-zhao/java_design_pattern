package com.zarek.factory.foctorymethod;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * <p>
 * 工厂方法模式的主要角色如下。
 * 抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 * 具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 * 抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 * 具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 *
 *
 *
 *
 * 优点：
 * 用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。
 * 灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
 * 典型的解耦框架。高层模块只需要知道产品的抽象类，无须关心其他实现类，满足迪米特法则、依赖倒置原则和里氏替换原则。
 * 缺点：
 * 类的个数容易过多，增加复杂度
 * 增加了系统的抽象性和理解难度
 * 抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。
 *
 *
 * 应用场景：
 * 客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
 * 创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
 * 客户不关心创建产品的细节，只关心产品的品牌
 */
public class Main {
    public static void main(String[] args)
    {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        Product product = abstractFactory.newProduct();
        product.show();

        AbstractFactory abstractFactory1 = new ConcreteFactory2();
        Product product1 = abstractFactory1.newProduct();
        product1.show();
    }
}


interface Product {
    void show();
}

class ConcreteProduct1 implements Product {
    @Override
    public void show()
    {
        System.out.println("具体产品1显示...");
    }
}

class ConcreteProduct2 implements Product {
    @Override
    public void show()
    {
        System.out.println("具体产品2显示...");
    }
}

interface AbstractFactory {
    Product newProduct();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public Product newProduct()
    {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product newProduct()
    {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}

