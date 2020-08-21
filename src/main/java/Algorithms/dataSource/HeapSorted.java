package Algorithms.dataSource;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSorted {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        if(arr == null || arr.length == 0) {
            return ;
        }
        int length = arr.length;
        // 构建大顶堆
        buildMaxHeap(arr, length);
        // 交换堆顶节点也末尾节点，交换一次需要重新构建大顶堆
        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            length--;
            heapify(arr, 0, length);
        }
    }

    /**
     * 构建大顶堆
     * @param arr
     * @param length
     */
    private static void buildMaxHeap(int[] arr, int length){
        for (int i = (int)Math.floor(length / 2) - 1; i >= 0; i--) {
            heapify(arr, 0, length);
        }
    }

    /**
     * 从i开始调整，到len为止，将i节点的值换成其与两个子节点中最大的值
     * @param arr
     * @param i
     * @param len
     */
    private static void heapify(int[] arr, int i, int len) {
        // 根据非叶子节点i，找出左右子节点的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 默认当前节点是最大值
        int largestIndex = i;
        // 找出当前节点和左右子节点中最大的节点
        if(left < len && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }
        if(right < len && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }
        if(largestIndex != i) {
            swap(arr, i, largestIndex);
            // 如果被交换的子结点为非叶子节点，则需要继续调整
            heapify(arr, largestIndex, len);
        }
    }
    /**
     * 交换数组元素
     * @param arr
     * @param a
     * @param b
     */
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = arr[a];
    }
}
