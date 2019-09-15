public class Solution {

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0)
            return 0;

        for (int i = 0; i < haystack.length(); i++) {

            if (i + needle.length() > haystack.length())
                break;

            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j) != needle.charAt(j))
                    break;
            }
            if (j == needle.length())
                return i;
        }
        return -1;
    }

    // KMP 学习后写一下

}
