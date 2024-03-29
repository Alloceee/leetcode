package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectSort(int[] arr) {
        int minIndex = 0;
        int temp;
        for (int i=0;i<arr.length;i++){
            minIndex = i;
            for (int j = i+1;j<arr.length;j++){
                //找到当前循环最小值索引
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            //交换当前循环起点值和最小值索引位置的值
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
