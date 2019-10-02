public class Solution {
    /**
     * step1：读空格
     * step2: 判断正负数
     * step3: 读前导0
     * step4：读数字，注意不能太长
     */
    public int myAtoi(String str) {
        int ret = 0;
        int sign = 1;
        int i = 0;
        int len = str.length();

        if (str == null || str.length() == 0)
            return (int)ret;

        // 去空格
        while (i < len && Character.isSpaceChar(str.charAt(i)))
            i++;
        // 判断正负号
        if (i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i) == '-')? -1: 1;
            i++;
        }

        while (i < len && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10))
                return (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
            ret = ret * 10 + digit;
            i++;
        }
        return ret * sign;
    }
}
