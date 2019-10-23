import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    // 参考： https://www.cnblogs.com/grandyang/p/4521224.html

//    public List<Integer> findSubstring(String s, String[] words) {
//
//        Map<String, Integer> map = new HashMap<>();
//        List<Integer> ret = new LinkedList<>();
//        if (s == null || s.length() == 0 || words == null || words.length == 0)
//            return ret;
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//        int n = words.length;
//        int len = words[0].length();
//
//        for (int i = 0; i < s.length()-n*len + 1; i++) {
//            Map<String, Integer> subMap = new HashMap<>();
//            int j = 0;
//            for (j = 0; j < n; j++) {
//                String subString = s.substring(i+j*len, i+j*len+len);
//
//                if (!map.containsKey(subString)) {
//                    break;
//                }
//                subMap.put(subString, subMap.getOrDefault(subString, 0)+1);
////                System.out.println(subString);
//                if (subMap.get(subString) > map.get(subString))
//                    break;
//            }
//            if (j == n) {
//                ret.add(i);
//            }
//        }
//        return ret;
//    }
    // 滑动窗口
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ret = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return ret;

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int n = words.length;
        int len = words[0].length();

        for (int i = 0; i < len; i++) {
            int left = i;
            int cnt = 0;
            Map<String, Integer> curMap = new HashMap<>();
            for (int j = i; j <= s.length() - len; j+=len) {
                String subString = s.substring(j, j+len);
                if (map.containsKey(subString)) {
                    curMap.put(subString, curMap.getOrDefault(subString, 0) + 1);
                    while (curMap.get(subString) > map.get(subString)) {
                        String tmp = s.substring(left,left+len);
                        curMap.put(tmp, curMap.get(tmp)-1);
                        cnt--;
                        left += len;
                    }
                    cnt++;
                    if (cnt == n) {
                        ret.add(left);
                        String tmp = s.substring(left, left+len);
                        curMap.put(tmp, curMap.get(tmp)-1);
                        cnt--;
                        left += len;
                    }
                } else {
                    curMap.clear();
                    cnt = 0;
                    left = j + len;
                }
            }
        }

        return ret;
    }
}
