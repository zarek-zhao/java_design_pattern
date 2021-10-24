package com.atguigu.principle._06demeterprinciple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class DemeterPrinciple {
    public static void main(String[] args)
    {
        CompanyManager companyManager = new CompanyManager();
        companyManager.printAllEmployee(new SubCompanyManager1());
    }
}


class Employee {
    private Integer id;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                '}';
    }
}

class SubCompanyEmployee {
    private Integer id;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "SubCompanyEmployee{" +
                "id=" + id +
                '}';
    }
}

interface SubCompanyManagerInterface {
    /**
     * 获取公司的所有员工信息
     *
     * @return
     */
    List<SubCompanyEmployee> getAllEmployee();

    /**
     * 打印出公司的所有员工信息
     */
    void printAllEmployee();
}

class SubCompanyManager implements SubCompanyManagerInterface{
    @Override
    public List<SubCompanyEmployee> getAllEmployee()
    {
        List<SubCompanyEmployee> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            SubCompanyEmployee emp = new SubCompanyEmployee();
            emp.setId(i);
            list.add(emp);
        }
        return list;
    }

    @Override
    public void printAllEmployee()
    {
        List<SubCompanyEmployee> subEmployees = this.getAllEmployee();
        for (SubCompanyEmployee subEmployee : subEmployees) {
            System.out.println("subEmployee = " + subEmployee);
        }
    }
}

class SubCompanyManager1 implements SubCompanyManagerInterface{
    @Override
    public List<SubCompanyEmployee> getAllEmployee()
    {
        List<SubCompanyEmployee> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            SubCompanyEmployee emp = new SubCompanyEmployee();
            emp.setId(i);
            list.add(emp);
        }
        return list;
    }

    @Override
    public void printAllEmployee()
    {
        List<SubCompanyEmployee> subEmployees = this.getAllEmployee();
        for (SubCompanyEmployee subEmployee : subEmployees) {
            System.out.println("sub1Employee = " + subEmployee);
        }
    }
}

class CompanyManager {
    public List<Employee> getAllEmployee()
    {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Employee emp = new Employee();
            emp.setId(i);
            list.add(emp);
        }
        return list;
    }

    public void printAllEmployee(SubCompanyManagerInterface subCompanyManager)
    {
        subCompanyManager.printAllEmployee();

        List<Employee> Employee = this.getAllEmployee();
        for (Employee employee : Employee) {
            System.out.println("employee = " + employee);
        }
    }
}

