package com.atguigu.principle._03dependecyinversionpriciple;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class DependencyInversion02 {
    public static void main(String[] args)
    {
        PersonPro personPro = new PersonPro();
        personPro.receive(new EmailPro());
        personPro.receive(new WeChatPro());
    }
}

interface Message{
    /**
     * 获取信息
     * @return
     */
    String getInfo();
}

class WeChatPro implements Message{
    @Override
    public String getInfo()
    {
        return "微信信息: hello,world";
    }
}

class EmailPro implements Message{

    @Override
    public String getInfo()
    {
        return "电子邮件信息：hello,world";
    }
}

class PersonPro{
    public void receive(Message message){
        System.out.println(message.getInfo());
    }
}