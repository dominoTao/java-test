package com.commons;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * 创建线程 输出虚拟机当前时间 每隔一秒钟
 */
public class ClockRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println(getTime() );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace( );
            }
        }
    }

    /**
     * 查看本地时区
     */
    private static void localTimeZone(){
        TimeZone zone = TimeZone.getDefault();// 获取当前时区
        System.out.println("当前主机所在时区："+zone.getDisplayName() );
        TimeZone taibei = TimeZone.getTimeZone("Asia/Taipei");
        System.out.println("中国台北所在时区："+taibei.getDisplayName() );
        System.out.println("中国台北时区的完整名称："+taibei.getDisplayName(true, TimeZone.LONG) );
        System.out.println("中国台北时区的缩写名称："+taibei.getDisplayName(true, TimeZone.SHORT) );
        System.out.println("中国时区的完整名称："+zone.getDisplayName(true, TimeZone.LONG) );
        System.out.println("中国时区的缩写名称："+zone.getDisplayName(true, TimeZone.SHORT) );
    }

    /**
     * 我的生日
     */
    private static void myBirthday(){
        System.out.println("输入生日，格式如：1995-06-30" );
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine( );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
        Calendar birthday = new GregorianCalendar(  );
        try {
            birthday.setTime(simpleDateFormat.parse(input));

        } catch (ParseException e) {
            e.printStackTrace( );
        }
        Calendar today = new GregorianCalendar(  );
        int age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
        String[] weekdays = new DateFormatSymbols( ).getWeekdays( );
        StringBuilder sb = new StringBuilder(  );
        sb.append("生日的星期："+weekdays[birthday.get(Calendar.DAY_OF_WEEK)]+"\n");
        birthday.set(Calendar.YEAR, today.get(Calendar.YEAR));
        sb.append("现在的年龄："+ (birthday.after(today)?age-1:age)+"岁\n");
        sb.append("今年的生日："+weekdays[birthday.get(Calendar.DAY_OF_WEEK)]+"\n");
        System.out.println(sb.toString() );
    }
    private static void updateTable(Calendar calendar) {
        // 获取表示星期的字符串数组
        String[] weeks = new DateFormatSymbols( ).getShortWeekdays( );
        // 用来保存截取后的字符串
        String[] realWeeks = new String[7];
        for (int i = 1; i < weeks.length; i++) {
            // 获取字符串的最后一个字符
            realWeeks[i-1] = weeks[i].substring(2,3);
        }
        int today = calendar.get(Calendar.DATE);// 获取当前日期
        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);// 获取当前月的天数
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 将时间设置为本月的第一天
        int weekday = calendar.get(Calendar.DAY_OF_MONTH);// 获取本月第一天是星期几
        int firstDayOfWeek = calendar.getFirstDayOfWeek( );// 获取当前地区星期的起始日
        int whiteDay = weekday - firstDayOfWeek;// 这个月第一个星期有几天被上个月占用

        Object[][] days = new Object[6][7];// 保存当前月的各天
        for (int i = 1; i <= monthDays; i++) {
            // 一维表示一个月中各个星期   二维表示一个星期中各个天
            days[(i-1+whiteDay)/7][(i-1+whiteDay)%7] = i;
        }
    }
    /**
     * 获取指定格式的日期信息
     * @param increment
     * @return
     */
    private String updateLable(int increment) {
        Calendar calendar = new GregorianCalendar(  );
        // 将当前月份加increment月
        calendar.add(Calendar.MONTH, increment);
        SimpleDateFormat format = new SimpleDateFormat( "yyyy年MM月" );
        return format.format(calendar.getTime());

    }

    private static String getTime(){
        // GregorianCalendar是Calendar的子类，提供了世界上绝大多数国家、地区的标准日历系统
        Calendar calendar = new GregorianCalendar(  );
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        return format(hour) + ":" + format(minute) + ":" + format(second);
    }

    public static void main(String[] args) {
//        Thread thread = new Thread(new ClockRunnable( ));
//        thread.start();
//        Calendar calendar = new GregorianCalendar(  );
//        updateTable(calendar);
//        myBirthday();
        localTimeZone();
    }
    /**
     * 如果数字小于10   则自动补全两位
     * @param number
     * @return
     */
    private static String format(int number) {
        return number < 10 ? "0" + number : ""+number;
    }
}
