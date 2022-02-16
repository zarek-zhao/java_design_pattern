package com.zarek.singleton.enumtype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public enum Singleton {
    /**
     * 春天实例
     */
    SPRING("春天", 1);

    private String name;
    private Integer code;

    Singleton(String name, int i)
    {
        setName(name);
        setCode(i);
    }

    public Integer getCode()
    {
        return this.code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

class Main{
    public static void main(String[] args)
    {

        Singleton s = Singleton.SPRING;

        System.out.println("Singleton.SPRING.code = " + s.getCode());

        System.out.println(123);
    }
}
