package com.chapter3;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringDemo {

    private static final String STR_UNIT[] = {"","拾","佰","仟","万","拾","佰","仟","亿"};
    private static final String STR_NUMBER[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    public static void main(String[] args) {
        test();   
//        Scanner scanner = new Scanner(System.in);
//        double v = scanner.nextDouble( );
//        System.out.println(convert(v) );
    }
    public static void test() {
        String s1 = "";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(  );
        try {
            System.setErr(new PrintStream(byteArrayOutputStream));
            Integer integer = Integer.valueOf("sdfafef");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        s1 = byteArrayOutputStream.toString( );
        if(s1.isEmpty()) {
            System.out.println("未发生异常" );
        }else{
            System.out.println("出错了" + s1);
        }
        System.nanoTime();
    }
    public static void test5(){
        String str = "很多要用到正则表达式的都直接百度，像上次要用正则表达式验证是否是合法的ip";
        int amount=0;
        for (int i = 0; i < str.length(); i++) {
            boolean matches = Pattern.matches("^[\u4E00-\u9FA5]$", str.charAt(i) + "");
            if(matches) {
                amount++;
            }
        }
        System.out.println(amount );
    }
    public static void test4(){
        String ip = "192.12.12.12";
        if(ip.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."

                +"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$")) {
            System.out.println(ip );
            StringBuilder stringBuilder = new StringBuilder(ip);
            String s = stringBuilder.reverse( ).toString( );
            System.out.println(s );
        }
    }
    public static void test3(){
        boolean digits = NumberUtils.isNumber("123.0");
        boolean digits1 = NumberUtils.isDigits("123.0");
        System.out.println(digits +"\t"+ digits1);
    }
    public static void test2(){
        // string -> unicode        将字母强制转换为整数类型
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray( );
        StringBuilder stringBuilder = new StringBuilder( );
        for(char c : chars) {
            stringBuilder.append((int)c+" ");
        }
        System.out.println(stringBuilder.toString() );
        // unicode -> string
        // 强制转换成char类型，就能得到对应的编码字符
    }
    public static void test1(){
        Date today = new Date(  );
        String[] str = {"b","H","I","l","M","S","L","N","p","z","Z","s","Q"};
        for (int i = 0; i < str.length; i++) {
            String string = String.format(Locale.US, "%t"+str[i], today);
            System.out.println( str[i] +"\t"+string);
        }
    }
    private static String convert(double d){
        DecimalFormat df = new DecimalFormat( "#0.###" );
        String strNum = df.format(d);
        // 判断是否包含小数
        if(strNum.indexOf(".")!=-1) {
            String num = strNum.substring(0, strNum.indexOf("."));
            // 整数部分大于12 不能转换
            if(num.length()>12) {
                System.out.println("数字太大， 不能转换" );
            }
        }
        String point = "";
        if(strNum.indexOf(".")!=-1){
            point = "元";
        }else{
            point = "元整";
        }
        String integer = getInteger(strNum) + point + getDecimal(strNum);
        if(integer.startsWith("元")) {
            integer = integer.substring(1, integer.length());
        }
        return integer;
    }

    /**
     * 小数点前的部分
     * @param num
     * @return
     */
    private static String getInteger(String num){
        if (num.indexOf(".") != -1){
            num = num.substring(0, num.indexOf("."));
        }
        num = new StringBuffer(num ).reverse().toString();
        StringBuffer stringBuffer = new StringBuffer( );
        for (int i = 0; i < num.length(); i++) {
            stringBuffer.append(STR_UNIT[i]);
            stringBuffer.append(STR_NUMBER[num.charAt(i)-48]);
        }
        num = stringBuffer.reverse().toString();
        num = num.replace("零拾", "零");
        num = num.replace("零佰", "零");
        num = num.replace("零仟", "零");
        num = num.replace("零万", "万");
        num = num.replace("零亿", "亿");
        num = num.replace("零零", "零");
        num = num.replace("亿万", "亿");
        if(num.lastIndexOf("零") == num.length()-1){
            num = num.substring(0, num.length()-1);
        }
        return num;
    }

    /**
     * 小数点后的部分
     * @param num
     * @return
     */
    public static String getDecimal(String num){
        if (num.indexOf(".") != -1){
            num = num.substring(num.indexOf(".")+1);
            StringBuffer temp = new StringBuffer();
            temp.append(STR_NUMBER[num.charAt(0)-48]);
            temp.append("角");
            if(num.length()!=1) {
                temp.append(STR_NUMBER[num.charAt(1) - 48]);
                temp.append("分");
            }
            return  temp.toString();
        }
        return "";
    }
    public void formatDate(){
        Date date = new Date(  );
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        String string = dateFormat.format(date);
        System.out.println(string );
    }
    public void formatAmount(){
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble( );
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println(format.format(number) );
        format = NumberFormat.getCurrencyInstance(Locale.US );
        System.out.println(format.format(number) );
        format = NumberFormat.getCurrencyInstance(Locale.ENGLISH );
        System.out.println(format.format(number) );
//        123
//        ¥123.00
//        $123.00
//        ¤123.00
    }
}
