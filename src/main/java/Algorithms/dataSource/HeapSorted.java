package Algorithms.dataSource;

import java.util.Arrays;

/**
 * 堆排序 与 优先队列
 */
public class HeapSorted {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 获取大顶堆的根节点值
     * @param arr
     * @return
     */
    public static int heapMaximum(int[] arr){
        return arr[0];
    }

    /**
     * 去掉并返回arr中的具有最大关键字的元素。
     * @param arr
     * @return
     */
    public static int heapExtractMax(int[] arr){
        if(arr.length<=0) {
//            throw new Exception( "heap underflow" );
            System.out.println("heap underflow" );
        }
        int max = arr[0];
        int length = arr.length;
        arr[0] = arr[length];
        arr[length] = arr[length] - 1;
        heapify(arr, 0, length);
        return max;
    }

    /**
     * 将元素x的关键字值增加到k，这里假设k的值不小于x的原关键字值。
     * @param arr
     * @param i
     * @param key
     */
    public static void heapIncreaseKey(int[] arr, int i, int key) {
        if(key < arr[0]){
            System.out.println("new key is smaller than current key" );
        }
        arr[i] = key;
        int parent = parent(i);
        while(i>1 && arr[parent] < arr[i]) {
            swap(arr, i, parent);
            i = parent;
        }
    }

    /**
     * 把元素x插入集合arr中。
     * @param arr
     * @param key
     */
    public static void maxHeapInsert(int[] arr, int key) {
        int heapSize = arr.length + 1;
        arr[heapSize] = (int) Double.NEGATIVE_INFINITY;
        heapIncreaseKey(arr, heapSize, key);
    }
    private static int parent(int i){
        return (int)Math.floor(i/2);
    }

    /**
     * 堆排序
     * @param arr
     */
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
     * 堆化:从i开始调整，到len为止，将i节点的值换成其与两个子节点中最大的值
     * 时间复杂度：O(lgn)
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
