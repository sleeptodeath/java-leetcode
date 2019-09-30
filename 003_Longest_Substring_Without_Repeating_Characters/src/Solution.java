import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    // 暴力遍历
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0)
//            return 0;
//        int ret = 1;
//        char str[] = s.toCharArray();
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < str.length; i++) {
//            set.clear();
//            set.add(str[i]);
//            int j;
//            for (j = i+1; j < str.length; j++) {
//                if (set.contains(str[j])) {
//                    break;
//                }
//                set.add(str[j]);
//            }
//            ret = Math.max(ret, j-i);
//        }
//        return ret;
//    }


    // 一遍扫描
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int ret = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 回退到上一个位置
                j = Math.max(j, map.get(s.charAt(i)));
            }
            ret = Math.max(ret, i - j + 1);
            map.put(s.charAt(i), i+1);
        }
        return ret;
    }
}
