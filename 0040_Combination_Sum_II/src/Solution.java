import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        helper(candidates, ret, cur, 0, target);
        return ret;
    }

    public void helper(int[] candidates, List<List<Integer>> ret, List<Integer> cur, int start, int target) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> tmp = new LinkedList<>(cur);
            ret.add(tmp);
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                return;
            if (i > start && candidates[i] == candidates[i-1]) continue;
            if (i > 0 && candidates[i] == candidates[i-1]) continue;
            cur.add(candidates[i]);
            helper(candidates, ret, cur, i+1, target-candidates[i]);
            cur.remove(cur.size()-1);
        }
    }
}
