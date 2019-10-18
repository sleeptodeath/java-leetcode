import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    /*
        题意是给你一组区间，让你把区间合并成没有交集的一组区间。
            我们可以把区间按 start 进行排序，然后遍历排序后的区间，
                如果当前的 start 小于前者的 end，那么说明这两个存在交集，我们取两者中较大的 end 即可；
                否则的话直接插入到结果序列中即可。
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> ret = new LinkedList<>();
        if (intervals == null || intervals.length == 0)
            return intervals;

        // 先按start排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                ret.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(intervals[i][1], end);
            }
        }
        ret.add(new int[] {start, end});
        int[][] retArr = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }
}
