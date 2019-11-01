public class Solution {
    // DP, min(left_max, right_max) - height[i]
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ret = 0;
        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i-1], height[i]);
        }
        right_max[n-1] = height[n-1];
        for (int i = n-2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i+1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            ret += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ret;
    }
}
