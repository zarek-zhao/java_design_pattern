package com.zarek.builder.pro;
/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */

public class Main {
    public static void main(String[] args)
    {
        try {
            Decorator d;
//            d = (Decorator) ReadXML.getObject();
//            d = new ConcreteDecorator1();
            d = new ConcreteDecorator2();
            ProjectManager m = new ProjectManager(d);
            Parlour p = m.decorate();
            p.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

//产品：客厅
class Parlour {
    private String wall;    //墙
    private String tv;    //电视
    private String sofa;    //沙发

    public void setWall(String wall)
    {
        this.wall = wall;
    }

    public void setTV(String tv)
    {
        this.tv = tv;
    }

    public void setSofa(String sofa)
    {
        this.sofa = sofa;
    }

    public void show()
    {

        System.out.println("建造者模式测试");

        String parlour = wall + tv + sofa;
        System.out.println(parlour);
    }
}

//抽象建造者：装修工人
abstract class Decorator {
    //创建产品对象
    protected Parlour product = new Parlour();

    public abstract void buildWall();

    public abstract void buildTV();

    public abstract void buildSofa();

    //返回产品对象
    public Parlour getResult()
    {
        return product;
    }
}

//具体建造者：具体装修工人1
class ConcreteDecorator1 extends Decorator {
    @Override
    public void buildWall()
    {
        product.setWall("w1");
    }

    @Override
    public void buildTV()
    {
        product.setTV("TV1");
    }

    @Override
    public void buildSofa()
    {
        product.setSofa("sf1");
    }
}

//具体建造者：具体装修工人2
class ConcreteDecorator2 extends Decorator {
    @Override
    public void buildWall()
    {
        product.setWall("w2");
    }

    @Override
    public void buildTV()
    {
        product.setTV("TV2");
    }

    @Override
    public void buildSofa()
    {
        product.setSofa("sf2");
    }
}

//指挥者：项目经理
class ProjectManager {
    private Decorator builder;

    public ProjectManager(Decorator builder)
    {
        this.builder = builder;
    }

    //产品构建与组装方法
    public Parlour decorate()
    {
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }

    //产品构建与组装方法
    public Parlour decorate1()
    {
        builder.buildWall();
        builder.buildSofa();
        return builder.getResult();
    }

}

//class ReadXML {
//    public static Object getObject()
//    {
//        try {
//            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = dFactory.newDocumentBuilder();
//            Document doc;
//            doc = builder.parse(new File("designpattern/src/main/java/com/zarek/builder/pro/config.xml"));
//            NodeList nl = doc.getElementsByTagName("className");
//            Node classNode = nl.item(0).getFirstChild();
//            String cName = classNode.getNodeValue();
//            System.out.println("新类名：" + cName);
//            Class<?> c = Class.forName(cName);
//            Object obj = c.newInstance();
//            return obj;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}