package com.chapter1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class BaseTest {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        // 死循环
        int end = Integer.MAX_VALUE;
        int start = end - 50;
        int count = 0;
        for (int i = start; i <= end ; i++) {
            count++;
            System.out.println("本次循环次数：" + count );
        }
    }

    public static void test1(){
        System.err.println( );
        new Scanner(System.in);
        PrintStream out = System.out;
        PrintStream printStream = null;
        try {
            printStream = new PrintStream("");
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        }
        System.setOut(printStream);
    }
    public static void test2(){
        // 类型转换
        byte b = 127;
        char c = 'W';
        short s = 23561;
        int i = 3333;
        long l = 400000L;
        float f = 3.14159F;
        double d = 54.523;
        // 低 -> 高
        System.out.println("累加byte等于：" + b);
        System.out.println("累加byte等于：" + (b+c));
        System.out.println("累加byte等于：" + (b+c+s));
        System.out.println("累加byte等于：" + (b+c+s+i));
        System.out.println("累加byte等于：" + (b+c+s+i+l));
        System.out.println("累加byte等于：" + (b+c+s+i+l+f));
        System.out.println("累加byte等于：" + (b+c+s+i+l+f+d));
        // 高 -> 低
        System.out.println((int)l );
        System.out.println((short)l );
        System.out.println((int)d );
        System.out.println((char)s );
    }
    public static void test3(){
        // 异或加密
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine( );
        char[] chars = s.toCharArray( );
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] ^ 20000);
        }
        System.out.println("加密结果如下：" );
        System.err.println(new String(chars) );
//        1234567890
//        加密结果如下：
//        丑丒专且丕世丗丘丙丐

//        丑丒专且丕世丗丘丙丐
//        1234567890
    }
    public static void test4(){
        // 更精确的浮点
        double money = 2;
        double price = 1.1;
        double result = money - price;
        System.out.println("非精确的计算" );
        System.out.println("剩余金额："+result );
        // 精确的浮点计算
        BigDecimal money1 = new BigDecimal("2");
        BigDecimal price1 = new BigDecimal("1.1");
        BigDecimal result1 = money1.subtract(price1);
        System.out.println("精确计算：" );
        System.out.println("胜于金额："+result1 );

    }
    public static void test5(int n){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt( );
        System.out.println(""+(i<<n));
        // 返回 i * 2的n次方
    }
    public static void test6(){
        // 两个变量互换
        int a = 2;
        int b = 4;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println(a+"\t"+b );
    }
    public static void test7(){
        // 闰年：能被4整除但不能被100整除   ||    能被400整除
//        year % 4 == 0 && year % 100 != 0 || year % 400 == 0
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt( );
//        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        String s = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? "true" : "false";
        System.out.println(s );
    }
    public static void test8(){
        // 杨辉三角
        // 注意  内层循环要以triangle[i] 为基本数组，切勿丢失[i]
        int[][] triangle = new int[8][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i+1];
            for (int j = 0;j<= triangle[i].length-1;  j++) {
                if(i==0||j==0||j== triangle[i].length-1){
                    triangle[i][j] = 1;
                }else{
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
                System.out.print(triangle[i][j] + "\t" );
            }
            System.out.println( );
        }
    }
    public static void test9(){
        // 计算1+1/2!+1/3!+...+1/20!
        BigDecimal sum = new BigDecimal(0.0);
        BigDecimal factorail = new BigDecimal(1.0); // 循环增量
        int i = 1;
        while(i<=20) {
            sum = sum.add(factorail);
            ++i;
            factorail = factorail.multiply(new BigDecimal(1.0/i));
        }
        System.out.println(sum );

//        double sum = 0.0;
//        double fa = 1.0;
//        int i = 1;
//        while(i <= 20) {
//            sum += fa;
//            i++;
//            fa *= 1/i;
//        }
//        System.out.println(sum );  sum = 1.0      计算结果不准
    }
    public static void test10(int size){
        // 空心菱形
        if(size % 2 == 0){
            size++;
        }
        for (int i = 0; i < size/2+1; i++) {
            for (int j = size/2+1; j > i+1; j--) {
                System.out.print(" " );
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                if(j==0 || j == 2*i) {
                    System.out.print("*" );
                }else{
                    System.out.print(" " );
                }
            }
            System.out.println( );
        }
        for (int i = size/2+1; i < size; i++) {
            for (int j = 0; j < i - size/2; j++) {
                System.out.print(" " );
            }
            for (int j = 0; j < 2 * size - 1 - 2*i; j++) {
                if(j==0 || j == 2*(size-i-1)) {
                    System.out.print("*" );
                }else{
                    System.out.print(" " );
                }
            }
            System.out.println( );
        }
    }
}
