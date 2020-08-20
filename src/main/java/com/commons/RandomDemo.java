package com.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        String s = sevenStartNum(5);
        System.out.println(s );
        String brings = brings(5);
        System.out.println(brings );
    }

    /**
     * 大乐透号码生成器
     * @param times 组数
     * @return
     */
    private static String brings(int times){
        StringBuilder sb = new StringBuilder(  );
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < 5; j++) {// 35选5
                List<Integer> list = new ArrayList<>( );
                for (int k = 1; k < 36; k++) {
                    list.add(k);
                }
                Integer number = list.get(new Random( ).nextInt(list.size( )));
                String luckNumber = number < 10 ? "0" + number : "" + number;
                sb.append(luckNumber+" ");
                list.remove(new Integer(number));// 删除选过的数字
            }
            sb.append("\t\t");
            for (int j = 0; j < 2; j++) {
                List<Integer> list = new ArrayList<>( );
                for (int k = 1; k < 13; k++) {
                    list.add(k);
                }
                Integer number = list.get(new Random( ).nextInt(list.size( )));
                String luckNumber = number < 10 ? "0" + number : "" + number;
                sb.append(luckNumber+" ");
                list.remove(new Integer(number));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * 生成七星彩号码
     * @param num 组数
     * @return
     */
    private static String sevenStartNum(int num){
        StringBuilder sb = new StringBuilder(  );
        for (int i = 0; i < num; i++) {
            int number = new Random( ).nextInt((int) Math.pow(10, 7));
            String luckNumber = "" +number;
            while (luckNumber.length()<7) {
                luckNumber = "0" + luckNumber;
            }
            sb.append(luckNumber+"\n");
        }
        return sb.toString();
    }
}
