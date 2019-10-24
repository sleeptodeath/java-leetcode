import java.util.Map;
import java.util.Stack;

public class Solution {
    /*
            dp[i]  0~i-1
            s[i] = '(' ,dp[i] = 0
            s[i] = ')',
                if s[i-1] = '(', dp[i] = dp[i-2] + 2   (...)()
                else dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]       (..)((...))

        */
    // https://www.cnblogs.com/grandyang/p/4424731.html
//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() < 2)
//            return 0;
//
//        int ret = 0;
//        int[] dp = new int[s.length()];
//
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i-1) == '(') {
//                    dp[i] = (i >= 2? dp[i-2] : 0) + 2;
//                } else {
//                    int j = i - dp[i-1] - 1;
//                    if (j >= 0 && s.charAt(j) == '(') {
//                        dp[i] = dp[i-1] + 2 + (j > 0? dp[j-1] : 0);
//                    }
//                }
//                ret = Math.max(ret, dp[i]);
//            }
//        }
//        return ret;
//    }

    //stack
//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() < 2)
//            return 0;
//        int ret = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(0);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(')
//                stack.push(i);
//            else {
//                stack.pop();
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    ret = Math.max(ret, i - stack.peek() + 1);
//                }
//            }
//        }
//        return ret;
//    }

    // left-to-right
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2)
            return 0;
        int ret = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right)
                ret = Math.max(ret, left);
            else if (right > left)
                left = right = 0;
        }

        // 再反向 去除 (()这种情况
        left = right = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (left == right)
                ret = Math.max(ret, left);
            else if (left > right)
                left = right = 0;
        }
        return ret;
    }
}
