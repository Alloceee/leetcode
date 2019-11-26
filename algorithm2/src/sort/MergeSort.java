package sort;

import java.util.Arrays;

/**
 * 二路归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] arr) {
        //临时数组
        int[] temp = new int[arr.length];
        sort(arr, temp, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(arr, temp, left, mid);
        sort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightEnd) {
        int rightStart = leftEnd + 1;
        //从左开始算
        int tempIndex = leftStart;
        //元素个数
        int len = rightEnd - leftStart + 1;
        while (leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] <= arr[rightStart]) {
                temp[tempIndex++] = arr[leftStart++];
            } else {
                temp[tempIndex++] = arr[rightStart++];
            }
        }
        //左边如果有剩余，将左边剩余的归并
        while (leftStart <= leftEnd) {
            temp[tempIndex++] = arr[leftStart++];
        }
        //右边如果有剩余，将右边剩余的归并
        while (rightStart <= rightEnd) {
            temp[tempIndex++] = arr[rightStart++];
        }
        //从临时数组拷贝到原数组
        for (int i = 0; i < len; i++) {
            arr[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
    }
}
