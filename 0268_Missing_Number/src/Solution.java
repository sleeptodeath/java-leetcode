import java.util.Arrays;

public class Solution {
    // 参考41题
    // public int missingNumber(int[] nums) {
    //     int n = nums.length;
    //     int i = 0;
    //     while (i < n) {
    //         if (nums[i] == n || nums[i] == i) i++;
    //         else if (nums[nums[i]] != nums[i]) swap(nums, i, nums[i]);
    //         else i++;
    //     }
    //     i = 0;
    //     while (i < n && nums[i] == i) {
    //         i++;
    //     }
    //     return i;
    // }
    // public void swap(int[] nums, int i, int j) {
    //     int tmp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = tmp;
    // }

    // SUM
    // public int missingNumber(int[] nums) {
    //     int sum = 0;
    //     for (int i = 0; i <= nums.length;i++)
    //         sum += i;
    //     for (int i = 0; i < nums.length;i++) {
    //         sum -= nums[i];
    //     }
    //     return sum;
    // }

    // XOR
    // public int missingNumber(int[] nums) {
    //     int ret = nums.length;
    //     for (int i = 0; i < nums.length; i++) {
    //         ret ^= i;
    //         ret ^= nums[i];
    //     }
    //     return ret;
    // }

    // Binary
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;

        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] > mid)
                r = mid-1;
            else
                l = mid+1;

        }
        return l;
    }

}