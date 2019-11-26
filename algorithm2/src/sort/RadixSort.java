package sort;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void radixSort(int[] array) {
        //数组arr中的最大值
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            //从个位开始，对数组arr按“exp指数”进行排序
            countSort(array, exp);
        }
    }

    private static void countSort(int[] array, int exp) {
        //存储“被排序数据”的临时数组
        int[] temp = new int[array.length];
        int[] buckets = new int[10];

        //将数据出现的次数存储在buckets[]中
        for (int i = 0; i < array.length; i++) {
            buckets[(array[i] / exp) % 10]++;
        }
        //计算数据在temp[]中的位置 0 1 2 3 --> 0 1 3 5 8
        for (int i = 1; i < 10; i++) {
            buckets[i] += buckets[i - 1];
        }
        //将数据存储到临时数组temp[]中
        for (int i = array.length - 1; i >= 0; i--) {
            temp[buckets[(array[i]) / exp % 10] - 1] = array[i];
            buckets[(array[i] / exp) % 10]--;
        }
        //将排好序的数据赋值给arr[]
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
}
