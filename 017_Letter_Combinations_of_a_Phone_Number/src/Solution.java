import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ret = solution.letterCombinations("23");
        for (String s : ret) {
            System.out.println(s);
        }
    }

    // 排列组合
    Map<Character, String> map = new HashMap<>();

    public void helper(List<String> list, String str, int index, StringBuilder sb) {
        if (index == str.length()) {
            list.add(sb.toString());
            return;
        }
        String alpha =  map.get(str.charAt(index));
        int size = alpha.length();
        for (int i = 0; i < size; i++) {
            sb.append(alpha.charAt(i));
            helper(list, str, index+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<>();
        if (digits == null || digits.length() == 0)
            return ret;
        StringBuilder sb = new StringBuilder();
        map.put('2', "abc"); map.put('3', "def");
        map.put('4', "ghi"); map.put('5', "jkl");
        map.put('6', "mno"); map.put('7', "pqrs");
        map.put('8', "tuv"); map.put('9', "wxyz");

        helper(ret, digits, 0, sb);
        return ret;
    }
}
