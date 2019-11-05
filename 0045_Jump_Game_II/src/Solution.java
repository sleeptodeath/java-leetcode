public class Solution {

    // dp
    // public int jump(int[] nums) {
    //     int[] dp = new int[nums.length];
    //     for (int i = 0; i < nums.length; i++) {
    //         dp[i] = 0x3f3f3f;
    //     }
    //     dp[0] = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         int furthest = Math.min(i+nums[i], nums.length-1);
    //         for (int j = i + 1; j <= furthest; j++) {
    //             dp[j] = Math.min(dp[i]+1, dp[j]);
    //         }
    //     }
    //     return dp[nums.length-1];
    // }

    // greedy
    // ret 第几次
    // curMax 当前次数能到达的最远距离
//     public int jump(int[] nums) {

//         int curMax = 0;
//         int ret = 0;

//         while (curMax < nums.length-1) {
//             ret++;
//             int preMax = curMax;
//             for (int i = 0; i <= preMax; i++) {
//                 curMax = Math.max(curMax, i+nums[i]);
//             }
//         }
//         return ret;
//     }

    public int jump(int[] nums) {
        int nextMax = 0;
        int curMax = 0;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > curMax) {
                ret++;
                curMax = nextMax;
            }
            nextMax = Math.max(nextMax, i+nums[i]);
        }
        return ret;
    }

}