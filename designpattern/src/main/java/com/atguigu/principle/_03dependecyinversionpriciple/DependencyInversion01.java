package com.atguigu.principle._03dependecyinversionpriciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class DependencyInversion01 {
    public static void main(String[] args)
    {
        Person person = new Person();
        person.receive(new Email());
        person.receiveWeChat(new WeChat());
    }
}

class Email{
    public String getInfo(){
        return "电子邮件信息：hello,world";
    }
}

class WeChat{
    public String getInfo(){
        return "微信信息: hello,world";
    }
}

class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }

    public void receiveWeChat(WeChat weChat){
        System.out.println(weChat.getInfo());
    }
}
