import java.util.Arrays;

public class Solution {
    /*
        模拟乘法
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ret = new int[len1 + len2];
        Arrays.fill(ret, 0);

        // 逆置完后好做
        char[] cNum1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] cNum2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int c = 0; // 进位
        for (int i = 0; i < cNum1.length; i++) {
            int x = cNum1[i] - '0';
            c = 0;
            for (int j = 0; j < cNum2.length; j++) {
                int y = cNum2[j] - '0';
                int z = ret[i+j];
                ret[i+j]  = (x * y + c + z) % 10;
                c = (x * y + c + z)/ 10;
            }
            if (c > 0)
                ret[i + len2] = c;
        }
        StringBuilder sb = new StringBuilder();
        int i = len1+len2-1;
        while (i > 0 && ret[i] == 0)
            i--;
        while (i >= 0) {
            sb.append(ret[i]);
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("2", "3"));
    }
}
