public class Solution {
    // dp
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (!dp[i]) continue;
            int furthest = Math.min(i+nums[i], nums.length-1);
            for (int j = i+1; j <= furthest; j++)
                dp[j] = true;
        }
        return dp[nums.length-1];
    }

    // greedy
    // 最远能跳到那  curMax = math.max(curMax, i+A[i]) if i<=curMax
//     public boolean canJump(int[] nums) {
//         int curMax = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (i > curMax || curMax >= nums.length-1)
//                 break;
//             curMax = Math.max(curMax, i+nums[i]);
//         }
//         return (curMax>=nums.length-1)? true : false;
//     }
    // 从后往前
//     public boolean canJump(int[] nums) {
//         int curMin = nums.length-1;

//         for (int i = nums.length-1; i >= 0; i--) {
//             if (i + nums[i] >= curMin) {
//                 curMin = i;
//             }
//         }
//         return curMin == 0;
//    }

}