package sort;

import java.util.Arrays;

/**
 * 排序算法总结
 */
public class Sort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    private static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}
