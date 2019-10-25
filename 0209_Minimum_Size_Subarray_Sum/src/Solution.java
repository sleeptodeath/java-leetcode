public class Solution {
    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int l = 0, r = 0;
        int ret = -1;
        int sum = 0;
        while (r < nums.length) {
            sum += nums[r];

            while (l <= r && sum >= s) {
                if (ret == -1 || r-l+1 < ret)
                    ret = r-l+1;
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ret;
    }
}
