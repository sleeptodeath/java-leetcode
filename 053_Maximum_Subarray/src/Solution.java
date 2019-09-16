
public class Solution {
    /*
        最大连续子序列和

        solutionA：
            联机算法O(n)
        SolutionB:
            Divide and Conquer O(nlogn)

     */
    // 联机算法
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int maxsum = nums[0];
        int cursum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            if (cursum < 0) {
                cursum = nums[i];
            } else {
                cursum += nums[i];
            }
            if (cursum > maxsum) {
                maxsum = cursum;
            }

        }
        return maxsum;
    }
    // DP maxsubArray(nums, i) = max(nums[i], maxsubArray(nums,i-1))
    // 以下标位i结尾的最大子串的最大和 =
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int dp = nums[0];
        int maxsum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(nums[i], dp+nums[i]);
            if (dp > maxsum)
                maxsum = dp;
        }
        return maxsum;
    }
    // 分治
    public int maxSubArray1(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        if (left > right)
            return Integer.MIN_VALUE;
        int mid = left + (right - left) / 2;

        int leftMax = helper(nums, left, mid);
        int rightMax = helper(nums, mid+1, right);

        int leftBorderMax = nums[mid];
        int curMax = 0;
        for (int i = mid; i >= left; i--) {
            curMax += nums[i];
            if (curMax > leftBorderMax)
                leftBorderMax = curMax;
        }
        int rightBorderMax = nums[mid+1];
        curMax = 0;
        for (int i = mid+1; i <= right; i++) {
            curMax += nums[i];
            if (curMax > rightBorderMax)
                rightBorderMax = curMax;
        }
        return Math.max(Math.max(leftMax, rightMax), leftBorderMax+rightBorderMax);
    }
}
