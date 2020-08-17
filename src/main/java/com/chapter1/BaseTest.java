package com.chapter1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class BaseTest {
    public static void main(String[] args) {

    }
    public static void test(){

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
}
