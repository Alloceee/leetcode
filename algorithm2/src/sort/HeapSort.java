package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        //进行n-1次循环，完成排序
        for (int i = arr.length-1;i>0;i--){
            //最后一个元素和第一个元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            //筛选R[0]结点，得到i-1个结点的堆 将arr中前i-1个记录重新调整为大顶堆
            heapAdjust(arr,0,i);
        }
    }

    /**
     * 堆调整
     * @param arr
     * @param i
     * @param i1
     */
    private static void heapAdjust(int[] arr, int i, int i1) {

    }

    /**
     * 构建大顶堆
     * @param arr
     */
    private static void buildMaxHeap(int[] arr) {

    }
}
