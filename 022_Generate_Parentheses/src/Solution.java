import java.util.*;

public class Solution {
//    public List<String> generateParenthesis(int n) {
//
//        List<String> ret = new LinkedList<>();
//
//        helper(ret, "", n, 0, 0);
//        return ret;
//    }
//
//    public void helper(List<String> list, String cur, int n, int left, int right) {
//        if (left + right == 2 * n) {
//            list.add(cur);
//        }
//        if (left < n) {
//            helper(list, cur+'(', n, left+1, right);
//        }
//        if (right < left) {
//            helper(list, cur + ')', n, left, right + 1);
//        }
//    }

    public List<String> generateParenthesis(int n) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> l1 = new LinkedList<>();
        l1.add("");
        map.put(0, l1);

        for (int i = 1; i <= n; i++) {
            List<String> subList = new LinkedList<>();
                for (int j = 0; j < i; j++) {
                for (String sj : map.get(j)) {
                    for (String sk : map.get(i-j-1)) {
                        subList.add("(" + sj  + ")" + sk);
                    }
                }
            }
            map.put(i, subList);
        }
        return map.get(n);
    }
}
