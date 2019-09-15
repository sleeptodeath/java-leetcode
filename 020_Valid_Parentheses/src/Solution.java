import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        Map<Character, Character> map = new HashMap<>();

        map.put('(', ')'); map.put('[', ']'); map.put('{', '}');

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                stack.push(arr[i]);
            } else {
                if (stack.size() == 0)
                    return false;
                char c = stack.pop();
                if (map.get(c) != arr[i])
                    return false;
            }
        }

        return stack.empty();
    }
}
