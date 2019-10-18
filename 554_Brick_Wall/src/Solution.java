import java.util.*;

public class Solution {
    /*
        题意根据图示已经描述得很清楚了，就是在从底部到顶部，求最少交叉的数量，
        我们可以把每堵墙可以穿过的地方保存到哈希表中，每次遇到哈希表中的值加一，代表就是这条路不用交叉的数量，
        最终我们可以算出不用交叉的最大值，让总墙数减去其值就是最少交叉的数量
     */
    public int leastBricks(List<List<Integer>> wall) {

        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> row : wall) {
            int len = 0;
            for (int i = 0; i < row.size()-1; i++) {
                len += row.get(i);
                map.put(len, map.getOrDefault(len, 0) + 1);
                ret = Math.max(ret, map.get(len));
            }
        }
        return wall.size() - ret;
    }

}
