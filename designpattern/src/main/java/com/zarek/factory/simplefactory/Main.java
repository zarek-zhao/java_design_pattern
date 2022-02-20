package com.zarek.factory.simplefactory;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 *
 * 简单工厂模式
 *
 * 缺陷：如果要工厂要添加一个产品，则需要修改工厂类
 */
public class Main {
    public static void main(String[] args)
    {
        Product product = SimpleFactory.makeProduct(Const.PRODUCT_A);
        Product product1 = SimpleFactory.makeProduct(Const.PRODUCT_B);

        product.show();

        product1.show();
    }
}

interface Product {
    void show();
}

class ConcreteProductA implements Product {
    @Override
    public void show()
    {
        System.out.println("具体产品A显示");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void show()
    {
        System.out.println("具体产品B显示");
    }
}

final class Const {
    static final int PRODUCT_A = 0;
    static final int PRODUCT_B = 1;
    static final int PRODUCT_C = 2;
}
class SimpleFactory {
    public static Product makeProduct(int kind) {
        switch (kind) {
            case Const.PRODUCT_A:
                return new ConcreteProductA();
            case Const.PRODUCT_B:
                return new ConcreteProductB();
        }
        return null;
    }
}


