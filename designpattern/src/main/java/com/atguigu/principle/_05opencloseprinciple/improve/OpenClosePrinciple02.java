package com.atguigu.principle._05opencloseprinciple.improve;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class OpenClosePrinciple02 {
    public static void main(String[] args)
    {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
    }
}

class GraphicEditor{
    public void drawShape(Shape shape){
        shape.draw();
    }
}


abstract class Shape {
    int m_type;

    /**
     * 抽象方法
     */

    public abstract void draw();
}

class Rectangle extends Shape {
    @Override
    public void draw()
    {
        System.out.println("矩形");
    }
}

class Circle extends Shape {
    @Override
    public void draw()
    {
        System.out.println("圆形");
    }
}

class Triangle extends Shape {
    @Override
    public void draw()
    {
        System.out.println("三角形");
    }
}