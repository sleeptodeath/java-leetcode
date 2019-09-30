
public class Solution {
    // 动态规划
    // 1. i == j dp[i][j] = true
    // 2. i+1 == j dp[i][j] = s[i] == s[j]? true : false
    // 3. i+1 < j dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
    // O(n*n)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        char[] c = s.toCharArray();
        int len = c.length;
        int l=len-1, r=len-1;
        boolean[][] dp = new boolean[len][len];

        for (int i = len-1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i+1; j < len; j++) {
                if (j == i+1) {
                    dp[i][j] = c[i] == c[j];
                } else {
                    dp[i][j] = dp[i+1][j-1] && c[i] == c[j];
                }
                if (dp[i][j] && j-i > r-l) {
                    l = i;
                    r = j;
                }
            }
        }
        return s.substring(l, r+1);
    }

    // 马拉车 Manacher

}
