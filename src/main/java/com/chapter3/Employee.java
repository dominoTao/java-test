package com.chapter3;

import java.io.*;

public class Employee implements Cloneable, Serializable {
    private String name;
    private int age;
    private Address address;

    public Employee(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(  );
        sb.append("姓名："+name+",");
        sb.append("年龄："+age+",");
        sb.append("地址："+address);
        return sb.toString();
    }

    @Override
    protected Employee clone() {
        Employee employee = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(  );
        try {
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace( );
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
            employee = (Employee)ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }

        return employee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
