public class Solution {
    public String countAndSay(int n) {
        if (n < 1 || n > 30)
            return null;
        String str = "1";
        for (int i = 0; i < n-1; i++) { // 需要从1到n需要n-1次
            StringBuilder sb = new StringBuilder();
            int j;
            int cnt = 1;
            for (j = 1; j < str.length(); j++){
                if (str.charAt(j) == str.charAt(j-1)) {
                    cnt++;
                } else {
                    sb.append(cnt).append(str.charAt(j-1));
                    cnt = 1;
                }
            }
            str = sb.append(cnt).append(str.charAt(j-1)).toString();
        }
        return str;
    }
}
