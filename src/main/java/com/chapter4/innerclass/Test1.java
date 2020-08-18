package com.chapter4.innerclass;

import com.chapter4.strategy.ImageSaver;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Employee1 employee1 = new Employee1(3, "Java", 1);
        Employee1 employee2 = new Employee1(2, "PHP", 2);
        Employee1 employee3 = new Employee1(1, "Ruby", 3);
        Employee1[] employee1s = new Employee1[3];
        employee1s[0] = employee1;
        employee1s[1] = employee2;
        employee1s[2] = employee3;
        System.out.println("排序前：" );
        for (Employee1 e: employee1s) {
            System.out.println(e );
        }
        System.out.println("排序后：" );
        Arrays.sort(employee1s );
        for (Employee1 e: employee1s) {
            System.out.println(e );
        }


// 策略模式
        ImageSaver imageSaver = TypeChooser.getSaver("gif");
        imageSaver.save();
        imageSaver = TypeChooser.getSaver("jpeg");
        imageSaver.save();
        imageSaver = TypeChooser.getSaver("png");
        imageSaver.save();
    }
}
