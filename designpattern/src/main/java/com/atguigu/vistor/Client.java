package com.atguigu.vistor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Client {

   public static void main(String[] args)
    {
        SetMaterial setMaterial = new SetMaterial();

        setMaterial.add(new Paper());
        setMaterial.add(new Tong());

        setMaterial.accept(new ArtCompany());

        setMaterial.accept(new MoneyCompany());
    }

}

class SetMaterial{
    private List<Material> list = new ArrayList<>();

    void add(Material material)
    {
        list.add(material);
    }

    void remove(Material material)
    {
        list.remove(material);
    }

    void accept(Company company){

        list.forEach(x->{
            x.show(company);
        });
    }
}

interface Company {
    void create(Paper paper);

    void create(Tong tong);
}

class ArtCompany implements Company{

    @Override
    public void create(Paper paper)
    {
        System.out.println("艺术公司用 纸张 画出图画");
    }

    @Override
    public void create(Tong tong)
    {
        System.out.println("艺术公司用 铜画出 铜画");
    }
}

class MoneyCompany implements Company{


    @Override
    public void create(Paper paper)
    {
        System.out.println("造币公司用 纸张 印出纸币");
    }

    @Override
    public void create(Tong tong)
    {
        System.out.println("造币公司用 铜 造出铜币");
    }
}

interface Material {
    void show(Company company);
}

class Paper implements Material {

    @Override
    public void show(Company company)
    {
        System.out.println("我是纸张");
        company.create(this);
    }
}

class Tong implements Material {

    @Override
    public void show(Company company)
    {
        System.out.println("我是铜");
        company.create(this);
    }
}