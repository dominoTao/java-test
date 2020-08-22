package Algorithms.dataSource;

import java.util.Arrays;
import java.util.Random;

/**
 * 快排
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,6,7,8,4,5};
//        quickSort(arr, 0 , arr.length-1);
//        randomizedQuicksort(arr, 0 , arr.length-1);
//        hoareQuicksort(arr, 0 , arr.length-1);
        tailRecursiveQuicksort(arr, 0 , arr.length-1);
        System.out.println(Arrays.toString(arr ) );


    }

    /**
     * 快排-最新版本
     * @param arr
     * @param p
     * @param r
     */
    private static void quickSort(int[] arr, int p, int r){
        if(p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }
    /**
     * 实现了对子数组arr[p..r]的原址重排
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private static int partition(int[] arr, int p, int r){
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if(arr[j] <= x) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, r);
        return i+1;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 随机化分区，比partition的区别：在分区之前进行一次交换
     * @param arr
     * @param p
     * @param r
     * @return
     */
    private static int randomizedPartition(int[] arr, int p, int r){
        Random random = new Random(  );
        // 生成范围[p, r]之间的随机数i
        int i = random.nextInt(r - p + 1) + p;
        swap(arr, r, i);
        return partition(arr, p, r);
    }

    /**
     * 快排-随机化版本
     * @param arr
     * @param p
     * @param r
     */
    private static void randomizedQuicksort(int[] arr, int p, int r){
        if(p < r) {
            int q = randomizedPartition(arr, p, r);
            randomizedQuicksort(arr, p, q-1);
            randomizedQuicksort(arr, q+1, r);
        }
    }

    /**
     * 快排-原始分区
     * @return
     */
    private static int hoarePartition(int[] arr, int p, int r){
        int x = arr[p];
        int i = p - 1;
        int j = r + 1;
        while (true) {
            do {
                j--;
            }while (arr[j] <= x);
            do {
                i++;
            }while (arr[j] >= x);
            if(i<j) {
                swap(arr, i, j);
            } else {
                return j;
            }
        }
    }

    /**
     * 原始版本的快排
     */
    private static void hoareQuicksort(int[] arr, int p, int r){
        if(p < r) {
            int q = hoarePartition(arr, p, r);
            hoareQuicksort(arr, p, q-1);
            hoareQuicksort(arr, q+1, r);
        }
    }

    /**
     * 尾递归 快排的栈深度
     * @param arr
     * @param p
     * @param r
     */
    private static void tailRecursiveQuicksort(int[] arr, int p, int r){
        while (p < r) {
            int q = partition(arr, p, r);
            tailRecursiveQuicksort(arr, p, q-1);
            p = q + 1;
        }
    }
}
