
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int ret = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ret++;
            else
                break;
        }
        return strs[0].substring(0, ret);
    }
}
