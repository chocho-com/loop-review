package com.chocho.model;
//学生实体类
public class Student {
    private int number;
    private String name;
    private String sex;
    private int age;

    //测试时使用的构造方法
    public Student(int number, String name, String sex, int age){
        this.number = number;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    //继承使用父类（Object）的构造方法
    public Student(){
        super();
    }
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
