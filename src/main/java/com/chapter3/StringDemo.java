package com.chapter3;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class StringDemo {

    private static final String STR_UNIT[] = {"","拾","佰","仟","万","拾","佰","仟","亿"};
    private static final String STR_NUMBER[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double v = scanner.nextDouble( );
        System.out.println(convert(v) );
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
