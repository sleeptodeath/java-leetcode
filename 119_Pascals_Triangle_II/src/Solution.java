import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < rowIndex+1; i++) {
            ret.add(0, 1);
            for (int j = 1; j < i; j++) {
                ret.set(j, ret.get(j) + ret.get(j+1));
            }
        }
        return ret;
    }
}
