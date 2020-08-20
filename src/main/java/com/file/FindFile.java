package com.file;

import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 通过关键字  搜索文件中的包含该关键字的行  并打印
 */
public class FindFile {
    public static void main(String[] args) {
        findFile();
    }
    public static void findFile(){
        System.out.println("输入关键字" );
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine( );
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("L:\\test.txt");
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder(  );
            String temp = null;
            while((temp = bufferedReader.readLine())!=null) {
                sb.append(temp+"\n");
            }
            String[] rows = sb.toString( ).split("\n");
            for(String s : rows) {
                if(s.contains(input)){
                    System.out.println(s );
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        } catch (IOException e) {
            e.printStackTrace( );
        } finally {
            try {
                if(fileReader!=null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace( );
            }
            try {
                if(bufferedReader!=null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace( );
            }
        }
    }
}
