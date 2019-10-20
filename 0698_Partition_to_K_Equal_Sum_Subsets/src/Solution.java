import java.util.Arrays;

public class Solution {
    /*
        题意：这道题给了我们一个数组nums和一个数字k，问我们该数字能不能分成k个非空子集合，使得每个子集合的和相同
        解法：dfs

     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return false;
        if (k == 1)
            return true;
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, 0, 0, sum / k, k);
    }

    public boolean helper(int[] nums, boolean[] visited, int start, int curSum, int target, int k) {
        if (k == 1)
            return true;
        // 可有可没有
        if (curSum > target)
            return false;
        if (curSum == target) {
            return helper(nums, visited, 0, 0, target, k-1);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            if (helper(nums, visited, i+1, curSum + nums[i], target, k))
                return true;
            visited[i] = false;
        }
        return false;
    }

}
