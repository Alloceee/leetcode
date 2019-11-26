package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] array = new int[]{33, 42, 1, 44, 4, 63, 3, 32};
        bucketSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bucketSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max-min) /arr.length +1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i=0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<>());
        }
        //将每个元素放入桶
        for(int i=0;i<arr.length;i++){
            int num = (arr[i] - min)/arr.length;
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i=0;i<bucketNum;i++){
            Collections.sort(bucketArr.get(i));
        }
        int position = 0;
        //合并桶
        for(int i=0;i<bucketNum;i++){
            for(int j=0;j<bucketArr.get(i).size();j++){
                arr[position++] = bucketArr.get(i).get(j);
            }
        }
    }
}
