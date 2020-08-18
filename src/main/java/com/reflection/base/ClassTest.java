package com.reflection.base;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Date;

/**
 * 获取类型的基本信息
 */
public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {





        /**
         * 查看类的声明
         */
//        Class c1 = new Date(  ).getClass();
//        Class<Boolean> booleanClass = boolean.class;
//        Class nlass = Class.forName("com.reflection.base.ClassTest");
//        Class<Double> type = Double.TYPE;
//
//        String name = type.getName( );

        Class<?> aClass = Class.forName("java.util.ArrayList");
        System.out.println(aClass.getCanonicalName() );// 类的标准名称
        System.out.println(Modifier.toString(aClass.getModifiers()) );// 类的修饰符
        System.out.println("类的泛型参数" );
        // 类的泛型参数
        TypeVariable<? extends java.lang.Class<?>>[] typeParameters = aClass.getTypeParameters( );
        if(typeParameters.length!=0) {
            for(TypeVariable<? extends java.lang.Class<?>> t : typeParameters) {
                System.out.println(t+"\t" );
            }
        }else{
            System.out.println("空" );
        }

        // 输出类所实现的所有接口
        Type[] interfases = aClass.getGenericInterfaces();
        System.out.println("类所实现的接口" );
        if(interfases.length!=0) {
            for(Type t : interfases) {
                System.out.println(t );
            }
        }else {
            System.out.println("空" );
        }
        // 输出类的直接继承类， 如果继承自Object则返回空
        Type superClass = aClass.getGenericSuperclass();
        System.out.println("类的直接继承类" );
        if(superClass != null) {
            System.out.println(superClass );
        }else{
            System.out.println("空" );
        }
        // 输出类的所有注释信息，有些注释信息是不能用反射获取的
        Annotation[] annotations = aClass.getAnnotations();
        System.out.println("类的注解" );
        if(annotations.length!=0) {
            for (Annotation a :
                    annotations) {
                System.out.println(a );
            }
        }else{
            System.out.println("空" );
        }
        /**
         * 查看类的成员
         */
        Constructor<?>[] constructors = aClass.getConstructors( );
        if(constructors.length!=0){
            for(Constructor constructor : constructors) {
                System.out.println(constructor );
            }
        }
        Field[] declaredFields = aClass.getDeclaredFields( );
        if(declaredFields.length!=0) {
            for(Field field : declaredFields) {
                System.out.println(field );
            }
        }
        Method[] declaredMethods = aClass.getDeclaredMethods( );
        if(declaredMethods.length!=0) {
            for(Method method : declaredMethods) {
                System.out.println(method );
            }
        }
    }
}
