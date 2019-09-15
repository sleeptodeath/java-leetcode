import java.util.HashMap;
import java.util.Map;

public class Solution {

    /*
        通过map建立I,V,X等与数字的关系，同时便于比较

     */
    public int romanToInt(String s) {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500); map.put('M', 1000);

        int ret = 0;
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length) {
            if (i < arr.length - 1 && map.get(arr[i+1]) > map.get(arr[i])) {
                ret +=  map.get(arr[i+1]) - map.get(arr[i]);
                i += 2;
            } else {
                ret += map.get(arr[i]);
                i += 1;
            }
        }
        return ret;
    }
}
