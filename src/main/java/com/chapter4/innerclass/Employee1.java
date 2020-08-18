package com.chapter4.innerclass;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class Employee1 implements Comparable<Employee1> {

    private int id;
    private String name;
    private int age;

    public Employee1(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee1 o) {
//        if(id > o.id) {
//            return 1;
//        } else if(id < o.id) {
//            return -1;
//        }
//        return 0;
        // 依次单个增加域，对每个域进行比较
        return new CompareToBuilder().append(id, o.id).append(name, o.name).append(age, o.age).toComparison();
        // 通过反射自动获取每个域 进行比较，java14  已经移除该功能。
//        return new CompareToBuilder().reflectionCompare(this, o);
    }
}
