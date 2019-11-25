package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        System.out.println(Arrays.toString(shellSort(array)));
    }

    public static int[] shellSort(int[] arr) {
        int d = arr.length;
        while (d >= 1) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                //按小标的一定增量分组然后进行排序
                for (int i = x + d; i < arr.length; i = i + d) {
                    int temp = arr[i];
                    int j;
                    for (j = i - d; j >= 0 && arr[j] > temp; j = j - d) {
                        arr[j + d] = arr[j];
                    }
                    arr[j + d] = temp;
                }
            }
        }
        return arr;
    }
}
