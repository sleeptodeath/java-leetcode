public class Solution {
    public double helper(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        if (n % 2 == 0)
            return helper(x*x, n>>>1);
        else
            return x * helper(x*x, n>>>1);
    }


    public double myPow(double x, int n) {
        if (n < 0)
            return helper(1/x, -n);
        else
            return helper(x, n);
    }
}
