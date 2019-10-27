import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    题意：全排列问题，给的输入数组有重复项
    解法：backtracking
        在递归函数中要判断前面一个数和当前的数是否相等，
        如果相等，且其对应的 used 中的值为true， 当前的数字才能使用，否则需要跳过
 */

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // 对于重复的可以通过排序处理
        List<List<Integer>> ret = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new LinkedList<>();
        helper(nums, ret, used, cur);
        return ret;
    }

    public void helper(int[] nums, List<List<Integer>>ret, boolean[] used, List<Integer> cur) {
        if (cur.size() == nums.length) {
            List<Integer> tmp = new LinkedList<>(cur);
            ret.add(tmp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // 比permute 多这个if
            if (i > 0  && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            cur.add(nums[i]);
            helper(nums, ret, used, cur);
            cur.remove(cur.size()-1);
            used[i] = false;
        }
    }
}
