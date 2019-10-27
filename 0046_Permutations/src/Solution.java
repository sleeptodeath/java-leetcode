import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
    题意： 全排列问题，给的输入数组没有重复项
    解法： backtracking
            used数组, cur当前遍历到的数，
 */
public class Solution {
    // 解法一：
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> ret = new LinkedList<>();
//        boolean[] used = new boolean[nums.length];
//        List<Integer> cur = new LinkedList<>();
//        helper(nums, ret, used, cur, nums.length);
//        return ret;
//    }
//
//    public void helper(int[] nums, List<List<Integer>>ret, boolean[] used, List<Integer> cur, int size) {
//        if (cur.size() == size) {
//            List<Integer> tmp = new LinkedList<>(cur);
//            ret.add(tmp);
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (!used[i]) {
//                used[i] = true;
//                cur.add(nums[i]);
//                helper(nums, ret, used, cur, size);
//                cur.remove(cur.size()-1);
//                used[i] = false;
//            }
//        }
//    }

    //解法二：
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        helper(nums, ret, 0);
        return ret;
    }

    public void helper(int[] nums, List<List<Integer>> ret, int start) {
        if (start >= nums.length) {
            List<Integer> tmp = new LinkedList<>();
            for (int num : nums)
                tmp.add(num);
            ret.add(tmp);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(nums, ret, start+1);
            swap(nums, i, start);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
