package com.zarek.factory.abstractfactory;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */

public class FarmTest {
    public static void main(String[] args)
    {
        Farm farm = new SGfarm();
        Animal animal = farm.newAnimal();
        Plant plant = farm.newPlant();

        animal.show();
        plant.show();
    }
}

interface Animal {
    void show();
}

class Horse implements Animal {

    @Override
    public void show()
    {
        System.out.println("马");
    }
}

class Cattle implements Animal {
    @Override
    public void show()
    {
        System.out.println("牛");
    }
}

interface Plant {
    void show();
}

class Fruitage implements Plant {

    @Override
    public void show()
    {
        System.out.println("水果");
    }
}

class Vegetables implements Plant {

    @Override
    public void show()
    {
        System.out.println("蔬菜");
    }
}

interface Farm {
    Animal newAnimal();

    Plant newPlant();
}

//具体工厂：韶关农场类
class SGfarm implements Farm {
    @Override
    public Animal newAnimal()
    {
        System.out.println("新牛出生！");
        return new Cattle();
    }

    @Override
    public Plant newPlant()
    {
        System.out.println("蔬菜长成！");
        return new Vegetables();
    }
}

//具体工厂：上饶农场类
class SRfarm implements Farm {
    @Override
    public Animal newAnimal()
    {
        System.out.println("新马出生！");
        return new Horse();
    }

    @Override
    public Plant newPlant()
    {
        System.out.println("水果长成！");
        return new Fruitage();
    }
}