package com.chapter2;

import org.apache.commons.io.input.SwappedDataInputStream;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组  集合操作
 */
public class TestChapter2 {
    public static void main(String[] args) {
        int[] arr = generator(10);
        System.out.println("原数组：\t"+Arrays.toString(arr ) );
        quickSort(arr, 0, arr.length-1);
        System.out.println("新数组：\t"+Arrays.toString(test(arr)) );
    }
    public static int[] test(int[] arr){
        // 直接插入排序
        int j;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i - 1; j >= 0&&arr[j]>temp; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        return arr;
    }
    public static void quickSort(int sortArray[], int lowIndex, int highIndex){
        // 快速排序
        // 核心思想：冒泡排序的升级版， 快排每一趟都会确定一个数，划分比它小和比它大的两堆数据，冒泡每次冒泡都会确定一个数，剩下的数据需要重新冒泡
        int lo = lowIndex;
        int hi = highIndex;
        int mid;
        if(highIndex > lowIndex) {
            mid = sortArray[(lowIndex+highIndex)/2];
            while(lo <= hi) {
                while((lo < highIndex) && (sortArray[lo] < mid)){
                    ++lo;
                }
                while((hi > lowIndex) && (sortArray[hi] > mid)) {
                    --hi;
                }
                if(lo <= hi) {
                    swap(sortArray, lo, hi);
                    ++lo;
                    --hi;
                }
            }
            if(lowIndex < hi) {
                quickSort(sortArray, lowIndex, hi);
            }
            if(lo < highIndex) {
                quickSort(sortArray, lo, highIndex);
            }
        }
    }
    private static void swap(int swapArray[], int i, int j){
        int temp = swapArray[i];
        swapArray[i] = swapArray[j];
        swapArray[j] = temp;
    }
    public static int[] test5(int[] arr){
//        int[] arr = generator(10);
//        System.out.println("原数组：\t"+Arrays.toString(arr ) );
//        test(arr);
//        System.out.println("新数组：\t"+Arrays.toString(test(arr)) );
        // 冒泡
        for (int i = 1; i < arr.length; i++) {  // 冒泡次数
            for (int j = 0; j < arr.length-i; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public static void test4(){
        // 选择排序：每趟选出最大或最小的元素，放置在数组最后
        int[] arr = generator(10);
        System.out.println("原数组：\t"+Arrays.toString(arr ) );
        for (int i = 1; i < arr.length; i++) {
            int index = 0;
            for (int j = 1; j <= arr.length-i; j++) {
                if(arr[j]>arr[index]){
                    index = j;
                }
            }
            int temp = arr[arr.length-i];
            arr[arr.length-i] = arr[index];
            arr[index] = temp;
        }
        System.out.println("新数组：\t"+Arrays.toString(arr ) );
    }
    public static int[] generator(int size){
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(50);
        }
        return array;
    }
    public static void test3(){
        // 利用数组翻转字符串
        int[] a = {1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < a.length/2; i++) {
            int temp = a[i];
            a[i] = a[a.length-i-1];
            a[a.length-i-1] = temp;
        }
        System.out.println(Arrays.toString(a ) );
    }
    public static void test2(){
        // 行列互换
        int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr2 = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr2[i][j] = arr[j][i];
            }
        }
        System.out.println( );
    }
    public static void test1(){
        // 获取最大值
        int[] arr = {1,2,3,4,5,11,2,33,41,23,111};
        int max = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]) {
                max = arr[i+1];
            }
        }
        System.out.println(max );
    }
}

