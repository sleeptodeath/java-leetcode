import java.util.LinkedList;
import java.util.List;

public class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ret = new LinkedList<>();
//        if (numRows < 1)
//            return ret;
//
//        List<Integer> li = new LinkedList<>();
//        li.add(1);
//        ret.add(li);
//        for (int i = 2; i <= numRows; i++) {
//            List<Integer> pre = ret.get(i-2);
//            List<Integer> cur = new LinkedList<>();
//            cur.add(1);
//            for (int j = 1; j < i-1; j++) {
//                cur.add(pre.get(j-1) + pre.get(j));
//            }
//            cur.add(1);
//            ret.add(cur);
//        }
//        return ret;
//    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new LinkedList<>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i)
                    cur.add(1);
                else {
                    cur.add(ret.get(i-1).get(j-1) + ret.get(i-1).get(j));
                }

            }
            ret.add(cur);
        }
        return ret;
    }
}
