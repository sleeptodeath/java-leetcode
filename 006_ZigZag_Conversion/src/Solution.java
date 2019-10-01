

import java.util.LinkedList;
import java.util.List;

public class Solution {

    // 模范填进去
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> l = new LinkedList<>();
        StringBuilder ret = new StringBuilder();
        int size = Math.min(numRows, s.length());
        for (int k = 0; k < size; k++)
            l.add(new StringBuilder());

        int i = 0;
        int j = 0;
        int direct = -1;

        int len = s.length();
        while (i < len) {

            l.get(j).append(s.charAt(i));
            if (j == numRows-1 || j == 0) {
                direct = -direct;
            }
            j += direct;
            i++;
        }
        for (int k = 0; k < size; k++) {
            ret.append(l.get(k));
        }
        return ret.toString();
    }
}
