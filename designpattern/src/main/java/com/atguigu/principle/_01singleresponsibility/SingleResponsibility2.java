package com.atguigu.principle._01singleresponsibility;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class SingleResponsibility2 {
    public static void main(String[] args)
    {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("自行车");
        roadVehicle.run("摩托车");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
    }
}

/**
 * 方案2的分析
 * 1. 遵守单一职责原则
 * 2. 但是这样做的改动很大，即将类分解，同时要修改客户端
 */

/**
 * 路上交通工具类
 */
class RoadVehicle {
    public void run(String vehicle)
    {
        System.out.println(vehicle + " 在公路上运行");
    }
}

/**
 * 空中交通工具类
 */
class AirVehicle {
    public void run(String vehicle)
    {
        System.out.println(vehicle + " 在天空上运行");
    }
}

/**
 * 水上交通工具类
 */
class WaterVehicle {
    public void run(String vehicle)
    {
        System.out.println(vehicle + " 在水上运行");
    }
}