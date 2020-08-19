package com.reflection;

import java.lang.reflect.Field;

/**
 * 非法访问异常
 */
public class ExceptionTest {
    public int hash = 1;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class<ExceptionTest> stringClass = ExceptionTest.class;
        Field[] declaredFields = stringClass.getDeclaredFields( );
        for (Field field : declaredFields) {
            if(field.getName().equalsIgnoreCase("hash")) {
                try {
                    System.out.println(field.getInt("hash") );
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    e.printStackTrace( );
                }
            }
        }
        // 正解
        SampleClass sampleObject = new SampleClass();
        Field field = SampleClass.class.getField("sampleField");
        System.out.println(field.getInt(sampleObject));
    }
}
class SampleClass {
    public static int sampleField = 500;
}


