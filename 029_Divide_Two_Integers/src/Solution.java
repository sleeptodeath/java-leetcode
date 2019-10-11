import com.sun.org.apache.bcel.internal.generic.LDIV;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(1, 1));
//        System.out.println(divide(7, -3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        int ret = 0;
        while (ldividend >= ldivisor) {
            long temp = ldivisor, multiple = 1;
            while(ldividend >= temp << 1) {
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            ret += multiple;
        }
        return (dividend < 0) ^ (divisor < 0) ? -ret: ret;
    }
}
