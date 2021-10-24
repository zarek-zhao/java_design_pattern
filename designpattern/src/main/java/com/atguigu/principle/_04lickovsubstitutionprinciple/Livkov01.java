package com.atguigu.principle._04lickovsubstitutionprinciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Livkov01 {
    public static void main(String[] args)
    {
        A a = new A();
        System.out.println("11 - 3 ="+a.func1(11,3));
        System.out.println("1 - 8 ="+a.func1(1,8));
        B b = new B();
        System.out.println("11 - 3 ="+b.func1(11,3));
        System.out.println("1 - 8 ="+b.func1(1,8));
        System.out.println("11 + 3 + 9 ="+b.func2(11,3));
    }
}


class A {
    public int func1(int num1, int num2)
    {
        return num1 - num2;
    }
}

class B extends A{
    public int func1(int num1, int num2)
    {
        return num1+num2;
    }

    public int func2(int num1,int num2){
        return func1(num1,num2)+9;
    }
}
