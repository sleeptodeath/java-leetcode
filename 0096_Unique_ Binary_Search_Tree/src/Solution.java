
/*
    题意: n个节点可以组成多少种不同的二叉查找树
    解法：动态规划
        将树分为root左边和root右边
        dp[0] = dp[1] = 1
        dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-2] + .. + dp[n-1]*dp[0]
 */
public class Solution {

    // 左边0个，左边1个，左边2个，。。左边n-1个
    // dp[n] = dp[0]*dp[n-1] + dp[1]*dp[n-1-1] + ..dp[n-1]*dp[0]
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}