package leetcode;

/**
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class work7 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(i==0 || nums[i+1]>=nums[i-1]){
                    nums[i] = nums[i+1];
                }else{
                    nums[i+1] = nums[i];
                }
                count++;
            }
        }
        return count<=1;
    }
}
