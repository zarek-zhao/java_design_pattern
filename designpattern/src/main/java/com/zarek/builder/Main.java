package com.zarek.builder;

/**
 * @author zarek
 * @version 1.0.0
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args)
    {
//        User user = new User();
//        user.setName("123");
//        user.setSkill(new Skill("写诗", "喝酒"));
//        user.setAge(12);
//        user.setSchool(new School("私塾", 1));

        User build = new UserBuilder().setAge(12).setName("李白").setSchool(new School("私塾", 1)).setSkill(new Skill("写诗", "喝酒")).build();
        System.out.println("build.toString() = " + build.toString());
    }
}


class UserBuilder {
    private String name;
    private Integer age;

    private School school;
    private Skill skill;

    public UserBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    public UserBuilder setAge(Integer age)
    {
        this.age = age;
        return this;
    }

    public UserBuilder setSchool(School school)
    {
        this.school = school;
        return this;
    }

    public UserBuilder setSkill(Skill skill)
    {
        this.skill = skill;
        return this;
    }

    public User build()
    {
        User user = new User();
        user.setAge(this.age);
        user.setName(this.name);
        user.setSkill(this.skill);
        user.setSchool(this.school);
        return user;
    }
}

class User {
    private String name;
    private Integer age;

    private School school;
    private Skill skill;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public void setSchool(School school)
    {
        this.school = school;
    }

    public void setSkill(Skill skill)
    {
        this.skill = skill;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                ", skill=" + skill +
                '}';
    }
}

class School {
    private String name;
    private Integer level;

    public School(String name, Integer level)
    {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString()
    {
        return "School{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}

class Skill {
    private String attack;
    private String life;

    public Skill(String attack, String life)
    {
        this.attack = attack;
        this.life = life;
    }

    @Override
    public String toString()
    {
        return "Skill{" +
                "attack='" + attack + '\'' +
                ", life='" + life + '\'' +
                '}';
    }
}