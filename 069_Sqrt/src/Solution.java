
public class Solution {
    // 二分搜索
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int l = 1, r = x;
        int mid;
        while (l <= r) {
            mid = l + (r-l) / 2;
           if (mid > x / mid) {
               r = mid - 1;
           } else {
               l = mid + 1;
           }
        }
        return r;
    }

    // 牛顿
    // xn+1 = xn - f(xn)/f'(xn)
    public int mySqrt1(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x/r) / 2;
        }
        return (int)r;
    }
}
