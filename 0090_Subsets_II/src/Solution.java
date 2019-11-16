import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    题意：求所有子集，数组元素重复，
    解法：同78题，因为重复，要先排序，每次需要判断是否重复，再深入递归
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        helper(ret, nums, used, 0);
        return ret;
    }

    public void helper(List<List<Integer>> ret, int[] nums, boolean[] used, int n) {
        if (n == nums.length) {
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    tmp.add(nums[i]);
            }
            ret.add(tmp);
        } else {
            if (n == 0 || nums[n] != nums[n-1] || used[n-1]) {
                used[n] = true;
                helper(ret, nums, used, n+1);
                used[n] = false;
                helper(ret, nums, used, n+1);
            } else {
                helper(ret, nums, used, n+1);
            }
        }
    }
}