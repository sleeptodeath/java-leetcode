public class Solution {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int cnt = 0;
        int i = s.length()-1;
        while (i >= 0 && Character.isSpaceChar(s.charAt(i))) {
            i--;
        }
        while (i >= 0 && Character.isAlphabetic(s.charAt(i))) {
            cnt++;
            i--;
        }
        return cnt;
    }

    // api
    public int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0)
            return 0;

       s = s.trim();
       return s.length() - s.lastIndexOf(' ');
    }
}
