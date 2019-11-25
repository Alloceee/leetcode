package sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        System.out.println(Arrays.toString(insertSort(array)));
    }

    public static int[] insertSort(int[] arr) {
        //外层循环确定待比较数值
        //必须从1开始，因为第一次是第二个数与第一个数比较
        for (int i = 0; i < arr.length; i++) {
            //待比较的数值
            int temp = arr[i];
            int j = i - 1;
            //内层循环为待比较数值确定其最终位置
            //待比较数值比前面的小就往前插一位
            for (; j > 0 && arr[j] > temp; j--) {
                //将大于temp的值整体后移一位
                arr[j + 1] = arr[j];
            }
            //待比较的数值比前面的大，最终位置无误
            arr[j + 1] = temp;
        }
        return arr;
    }
}
