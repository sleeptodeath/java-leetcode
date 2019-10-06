import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    /*
        同 3Sum, 多加一层循环
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ret = new LinkedList<>();
        if (nums == null || nums.length < 4)
            return ret;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                for (int j = i+1; j < nums.length-2; j++) {
                    if (j == i+1 || nums[j] != nums[j-1]) {
                        int l = j+1;
                        int h = nums.length - 1;
                        while (l < h) {
                            int sum = nums[i] + nums[j] + nums[l] + nums[h];
                            if (sum == target) {
                                ret.add(Arrays.asList(nums[i], nums[j], nums[l], nums[h]));
                                while (l < h && nums[l+1] == nums[l]) l++;
                                while (l < h && nums[h-1] == nums[h]) h--;
                                l++;
                                h--;
                            } else if (sum < target) l++;
                            else h--;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
