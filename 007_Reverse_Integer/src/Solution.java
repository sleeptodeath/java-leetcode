

public class Solution {


    public int reverse(int x) {
        long tmp = x;
        long ret = 0;
        long sign = 1;
        if (tmp < 0) {
            tmp = -tmp;
            sign = -1;
        }

        // 除10取余取反,直至0
        while (tmp != 0) {
            ret = ret * 10 + tmp % 10;
            tmp /= 10;
        }
        ret *= sign;
//        System.out.println(ret);

//        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)
//            ret = 0;
//        return (int)ret;

        return (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE)? 0 : (int)ret;
    }

}
