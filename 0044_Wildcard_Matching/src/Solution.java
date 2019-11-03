public class Solution {
    // 双指针
    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        int i = 0, j = 0, istart = -1, jstart = -1;
        while (i < len1) {
            if (j < len2 && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;  j++;
            } else if (j < len2 && p.charAt(j) == '*') {
                istart = i+1;
                jstart = j++;
            } else if (jstart >= 0) {
                i = istart++;
                j = jstart+1;
            } else
                return false;
        }
        while (j < len2 && p.charAt(j) == '*') j++;
        return j == len2;
    }
    // DP
//     public boolean isMatch(String s, String p) {
//         int len1 = s.length(), len2 = p.length();
//         if (len1 == 0 && len2 == 0)
//             return true;
//         if (len2 == 0)
//             return false;
//         boolean[][] dp = new boolean[len1+1][len2+1];
//         dp[0][0] = true;
//         for (int i = 1; i <= len2 && p.charAt(i-1) == '*'; i++) {
//             dp[0][i] = true;
//         }

//         for (int i = 1; i <= len1; i++) {
//             for (int j = 1; j <= len2; j++) {
//                 if (p.charAt(j-1) == '*') {
//                     dp[i][j] = dp[i-1][j] || dp[i][j-1];
//                 } else if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
//                     dp[i][j] = dp[i-1][j-1];
//                 }
//             }
//         }
//         return dp[len1][len2];
//     }
}

