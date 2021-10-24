package com.atguigu.principle._04lickovsubstitutionprinciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Livkov02 {
    public static void main(String[] args)
    {
        AA a = new AA();
        System.out.println("11 - 3 =" + a.func1(11, 3));
        System.out.println("1 - 8 =" + a.func1(1, 8));
        BB b = new BB();
        System.out.println("11 + 3 =" + b.func1(11, 3));
        System.out.println("1 + 8 =" + b.func1(1, 8));
        System.out.println("11 + 3 + 9 =" + b.func2(11, 3));
    }
}

class Base {

}

class AA extends Base {
    public int func1(int num1, int num2)
    {
        return num1 - num2;
    }
}

class BB extends Base {
    // 如果BB类需要AA类的方法，使用组合关系
    private AA a;

    public int func1(int num1, int num2)
    {
        return num1 + num2;
    }

    public int func2(int num1, int num2)
    {
        return func1(num1, num2) + 9;
    }

    public int fun3(int num1, int num2)
    {
        return a.func1(num1, num2);
    }
}
