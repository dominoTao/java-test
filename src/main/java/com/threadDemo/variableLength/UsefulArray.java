package com.threadDemo.variableLength;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UsefulArray {
    /**
     * 数组扩容
     * @param array
     * @return
     */
    public static Object increaseArray(Object array) {
        Class<?> claxx = array.getClass();
        if(claxx.isArray()) {
            int length = Array.getLength(array);
            Object o = Array.newInstance(claxx.getComponentType( ), length << 1);
            System.arraycopy(array, 0 , o, 0 ,length);
            return o;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints = new int[10];
        System.out.println("整型数组原始长度：" + ints.length );
        Arrays.fill(ints, 8 );
        System.out.println("整型数组的内容" );
        System.out.println(Arrays.toString(ints) );
        int[] ints1 = (int[]) increaseArray(ints);
        System.out.println("扩容后的数组长度：" );
        System.out.println(ints1.length );
        System.out.println("整型数组的内容" );
        System.out.println(Arrays.toString(ints1 ) );
//        整型数组原始长度：10
//        整型数组的内容
//                [8, 8, 8, 8, 8, 8, 8, 8, 8, 8]
//        扩容后的数组长度：
//        20
//        整型数组的内容
//                [8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    }
}
