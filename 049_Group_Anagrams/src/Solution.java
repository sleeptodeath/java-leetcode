import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new LinkedList<>();
        if (strs == null || strs.length == 0)
            return ret;
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);

            if (!map.containsKey(key)) map.put(key, new LinkedList<>());
            map.get(key).add(strs[i]);
        }
        for (List<String> tmp : map.values()) {
            ret.add(tmp);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
    }
}
