package com.chapter3;

public class Test {
    public static void main(String[] args) {
        Address address = new Address("中国", "吉林", "长春");
        Employee employee1 = new Employee("明日科技",12,address);
        System.out.println("员工1 的信息" );
        System.out.println(employee1 );

        System.out.println("克隆后：" );
        Employee employee2 = employee1.clone();
        employee2.getAddress().setState("中国");
        employee2.getAddress().setProvince("四川");
        employee2.getAddress().setCity("成都");
        employee2.setName("西南交通大学");
        System.out.println("员工2的信息" );
        System.out.println(employee2 );
        System.out.println("员工1的信息" );
        System.out.println(employee1 );


        Login login = new Login("梁涛", "pass");
        System.out.println(login );

        Login login1 = login.clone();
        System.out.println(login1 );
        System.out.println(login );
    }
}
