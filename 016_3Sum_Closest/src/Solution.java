import java.util.Arrays;

public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        int ret = 0;
        if (nums.length <= 3) {
            for (int t : nums)
                ret += t;
            return ret;
        }
        // 排序
        Arrays.sort(nums);
        ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum < target) {
                    l++;
                } else if (sum > target)
                    r--;
                else
                    return sum;
                if (Math.abs(sum - target) < Math.abs(ret - target))
                    ret = sum;
            }
        }
        return ret;
    }
}
