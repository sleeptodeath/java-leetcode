import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> ret = new LinkedList<>();
//        List<Integer> cur = new LinkedList<>();
//        Arrays.sort(candidates);
//        helper(candidates, ret, cur, 0, target);
//        return ret;
//    }
//    public void helper(int[] candidates, List<List<Integer>> ret, List<Integer> cur, int start, int target) {
//
//        if (target < 0) return;
//        if (target == 0) {
//            List<Integer> tmp = new LinkedList<>(cur);
//            ret.add(tmp);
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            if (candidates[i] > target)
//                return;
//            cur.add(candidates[i]);
//            helper(candidates, ret, cur, i, target-candidates[i]);
//            cur.remove(cur.size()-1);
//        }
//    }

    // dp
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new LinkedList<>();

        for (int i = 0; i <= target; i++) {
            List<List<Integer>> cur = new LinkedList<>();

            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] > i) break;
                if (candidates[j] == i) {
                    cur.add(Arrays.asList(candidates[j]));
                    break;
                }
                for (List<Integer> tmp : dp.get(i-candidates[j])) {
                    if (candidates[j] > tmp.get(0)) continue;
                    List<Integer> tt = new LinkedList<>(tmp);
                    tt.add(0, candidates[j]);
                    cur.add(tt);
                }
            }
            dp.add(cur);
        }
        return dp.get(target);
    }
}
