package Algorithms.dataSource;

import java.util.Arrays;

/**
 * 插入排序：
 * 时间复杂度 平均是O(n^2)，最坏也是；当待排序数组是有序时，是最优的情况，只需要比较一下就可以，时间复杂度是O(n)
 * 空间复杂度是常数阶O(1)
 */
public class InsertSorted {
    public static void main(String[] args) {
        Comparable[] arr = new Comparable[]{1,2,3,6,7,8,4,5};
        insertSorted(arr);
    }
    public static void insertSorted(Comparable[] a){
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && (a[j].compareTo(a[j-1]) < 0); j--) {
                Comparable temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
//        [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
