package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //每次建堆就可以排除一个元素了
            buildMaxHeap(arr, arr.length - i);
            //交换
            int temp = arr[0];
            arr[0] = arr[(arr.length - 1) - i];
            arr[(arr.length - 1) - i] = temp;
        }
    }

    /**
     * 建堆
     *
     * @param arr          看作是完全二叉树
     * @param parent       当前父节点位置
     * @param length       节点总数
     */
    private static void heapAdjust(int[] arr, int parent, int length) {
        if (parent < length) {
            //左子树和右字数的位置
            int left = 2 * parent + 1;
            int right = 2 * parent + 2;

            //把当前父节点位置看成是最大的
            int max = parent;

            if (left < length) {
                //如果比当前根元素要大，记录它的位置
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }
            if (right < length) {
                //如果比当前根元素要大，记录它的位置
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }
            //如果最大的不是根元素位置，那么就交换
            if (max != parent) {
                int temp = arr[max];
                arr[max] = arr[parent];
                arr[parent] = temp;

                //继续比较，直到完成一次建堆
                heapAdjust(arr, max, length);
            }
        }

    }

    /**
     *  完成一次建堆，最大值在堆的顶部(根节点)
     *
     */
    private static void buildMaxHeap(int[] arr, int size) {
        // 从数组的尾部开始，直到第一个元素(角标为0)
        for (int i = size - 1; i >= 0; i--) {
            heapAdjust(arr, i, size);
        }
    }
}
