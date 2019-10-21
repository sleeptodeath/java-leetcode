import java.util.Arrays;

public class Solution {
    /*
        题意：这道题让我们求下一个排列顺序
        思路：
        如果从末尾往前看，数字逐渐变大，到了2时才减小的，
        然后再从后往前找第一个比2大的数字，是3，那么我们交换2和3，
        再把此时3后面的所有数字转置一下即可，步骤如下：

        1　　2　　7　　4　　3　　1

        1　　2　　7　　4　　3　　1

        1　　3　　7　　4　　2　　1

        1　　3　　1　　2　　4　　7

     */
    public void reverse(int[] nums, int l, int r) {
        int tmp;
        while (l < r) {
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        // 找递减序列
        int i = nums.length-1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }

        if (i > 0) {
            // 找比nums[i-1]大的数
            int j = nums.length-1;
            while (j > 0 && nums[j] <= nums[i-1])
                j--;
            // swap
            int tmp = nums[i-1];
            nums[i-1] = nums[j];
            nums[j] = tmp;
        }
        // reverse
        reverse(nums, i, nums.length-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
