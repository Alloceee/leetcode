package sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void countSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        int[] temp = new int[max];
        //找出每个数字出现的次数
        for (int i = 0; i < arr.length; i++) {
            //每个元素在temp中的位置 position = arr[i] - min
            int position = arr[i] - min;
            temp[position]++;
        }
        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            //temp[i] 大于0表示有重复元素
            while (temp[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }
}
