package com.zarek.prototype;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 * 原型模式
 *
 *
 *
 *
 *
 *
 * 原型模式的克隆分为浅克隆和深克隆。
 * 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 * 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Person person = new Person();
        person.setAge(12);
        person.setName("赵云");
        IdCard idCard = new IdCard("360681198704089017", "常山");
        person.setIdCard(idCard);

        Person clonePerson = (Person) person.clone();

        idCard.setProvince("长坂坡");

        System.out.println("clonePerson.toString() = " + clonePerson.toString());
    }
}

class Person implements Cloneable{
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

class IdCard implements Cloneable{
    private String number;
    private String province;

    public IdCard(){}

    public IdCard(String number,String province){
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
