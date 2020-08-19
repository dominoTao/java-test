package com.reflection.base.variableLength;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StringUtil {
    /**
     * 利用反射输出指定对象的所有域成员
     * @return
     */
    public String toString(Object obj){
        Class<?> clazz = obj.getClass( );
        StringBuilder sb = new StringBuilder(  );
        Package pk = clazz.getPackage( );
        sb.append("包名："+pk.getName()+"\t");
        String simpleName = clazz.getSimpleName( );
        sb.append("类名："+simpleName+"\n");
        sb.append("公共的构造方法: \n");
        // 获取所有代表构造方法的Constructor数组
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors( );
        for(Constructor constructor : declaredConstructors) {
            String s = Modifier.toString(constructor.getModifiers( ));
            if(s.contains("public")) {
                sb.append(constructor.toGenericString()+"\n");
            }
        }
        sb.append("公共域：\n");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            String s = Modifier.toString(field.getModifiers( ));
            if(s.contains("public")) {
                sb.append(field.toGenericString()+"\n");
            }
        }
        sb.append("公共方法：\n");
        Method[] methods = clazz.getDeclaredMethods( );
        for(Method method : methods) {
            String s = Modifier.toString(method.getModifiers( ));
            if (s.contains("public")) {
                sb.append(method.toGenericString( ) + "\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringUtil().toString( new Object() ) );
    }
}
