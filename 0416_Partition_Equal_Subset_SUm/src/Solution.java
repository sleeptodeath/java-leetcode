public class Solution {
    /*
        题意： 求一个数组可不可以分成两个子集，且两个子集的和相等
        解法： 0-1背包
        能否装满 sum/2
     */

//    public boolean canPartition(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return false;
//        int sum = 0;
//        for (int n : nums)
//            sum += n;
//        if (sum % 2 == 1)
//            return false;
//        int V = sum / 2;
//        int[] dp = new int[V+1];
//        dp[0] = 0;
//        for (int i = 1; i <= V; i++)
//            dp[i] = -0x3f3f3f3f;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = V; j >= nums[i]; j--) {
//                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
//            }
//        }
//        return dp[V] == -0x3f3f3f3f? false:true;
//    }

     public boolean canPartition(int[] nums) {
         if (nums == null || nums.length == 0)
             return false;
         int sum = 0;
         for (int n : nums)
             sum += n;
         if (sum % 2 == 1)
             return false;
         int V = sum / 2;
         boolean[] dp = new boolean[V+1];
         dp[0] = true;
         for (int i = 0; i < nums.length; i++) {
             for (int j = V; j >= nums[i]; j--) {
                 dp[j] =dp[j] ||  dp[j-nums[i]];
             }
         }
         return dp[V];
     }
}
