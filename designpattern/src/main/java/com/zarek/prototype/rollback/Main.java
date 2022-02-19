package com.zarek.prototype.rollback;

import java.util.ArrayList;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException
    {
        BackBak backBak = new BackBak();
        Person person = new Person();
        System.out.println("初始化对象");
        backBak.bak((Person) person.clone());
        System.out.println("给对象赋值");
        person.setAge(12);
        person.setName("李白");
        person.setIdCard(new IdCard("3450489583945843", "浙江省"));
        backBak.bak((Person) person.clone());
        System.out.println("改变对象的名字");
        person.setName("杜甫");

        System.out.println("person的当前状态" + person);

        person = backBak.rollback(person);
        backBak.rollback(person);


    }
}


class Person implements Cloneable {
    private String name;
    private Integer age;
    private IdCard idCard;


    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public void setIdCard(IdCard idCard)
    {
        this.idCard = idCard;
    }

    public String getName()
    {
        return name;
    }

    public Integer getAge()
    {
        return age;
    }

    public IdCard getIdCard()
    {
        return idCard;
    }

    //    浅克隆
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

////        深克隆
//    @Override
//    protected Object clone() throws CloneNotSupportedException
//    {
//        Person person = (Person) super.clone();
//        person.setIdCard((IdCard) person.getIdCard().clone());
//        return person;
//    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", idCard=" + idCard +
                '}';
    }
}

class IdCard implements Cloneable {
    private String number;
    private String province;

    public IdCard()
    {
    }

    public IdCard(String number, String province)
    {
        this.number = number;
        this.province = province;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString()
    {
        return "IdCard{" +
                "number='" + number + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}


class BackBak {
    ArrayList<Person> personArrayList = new ArrayList<>(10);
    int initPointer = 0;

    void bak(Person person) throws CloneNotSupportedException
    {
        System.out.println("person的当前状态 " + person);
        System.out.println("执行备份操作");
        Person clone = (Person) person.clone();
        personArrayList.add(clone);
        initPointer++;
//        System.out.println("备份的 Person 状态为 " + clone);
    }

    Person rollback(Person person)
    {
        System.out.println("执行撤销回滚操作");
        Person person1 = personArrayList.get(--initPointer);
        System.out.println("当前的 Person 状态为 " + person1);
        return person1;
    }
}