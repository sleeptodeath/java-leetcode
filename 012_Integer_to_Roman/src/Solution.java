import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(1994));
    }

//    public String intToRoman(int num) {
//        Map<Integer, String> map = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        map.put(1, "I");
//        map.put(4, "IV"); map.put(5, "V");
//        map.put(9, "IX"); map.put(10, "X");
//        map.put(40, "XL"); map.put(50, "L");
//        map.put(90, "XC"); map.put(100, "C");
//        map.put(400, "CD"); map.put(500, "D");
//        map.put(900, "CM"); map.put(1000, "M");
//
//        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
//        for (int i = 0; i < arr.length; i++) {
//            if (num >= arr[i]) {
//                int cnt = num/arr[i];
//                for (int j = 0; j < cnt; j++)
//                    sb.append(map.get(arr[i]));
//                num -= cnt * arr[i];
//            }
//        }
//        return sb.toString();
//    }

    public String intToRoman(int num) {
        // 判断是否在范围内
        if (num < 0 || num > 3999) return "";

        StringBuilder sb = new StringBuilder();

        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int i = 0;
        while (num > 0) {
            while (num >= arr[i]) {
                sb.append(roman[i]);
                num -= arr[i];
            }
            i++;
        }
        return sb.toString();
    }
}
