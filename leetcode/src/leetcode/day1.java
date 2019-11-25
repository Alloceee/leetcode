package leetcode;

public class day1 {
    public static void main(String[] args) {

    }

    /**
     * 移除数组中某一元素，并返回数组的长度（要求不建立新数组）
     *
     * @param A    需要操作的数组
     * @param n    在第n个元素之前
     * @param elem 需要删除的元素
     * @return 最终数组长度
     */
    public static int removeElement(int[] A, int n, int elem) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == elem) {
                continue;
            }
            A[j] = A[i];
            j++;
        }
        return j;
    }

    /**
     * 在排序好的数组中删除重复元素，并返回最终数组长度
     *
     * @param A 已经排序好的数组
     * @param n 在第n个元素之前
     * @return 最终数组长度
     */
    public static int removeDuplicates(int[] A, int n) {
        return 0;
    }
}
